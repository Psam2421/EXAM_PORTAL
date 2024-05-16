package com.categoryservice.services;

import java.util.LinkedHashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.categoryservice.Exception.CategoryFoundException;
import com.categoryservice.Exception.CategoryNotFoundException;
import com.categoryservice.model.Category;
import com.categoryservice.repository.CategoryRepository;


import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService{

	Logger log = LoggerFactory.getLogger(CategoryService.class);	
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category addCategory(Category category) throws Exception{
//    	if(categoryRepository.existsById(category.getCid()))
//    	{
//    		throw new CategoryFoundException("Category already exits");
//    	}
    	log.info("Category successfully saved!!");
        return this.categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
    	log.info("Category successfully updated!!");
        return this.categoryRepository.save(category);
    }

    @Override
    public Set<Category> getCategories() {
    	log.info("Category successfully retrieved!!");
        return new LinkedHashSet<>(this.categoryRepository.findAll());
    }

    @Override
    public Category getCategory(Long categoryId) throws Exception{
//    	if(!this.categoryRepository.findById(categoryId).isPresent())
//    	{
//    		throw new CategoryNotFoundException("Category not found!!");
//    	}
    	log.info("Category successfully retrieved!!");
        return this.categoryRepository.findById(categoryId).get();
    }

    @Override
    public void deleteCategory(Long categoryId) {
        Category category = new Category();
        category.setCid(categoryId);
        this.categoryRepository.delete(category);
        log.info("Category successfully deleted!!");
    }
}
