package com.backend.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.apache.commons.collections.CollectionUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.backend.domain.AbstractLongDomainEntity;

/**
 * @param T The domain object
 * @param D The dao interface. It's used for the sqlSession OBJECT_MAPPER
 */

public abstract class DaoImpl<T extends AbstractLongDomainEntity, D extends Dao<T>> implements Dao<T> {

    protected Class<D> daoImplClazz;

    @Autowired
    private SqlSession sqlSession;
    
    private D          dao;

    public DaoImpl(final Class<D> clazzDao) {
        this.daoImplClazz = clazzDao;
    }

    @PostConstruct
    protected void setDao() {
        dao = sqlSession.getMapper(daoImplClazz);
    }

    public D getDao() {
        return dao;
    }

    @Override
    public void add(final T domain) {
        if (domain.getVersion() == null) {
            domain.setVersion(1L);
        }
        // createdDate
        domain.setCreatedDate(new Date());
        dao.add(domain);
    }

    @Override
    public void add(final Iterable<T> domains) {
        for(final T domain : domains) { // FIXME batch sql insert
            add(domain);
        }
    }

    @Override
    public void update(final Iterable<T> domains) {
        for(final T domain : domains) {// FIXME batch sql update
            update(domain);
        }
    }

    @Override
    public void remove(final Iterable<T> domains) {
        Collection<Long> ids = new ArrayList<>();
        for(T t : domains) {
            ids.add(t.getId());
        }
        dao.removes(ids);
    }

    @Override
    public T findById(final Long id) {
        return dao.findById(id);
    }

    @Override
    public Collection<T> findByIds(final Collection<Long> ids) {
        return CollectionUtils.isEmpty(ids) ? Collections.<T> emptyList() : dao.findByIds(ids);
    }

    @Override
    public void update(final T domain) {
        if (domain.getVersion() == null) {
            domain.setVersion(1L);
        }
        domain.setUpdatedDate(new Date());
        dao.update(domain);
    }

    @Override
    public Collection<T> getAll() {
        return dao.getAll();
    }

    @Override
    public void remove(final Long id) {
        dao.remove(id);
    }

    @Override
    public void removes(Collection<Long> ids) {
        dao.removes(ids);
    }

    @Override
    public int count() {
        return dao.count();
    }

    @Override
    public Integer countWithFilters(final T domain) {
        return dao.countWithFilters(domain);
    }

    @Override
    public Collection<T> findByFields(final T domain) {
        return dao.findByFields(domain);
    }
}
