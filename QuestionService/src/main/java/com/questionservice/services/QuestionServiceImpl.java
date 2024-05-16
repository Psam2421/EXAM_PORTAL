package com.questionservice.services;
 
import java.util.HashSet;
import java.util.Set;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.questionservice.Exception.QuestionAlreadyExistException;
import com.questionservice.Exception.QuestionNotFoundException;
import com.questionservice.model.Question;
import com.questionservice.model.Quiz;
import com.questionservice.repository.QuestionRepository;
 
import lombok.extern.slf4j.Slf4j;
 
@Service
@Slf4j
public class QuestionServiceImpl implements QuestionService {
 
	Logger log = LoggerFactory.getLogger(QuestionService.class);
    @Autowired
    private QuestionRepository questionRepository;
 
    @Override
    public Question addQuestion(Question question) throws Exception{
    	if(questionRepository.findByContent(question.getContent())!=null)
    	{
    		throw new QuestionAlreadyExistException("Question already exits");
    	}
    	log.info("Question successfully saved !!");
        return this.questionRepository.save(question);
    }
 
    @Override
    public Question updateQuestion(Question question) {
    	log.info("Question successfully updated !!");
        return this.questionRepository.save(question);
    }
 
    @Override
    public Set<Question> getQuestions() {
    	log.info("Question successfully retrieved !!");
        return new HashSet<>(this.questionRepository.findAll());
    }
 
    @Override
    public Question getQuestion(Long questionId) throws Exception {
    	if(! this.questionRepository.findById(questionId).isPresent())
    	{
    		throw new QuestionNotFoundException("Question not found !!");
    	}
    	log.info("Question successfully retrieved !!");
        return this.questionRepository.findById(questionId).get();
    }
 
    @Override
    public Set<Question> getQuestionsOfQuiz(Quiz quiz) {
    	log.info("Question successfully retrieved !!");
        return this.questionRepository.findByQuiz(quiz);
    }
 
    @Override
    public void deleteQuestion(Long quesId) {
        Question question = new Question();
        question.setQuesId(quesId);
        this.questionRepository.delete(question);
        log.info("Question successfully deleted !!");
    }
 
    @Override
    public Question get(Long questionsId) {
    	log.info("Question successfully retrieved !!");
       return this.questionRepository.getOne(questionsId);
    }
}