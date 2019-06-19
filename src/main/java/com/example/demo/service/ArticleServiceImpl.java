package com.example.demo.service;

import com.example.demo.Utility.Paging;
import com.example.demo.model.Article;
import com.example.demo.model.Filter;
import com.example.demo.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    private ArticleRepository articleRepository;

    @Override
    public void add(Article article) {
        article.setCreatedDate(new Date().toString());
        articleRepository.add(article);
    }

    @Override
    public void update(Article article) {
        article.setCreatedDate(new Date().toString());
        articleRepository.update(article);
    }

    @Override
    public List<Article> findAllFilter(Filter filter, Paging paging) {
        paging.setCount(articleRepository.countAll(filter));
        return articleRepository.findAllFilter(filter,paging);
    }

    @Override
    public List<Article> search(Filter filter) {
        return articleRepository.search(filter);
    }

    @Override
    public void delete(int id) {
      articleRepository.delete(id);
    }

    @Autowired
    public void setArticleRepository(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    @Override
    public Article findById(int id) {
        return articleRepository.findById(id);
    }
}
