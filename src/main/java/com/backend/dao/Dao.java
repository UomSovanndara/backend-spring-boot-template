package com.backend.dao;

import java.util.Collection;

import org.apache.ibatis.annotations.Param;

public interface Dao<T> {

    T findById(@Param("id") Long id);

    Collection<T> findByIds(@Param("list") Collection<Long> ids);

    void add(T domain);

    void add(Iterable<T> domains);

    void update(T domain);

    void update(Iterable<T> domains);

    Collection<T> getAll();

    void remove(@Param("id") Long id);

    void removes(@Param("list") Collection<Long> ids);

    void remove(Iterable<T> domains);

    int count();

    Integer countWithFilters(@Param("domain") T domain);

    Collection<T> findByFields(@Param("domain") T domain);
}
