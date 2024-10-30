package com.example.olxbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.olxbackend.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    // Znajdź kategorię na podstawie nazwy kategorii
    Category findByCategoryName(String categoryName);
}
