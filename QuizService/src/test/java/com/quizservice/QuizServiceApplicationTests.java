
package com.quizservice;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.quizservice.model.Category;
import com.quizservice.model.Quiz;
import com.quizservice.repository.QuizRepository;
import com.quizservice.services.QuizServiceImpl;

import java.util.*;


class QuizServiceImplTest {

    @Mock
    private QuizRepository quizRepository;

    @InjectMocks
    private QuizServiceImpl quizService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testAddQuiz() throws Exception{
        Quiz quizToAdd = new Quiz(); // create your quiz instance
        when(quizRepository.save(quizToAdd)).thenReturn(quizToAdd);

        Quiz addedQuiz = quizService.addQuiz(quizToAdd);

        assertEquals(quizToAdd, addedQuiz);
        verify(quizRepository, times(1)).save(quizToAdd);
    }

    @Test
    void testUpdateQuiz() {
        Quiz quizToUpdate = new Quiz(); // create your quiz instance
        when(quizRepository.save(quizToUpdate)).thenReturn(quizToUpdate);

        Quiz updatedQuiz = quizService.updateQuiz(quizToUpdate);

        assertEquals(quizToUpdate, updatedQuiz);
        verify(quizRepository, times(1)).save(quizToUpdate);
    }


    @Test
    void testGetQuizzes() {
        Set<Quiz> quizzes = new HashSet<>(); // create your set of quizzes
        when(quizRepository.findAll()).thenAnswer(invocation -> new ArrayList<>(quizzes));

        Set<Quiz> retrievedQuizzes = quizService.getQuizzes();

        assertEquals(quizzes, retrievedQuizzes);
        verify(quizRepository, times(1)).findAll();
    }

    @Test
    void testGetQuiz() throws Exception{
        Long quizId = 1L; // define a quiz ID
        Quiz quiz = new Quiz(); // create your quiz instance
        when(quizRepository.findById(quizId)).thenReturn(Optional.of(quiz));

        Quiz retrievedQuiz = quizService.getQuiz(quizId);

        assertEquals(quiz, retrievedQuiz);
        verify(quizRepository, times(1)).findById(quizId);
    }

    @Test
    void testDeleteQuiz() {
        Long quizId = 1L; // define a quiz ID

        quizService.deleteQuiz(quizId);

        verify(quizRepository, times(1)).deleteById(quizId);
    }

    @Test
    void testGetQuizzesOfCategory() {
        Category category = new Category(); // create your category instance
        List<Quiz> quizzes = new ArrayList<>(); // create your list of quizzes
        when(quizRepository.findBycategory(category)).thenReturn(quizzes);

        List<Quiz> retrievedQuizzes = quizService.getQuizzesOfCategory(category);

        assertEquals(quizzes, retrievedQuizzes);
        verify(quizRepository, times(1)).findBycategory(category);
    }

    @Test
    void testGetActiveQuizzes() {
        List<Quiz> activeQuizzes = new ArrayList<>(); // create your list of active quizzes
        when(quizRepository.findByActive(true)).thenReturn(activeQuizzes);

        List<Quiz> retrievedActiveQuizzes = quizService.getActiveQuizzes();

        assertEquals(activeQuizzes, retrievedActiveQuizzes);
        verify(quizRepository, times(1)).findByActive(true);
    }

    @Test
    void testGetActiveQuizzesOfCategory() {
        Category category = new Category(); // create your category instance
        List<Quiz> activeQuizzes = new ArrayList<>(); // create your list of active quizzes
        when(quizRepository.findByCategoryAndActive(category, true)).thenReturn(activeQuizzes);

        List<Quiz> retrievedActiveQuizzes = quizService.getActiveQuizzesOfCategory(category);

        assertEquals(activeQuizzes, retrievedActiveQuizzes);
        verify(quizRepository, times(1)).findByCategoryAndActive(category, true);
    }
}
