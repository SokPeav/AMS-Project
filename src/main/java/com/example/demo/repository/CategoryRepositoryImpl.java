//package com.example.demo.repository;
//
//import com.example.demo.model.Category;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class CategoryRepositoryImpl implements CategoryRepository {
//
//
//    List<Category> categories = new ArrayList<>();
//
//    CategoryRepositoryImpl() {
//        categories.add(new Category(1, "database"));
//        categories.add(new Category(2, "Java"));
//        categories.add(new Category(3, "SQL"));
//        categories.add(new Category(4, "Spring"));
//        categories.add(new Category(15, "Web"));
//
//
//    }
//
//    @Override
//    public List<Category> findall() {
//        return categories;
//    }
//
//    @Override
//    public Category findById(int id) {
//        for (int i = 0; i < categories.size(); i++) {
//            if (categories.get(i).getCate_id() == id) return categories.get(i);
//        }
//        return null;
//    }
//
//}
