package com.example.demo.Provider;

import com.example.demo.model.Category;
import com.example.demo.model.Filter;
import org.apache.ibatis.jdbc.SQL;

public class CategoryProvider {

    public String findAll(Integer id) {
        return new SQL() {{
            SELECT("*");
            FROM("category");
            if (id != null) {
                WHERE("cate_id = " + id);
            }
            ORDER_BY("cate_id");
        }}.toString();
    }

    public String deleteCategory(Integer id) {
        return new SQL() {{

            DELETE_FROM("category");
            WHERE("cate_id = #{id}" );

        }}.toString();
    }

    public String updateCategory(Category category) {
        return new SQL() {{
            UPDATE("category");
            SET("cate_name = '" + category.getCate_name() + "'");
            WHERE("cate_id = " + category.getCate_id());

        }}.toString();
    }

    public String addCategory(Category category) {
        return new SQL() {{
            INSERT_INTO("category");
            VALUES("cate_name", "'" + category.getCate_name() + "'");

        }}.toString();
    }
}
