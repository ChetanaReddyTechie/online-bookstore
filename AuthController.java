package com.example.bookstore.controller;

import com.example.bookstore.model.UserRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
    private final ConcurrentHashMap<String, String> users = new ConcurrentHashMap<>();

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@Valid @RequestBody UserRequest request) {
        if (users.putIfAbsent(request.getEmail(), request.getPassword()) != null) {
            return ResponseEntity.badRequest().body(Map.of("message", "Email already registered."));
        }
        return ResponseEntity.ok(Map.of("message", "Signup successful! You can login now."));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody UserRequest request) {
        String password = users.get(request.getEmail());
        if (password == null || !password.equals(request.getPassword())) {
            return ResponseEntity.status(401).body(Map.of("message", "Invalid email or password."));
        }
        return ResponseEntity.ok(Map.of("message", "Login successful!", "name", request.getName()));
    }
}
