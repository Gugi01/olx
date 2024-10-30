package com.example.olxbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.example.olxbackend.entity.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {
    // Znajdź wszystkie zdjęcia powiązane z ogłoszeniem
    List<Image> findByAdAdId(Long adId);
}
