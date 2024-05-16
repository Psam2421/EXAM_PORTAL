package com.questionservice.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.questionservice.model.Question;
import com.questionservice.model.Quiz;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    Set<Question> findByQuiz(Quiz quiz);

	Question findByContent(String content);
}
