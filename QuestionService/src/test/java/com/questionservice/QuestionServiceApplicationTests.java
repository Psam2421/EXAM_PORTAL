
package com.questionservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.questionservice.model.Question;
import com.questionservice.model.Quiz;
import com.questionservice.repository.QuestionRepository;
import com.questionservice.services.QuestionServiceImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class QuestionServiceImplTest {

    @Mock
    private QuestionRepository questionRepository;

    @InjectMocks
    private QuestionServiceImpl questionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testAddQuestion() throws Exception{
        Question questionToAdd = new Question(); // create your question instance
        when(questionRepository.save(questionToAdd)).thenReturn(questionToAdd);

        Question addedQuestion = questionService.addQuestion(questionToAdd);

        assertEquals(questionToAdd, addedQuestion);
        verify(questionRepository, times(1)).save(questionToAdd);
    }

    @Test
    void testUpdateQuestion() {
        Question questionToUpdate = new Question(); // create your question instance
        when(questionRepository.save(questionToUpdate)).thenReturn(questionToUpdate);

        Question updatedQuestion = questionService.updateQuestion(questionToUpdate);

        assertEquals(questionToUpdate, updatedQuestion);
        verify(questionRepository, times(1)).save(questionToUpdate);
    }

    void testGetQuestions() {
        Set<Question> questions = new HashSet<>(); // create your set of questions
        when(questionRepository.findAll()).thenReturn(new ArrayList<>(questions)); // Convert Set to List

        Set<Question> retrievedQuestions = questionService.getQuestions();

        assertEquals(questions, retrievedQuestions);
        verify(questionRepository, times(1)).findAll();
    }


    @Test
    void testGetQuestion() throws Exception{
        Long questionId = 1L; // define a question ID
        Question question = new Question(); // create your question instance
        when(questionRepository.findById(questionId)).thenReturn(Optional.of(question));

        Question retrievedQuestion = questionService.getQuestion(questionId);

        assertEquals(question, retrievedQuestion);
        verify(questionRepository, times(1)).findById(questionId);
    }

    @Test
    void testGetQuestionsOfQuiz() {
        Quiz quiz = new Quiz(); // create your quiz instance
        Set<Question> questions = new HashSet<>(); // create your set of questions
        when(questionRepository.findByQuiz(quiz)).thenReturn(questions);

        Set<Question> sretrievedQuestions = questionService.getQuestionsOfQuiz(quiz);

        assertEquals(questions, sretrievedQuestions);
        verify(questionRepository, times(1)).findByQuiz(quiz);
    }

    @Test
    void testDeleteQuestion() {
        Long questionId = 1L; // define a question ID
        Question questionToDelete = new Question(); // create your question instance
        questionToDelete.setQuesId(questionId);

        questionService.deleteQuestion(questionId);

        verify(questionRepository, times(1)).delete(questionToDelete);
    }

    @Test
    void testGet() {
        Long questionId = 1L; // define a question ID
        Question question = new Question(); // create your question instance
        when(questionRepository.getOne(questionId)).thenReturn(question);

        Question retrievedQuestion = questionService.get(questionId);

        assertEquals(question, retrievedQuestion);
        verify(questionRepository, times(1)).getOne(questionId);
    }
}
