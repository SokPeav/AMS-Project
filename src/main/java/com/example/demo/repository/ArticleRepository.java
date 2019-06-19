package com.example.demo.repository;

import com.example.demo.Utility.Paging;
import com.example.demo.model.Article;
import com.example.demo.model.Filter;
import com.example.demo.Provider.ArticleProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ArticleRepository {


    @SelectProvider(method = "findAll", type = ArticleProvider.class)
    @Results({
            @Result(property = "image", column = "thumbnail"),
            @Result(property = "createdDate", column = "created_date"),
            @Result(property = "category.cate_id", column = "cate_id"),
            @Result(property = "category.cate_name", column = "cate_name")
    })
    List<Article> findAll();


    @SelectProvider(method = "findOne", type = ArticleProvider.class)
    @Results({
            @Result(property = "image", column = "thumbnail"),
            @Result(property = "createdDate", column = "created_date"),
            @Result(property = "category.cate_id", column = "cate_id"),
            @Result(property = "category.cate_name", column = "cate_name")
    })
    Article findById(int id);


    @SelectProvider(method = "add", type = ArticleProvider.class)
    void add(Article article);

    @SelectProvider(method = "deleteById", type = ArticleProvider.class)
    @Results({
            @Result(property = "image", column = "thumbnail"),
            @Result(property = "createdDate", column = "created_date"),
    })
    void delete(int id);


    @SelectProvider(method = "updateArticle", type = ArticleProvider.class)
    @Results({
            @Result(property = "image", column = "thumbnail"),
            @Result(property = "createdDate", column = "created_date"),
    })
    void update(Article article);


    @SelectProvider(method = "searchArticle", type = ArticleProvider.class)
    @Results({
            @Result(property = "image", column = "thumbnail"),
            @Result(property = "createdDate", column = "created_date"),
    })
    List<Article> search(Filter filter);



    @SelectProvider(method = "findAllFilter", type = ArticleProvider.class)
    @Results({
            @Result(property = "image", column = "thumbnail"),
            @Result(property = "createdDate", column = "created_date"),
            @Result(property = "category.cate_id", column = "cate_id"),
            @Result(property = "category.cate_name", column = "cate_name")
    })
    List<Article> findAllFilter(@Param("filter") Filter filter,@Param("paging") Paging paging);



    @SelectProvider(method = "countAll", type = ArticleProvider.class)
    Integer countAll(Filter filter);


}
