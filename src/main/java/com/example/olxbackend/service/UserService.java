package com.example.olxbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.olxbackend.entity.User;
import com.example.olxbackend.repository.UserRepository;
import java.util.Optional;

@Service  // Adnotacja oznaczająca, że klasa jest serwisem zarządzanym przez Spring
public class UserService {

    @Autowired  // Automatyczne wstrzyknięcie zależności repozytorium
    private UserRepository userRepository;

    // Metoda do rejestracji nowego użytkownika
    public User registerUser(User user) {
        // Można tu dodać walidację (np. czy użytkownik już istnieje)
        return userRepository.save(user);  // Zapisuje nowego użytkownika do bazy
    }

    // Metoda do wyszukiwania użytkownika po nazwie użytkownika (username)
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // Metoda do znalezienia użytkownika po jego ID
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
}
