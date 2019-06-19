package com.example.demo.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Article {


    private Integer id;

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @NotBlank
    private String author;


    private String image;
    private String createdDate;
    private Category category;

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", author='" + author + '\'' +
                ", image='" + image + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", category=" + category +
                '}';
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    public Article() {
    }

    public Article(Integer id, String title,Category category, String description, String author, String image, String createdDate) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.description = description;
        this.author = author;
        this.image = image;
        this.createdDate = createdDate;
    }

    public Article(Integer id, @NotBlank String title, @NotBlank String description, @NotBlank @Size(min = 2, max = 5) String author, String image, String createdDate, Category category) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.author = author;
        this.image = image;
        this.createdDate = createdDate;
        this.category = category;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getAuthor() {
        return author;
    }

    public String getCreatedDate() {
        return createdDate;
    }

}
