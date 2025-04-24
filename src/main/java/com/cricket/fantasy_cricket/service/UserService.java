package com.cricket.fantasy_cricket.service;

import com.cricket.fantasy_cricket.entity.User;
import com.cricket.fantasy_cricket.exception.UserException;
import com.cricket.fantasy_cricket.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final JwtService jwtService;

    public User registerUser(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new UserException("User already exists");
        }
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    public String login(String email, String password) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        if (!password.equals(user.getPassword())) {
            throw new RuntimeException("Wrong password");
        }

        return jwtService.generateToken(
                new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>())
        );
    }

}

