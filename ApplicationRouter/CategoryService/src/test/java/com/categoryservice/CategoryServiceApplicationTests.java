
package com.categoryservice;
import static org.junit.jupiter.api.Assertions.assertFalse;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.categoryservice.model.Category;
import com.categoryservice.repository.CategoryRepository;
import com.categoryservice.services.CategoryServiceImpl;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CategoryServiceImplTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryServiceImpl categoryService;

    @BeforeEach
    void setUp() {
    	MockitoAnnotations.initMocks(this);;
    }

    @Test
    void testAddCategory() throws Exception{
        Category categoryToAdd = new Category(); // create your category instance
        when(categoryRepository.save(categoryToAdd)).thenReturn(categoryToAdd);

        Category addedCategory = categoryService.addCategory(categoryToAdd);

        assertEquals(categoryToAdd, addedCategory);
        verify(categoryRepository, times(1)).save(categoryToAdd);
    }

    @Test
    void testUpdateCategory() {
        Category categoryToUpdate = new Category(); // create your category instance
        when(categoryRepository.save(categoryToUpdate)).thenReturn(categoryToUpdate);

        Category updatedCategory = categoryService.updateCategory(categoryToUpdate);

        assertEquals(categoryToUpdate, updatedCategory);
        verify(categoryRepository, times(1)).save(categoryToUpdate);
    }

    @Test
    void testGetCategories() {
        Set<Category> categories = new LinkedHashSet<>(); // create your set of categories
        // Convert Set<Category> to List<Category>
        List<Category> categoriesList = new ArrayList<>(categories);
        when(categoryRepository.findAll()).thenReturn(categoriesList);

        Set<Category> retrievedCategories = categoryService.getCategories();

        assertEquals(categories, retrievedCategories);
        verify(categoryRepository, times(1)).findAll();
    }



    @Test
    void testGetCategory() throws Exception{
        Long categoryId = 1L; // define a category ID
        Category category = new Category(); // create your category instance
        when(categoryRepository.findById(categoryId)).thenReturn(Optional.of(category));

        Category retrievedCategory = categoryService.getCategory(categoryId);

        assertEquals(category, retrievedCategory);
        verify(categoryRepository, times(1)).findById(categoryId);
    }

    @Test
    void testDeleteCategory() {
        // Arrange
        Long categoryId = 1L;
        Category categoryToDelete = new Category();
        categoryToDelete.setCid(categoryId);

        // Mock behavior
        when(categoryRepository.existsById(categoryId)).thenReturn(true);

        // Act
        categoryService.deleteCategory(categoryId);

        // Assert
        verify(categoryRepository, times(1)).delete(categoryToDelete);
        verify(categoryRepository, times(1)).existsById(categoryId); // Verify existence check
        assertFalse(categoryRepository.existsById(categoryId), "Category should be deleted"); // Verify deletion
    }

}
