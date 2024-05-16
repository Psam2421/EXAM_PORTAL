package com.categoryservice.services;

import java.util.Set;

import com.categoryservice.model.Category;

public interface CategoryService {


    public Category addCategory(Category category) throws Exception;

    public Category updateCategory(Category category);

    public Set<Category> getCategories();

    public Category getCategory(Long categoryId) throws Exception;

    public void deleteCategory(Long categoryId);
}


