package com.quizservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quizservice.model.Category;
import com.quizservice.model.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
    public List<Quiz> findBycategory(Category category);

    public List<Quiz> findByActive(Boolean b);

    public List<Quiz> findByCategoryAndActive(Category c, Boolean b);

	public Quiz findByTitle(String title);
}
