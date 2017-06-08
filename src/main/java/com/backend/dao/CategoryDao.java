package com.backend.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.backend.domain.Category;

@Mapper
public interface CategoryDao {

    Category findById(@Param("id") Long id);

    void add(Category Domain);

    void update(Category domain);

}
