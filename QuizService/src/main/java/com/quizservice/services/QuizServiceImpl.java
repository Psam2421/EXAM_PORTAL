package com.quizservice.services;
 
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.quizservice.Exception.QuizFoundException;
import com.quizservice.Exception.QuizNotFoundException;
import com.quizservice.model.Category;
import com.quizservice.model.Quiz;
import com.quizservice.repository.QuizRepository;
 
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
 
@Service
@Transactional
@Slf4j
public class QuizServiceImpl implements QuizService {
	Logger log = LoggerFactory.getLogger(QuizServiceImpl.class);
    @Autowired
    private QuizRepository quizRepository;
 
    @Override
    public Quiz addQuiz(Quiz quiz) throws Exception{
    	if (quizRepository.findByTitle(quiz.getTitle())!= null) {
    	    throw new QuizFoundException("Quiz already exists.");
    	}
    	log.info("Quiz successfully saved !!");
        return this.quizRepository.save(quiz);
    }
 
    @Override
    public Quiz updateQuiz(Quiz quiz) {
    	log.info("Quiz successfully updated!!");
        return this.quizRepository.save(quiz);
    }
 
    @Override
    public Set<Quiz> getQuizzes() {
    	log.info("Quizzes successfully saved !!");
        return new HashSet<>(this.quizRepository.findAll());
    }
 
    @Override
    public Quiz getQuiz(Long quizId) throws Exception{
    	if(this.quizRepository.findById(quizId).isPresent())
    	{
    		log.info("Quiz successfully retrieved !!");
    		
            return this.quizRepository.findById(quizId).get();
    	}else {
    		throw new QuizNotFoundException("Quiz with ID "+ quizId +" not found.");
 
    	}	
    }
 
    @Override
    public void deleteQuiz(Long quizId) {
    	log.info("Quiz successfully deleted !!");
        this.quizRepository.deleteById(quizId);
    }
 
    @Override
    public List<Quiz> getQuizzesOfCategory(Category category) {
        return this.quizRepository.findBycategory(category);
    }
 
 
    //get active quizzes
 
    @Override
    public List<Quiz> getActiveQuizzes() {
    	log.info("Quiz successfully retrieved !!");
        return this.quizRepository.findByActive(true);
    }
 
    @Override
    public List<Quiz> getActiveQuizzesOfCategory(Category c) {
    	log.info("Quiz successfully retrieved !!");
        return this.quizRepository.findByCategoryAndActive(c, true);
    }
    }