package com.cricket.fantasy_cricket.controller;

import com.cricket.fantasy_cricket.entity.User;
import com.cricket.fantasy_cricket.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        return ResponseEntity.ok(userService.registerUser(user));
    }

    @GetMapping
    public List<User> getAll() {
        return userService.getAllUsers();
    }

    @PostMapping("/login")
    @CrossOrigin
    public ResponseEntity<?> login(@RequestBody Map<String, String> payload) {
        String token = userService.login(payload.get("email"), payload.get("password"));
        return ResponseEntity.ok(Collections.singletonMap("token", token));
    }

}

