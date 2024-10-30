package com.example.olxbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.example.olxbackend.entity.Ad;

public interface AdRepository extends JpaRepository<Ad, Long> {
    // Znajdź wszystkie ogłoszenia powiązane z użytkownikiem
    List<Ad> findByUserUserId(Long userId);
}
