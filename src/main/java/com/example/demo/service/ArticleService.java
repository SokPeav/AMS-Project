package com.example.demo.service;

import com.example.demo.Utility.Paging;
import com.example.demo.model.Article;
import com.example.demo.model.Filter;

import java.util.List;

public interface ArticleService {

    List<Article> findAll();
    Article findById(int id);
    void add(Article article);
    void delete(int id);
    void update(Article article);
    List<Article> search(Filter filter);
    List<Article> findAllFilter(Filter filter, Paging paging);


}
