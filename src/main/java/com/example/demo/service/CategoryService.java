package com.example.demo.service;

import com.example.demo.Utility.Paging;
import com.example.demo.model.Category;
import com.example.demo.model.Filter;

import java.util.List;

public interface CategoryService {
    List<Category> findall();
    Category findById(int id);
    void delete(int id);
    void update(Category category);
    void add(Category category);


}
