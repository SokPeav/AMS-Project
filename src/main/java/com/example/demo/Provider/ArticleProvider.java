package com.example.demo.Provider;

import com.example.demo.Utility.Paging;
import com.example.demo.model.Article;
import com.example.demo.model.Category;
import com.example.demo.model.Filter;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class ArticleProvider {

    public String findAll(Integer id) {
        return new SQL() {{
            SELECT("a.id, a.title, a.description, a.thumbnail,a.created_date, a.author,c.cate_id, c.cate_name");
            FROM("article a");
            INNER_JOIN("category c ON a.cate_id = c.cate_id");
            if (id != null) {
                WHERE("id = " + id);
            }
            ORDER_BY("id");
        }}.toString();
    }

    public String add(Article article) {
        return new SQL() {{
            INSERT_INTO("article");
            VALUES("title", "'" + article.getTitle() + "'");
            VALUES("description", "'" + article.getDescription() + "'");
            VALUES("author", "'" + article.getAuthor() + "'");
            VALUES("thumbnail", "'" + article.getImage() + "'");
            VALUES("cate_id", "'" + article.getCategory().getCate_id() + "'");
        }}.toString();
    }

    public String deleteById(Integer id) {
        return new SQL() {{
            DELETE_FROM("article");
            WHERE("id = " + id);
        }}.toString();
    }

    public String updateArticle(Article article) {
        return new SQL() {{
            UPDATE("article");
            SET("title = '" + article.getTitle() + "'");
            SET("description =  '" + article.getDescription() + "'");
            SET("author = '" + article.getAuthor() + "'");
            SET("thumbnail = '" + article.getImage() + "'");
            SET("cate_id = '" + article.getCategory().getCate_id() + "'");
            WHERE("id = " + article.getId());
        }}.toString();
    }

    public String searchArticle(Filter filter) {
        return new SQL() {{
            SELECT("*");
            FROM("article");
            WHERE("title ILIKE '% " + filter + " %' ");
        }}.toString();
    }

    public String findAllFilter(@Param("filter") Filter filter, @Param("paging") Paging paging) {
        return new SQL() {{
            SELECT("a.id, a.title,a.description,a.author,a.thumbnail,a.created_date, c.cate_id, c.cate_name");
            FROM("article a");
            INNER_JOIN("category c ON a.cate_id = c.cate_id");

            if (filter.getTitle() != null) {
                WHERE("a.title ILIKE '%' || #{filter.title} || '%'");
            }
            if (filter.getCate_id() != null) {
                WHERE("a.cate_id = #{filter.cate_id}");
            }

            ORDER_BY("a.id ASC LIMIT #{paging.limit} OFFSET #{paging.offset}");
        }}.toString();
    }

    public String findOne(Integer id) {
        return new SQL() {{
            SELECT("a.id, a.title,a.description,a.author,a.thumbnail,a.created_date, c.cate_id, c.cate_name");
            FROM("article a");
            INNER_JOIN("category c ON a.cate_id = c.cate_id");
            WHERE("id = " + id);
        }}.toString();
    }


    public String countAll(Filter filter) {
        return new SQL() {{

            SELECT("COUNT(id)");
            FROM("article");
            if (filter.getTitle() != null) {
                WHERE("title ILIKE '%' || #{title} || '%'");
            }
            if (filter.getCate_id() != null) {
                WHERE("cate_id = #{cate_id}");
            }

        }}.toString();
    }
}
