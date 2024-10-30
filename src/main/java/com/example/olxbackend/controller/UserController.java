package com.example.olxbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.olxbackend.entity.User;
import com.example.olxbackend.service.UserService;
import java.util.Optional;

@RestController  // Oznacza, że ta klasa obsługuje żądania HTTP
@RequestMapping("/users")  // Bazowy URL dla tego kontrolera
public class UserController {

    @Autowired
    private UserService userService;

    // Endpoint do rejestracji nowego użytkownika (POST /users/register)
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User newUser = userService.registerUser(user);
        return ResponseEntity.ok(newUser);
    }

    // Endpoint do pobierania użytkownika po nazwie użytkownika (GET /users/{username})
    @GetMapping("/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        Optional<User> user = userService.findByUsername(username);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
