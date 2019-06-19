package com.example.demo.repository;

import com.example.demo.Provider.CategoryProvider;
import com.example.demo.Utility.Paging;
import com.example.demo.model.Category;
import com.example.demo.model.Filter;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository {


    @SelectProvider(method="findAll",type = CategoryProvider.class)
    List<Category> findall();

    @SelectProvider(method="findAll",type = CategoryProvider.class)
    Category findById(int id);

    @SelectProvider(method = "deleteCategory" , type = CategoryProvider.class)
    void delete(Integer id);


    @SelectProvider(method = "updateCategory" , type = CategoryProvider.class)
    void update(Category category);


    @SelectProvider(method = "addCategory",type = CategoryProvider.class)
    void add(Category category);






}
