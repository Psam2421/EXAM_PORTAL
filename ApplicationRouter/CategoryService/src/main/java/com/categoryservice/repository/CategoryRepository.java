package com.categoryservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.categoryservice.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
