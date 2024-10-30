package com.example.olxbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.olxbackend.entity.Category;
import com.example.olxbackend.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    // Metoda do pobierania wszystkich kategorii
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    // Metoda do dodania nowej kategorii
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    // Metoda do wyszukiwania kategorii po nazwie
    public Category findByCategoryName(String categoryName) {
        return categoryRepository.findByCategoryName(categoryName);
    }
}
