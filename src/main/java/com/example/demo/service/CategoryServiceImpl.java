package com.example.demo.service;

import com.example.demo.Utility.Paging;
import com.example.demo.model.Category;
import com.example.demo.model.Filter;
import com.example.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {



    private CategoryRepository categoryRepository;

    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void delete(int id) {
        this.categoryRepository.delete(id);
    }

    @Override
    public void add(Category category) {
        this.categoryRepository.add(category);
    }

    @Override
    public void update(Category category) {
    this.categoryRepository.update(category);
    }


    @Override
    public Category findById(int id) {
       return categoryRepository.findById(id);
    }
    @Override
    public List<Category> findall() {
        return categoryRepository.findall();
    }

}
