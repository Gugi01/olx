package com.example.olxbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import com.example.olxbackend.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    // Znajdź użytkownika na podstawie nazwy użytkownika (username)
    Optional<User> findByUsername(String username);
}