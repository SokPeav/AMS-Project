//package com.example.demo.repository;
//
//import com.example.demo.model.Article;
//import com.github.javafaker.Faker;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//@Repository
//public class ArticleRepositoryImpl implements ArticleRepository {
//
//    List<Article> articles = new ArrayList<>();
//
//    @Override
//    public void add(Article article) {
//        articles.add(article);
//    }
//
//    public ArticleRepositoryImpl() {
//        Faker faker = new Faker();
//        for (int i = 1; i < 10; i++) {
//            articles.add(new Article(i, faker.book().title(), faker.book().genre(), faker.book().author(), faker.avatar().image(), new Date().toString()));
//
//        }
//    }
//
//    @Override
//    public void update(Article article) {
//        for (int i = 0; i < articles.size(); i++) {
//            if (articles.get(i).getId() == article.getId())
//                articles.set(i, article);
//        }
//    }
//
//    @Override
//    public void delete(int id) {
//        for (int i = 0; i < articles.size(); i++) {
//            if (articles.get(i).getId() == id)
//                articles.remove(i);
//        }
//    }
//
//    @Override
//    public List<Article> findAll() {
//        return articles;
//    }
//
//    @Override
//    public Article findById(int id) {
//        for (int i = 0; i < articles.size(); i++) {
//            if (articles.get(i).getId() == id)
//                return articles.get(i);
//        }
//        return null;
//    }
//}
