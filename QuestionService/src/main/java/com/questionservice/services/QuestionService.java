package com.questionservice.services;

import java.util.Set;

import com.questionservice.model.Question;
import com.questionservice.model.Quiz;

public interface QuestionService {

    public Question addQuestion(Question question) throws Exception;

    public Question updateQuestion(Question question);

    public Set<Question> getQuestions();

    public Question getQuestion(Long questionId) throws Exception;

    public Set<Question> getQuestionsOfQuiz(Quiz quiz);

    public void deleteQuestion(Long quesId);

    public Question get(Long questionsId);

}
