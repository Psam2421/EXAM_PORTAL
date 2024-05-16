package com.quizservice.services;

import java.util.List;
import java.util.Set;

import com.quizservice.model.Category;
import com.quizservice.model.Quiz;

public interface QuizService {

    public Quiz addQuiz(Quiz quiz) throws Exception;

    public Quiz updateQuiz(Quiz quiz);

    public Set<Quiz> getQuizzes();

    public Quiz getQuiz(Long quizId) throws Exception;

    public void deleteQuiz(Long quizId);


    public List<Quiz> getQuizzesOfCategory(Category category);

    public List<Quiz> getActiveQuizzes();

    public List<Quiz> getActiveQuizzesOfCategory(Category c);

}
