package com.aayush.jobportal.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.aayush.jobportal.config.JwtService;
import com.aayush.jobportal.dto.LoginRequest;
import com.aayush.jobportal.model.User;
import com.aayush.jobportal.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    // ==============================
    // REGISTER USER
    // ==============================
    public String register(User user) {

        // Encrypt password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);

        return "User Registered Successfully";
    }

    // ==============================
    // LOGIN USER
    // ==============================
    public String login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        // Generate JWT token
        return jwtService.generateToken(user.getEmail());
    }

    // ==============================
    // CRUD OPERATIONS
    // ==============================

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User updateUser(Long id, User updatedUser) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());

        return userRepository.save(user);
    }

    public void deleteUser(Long id) {

        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found");
        }

        userRepository.deleteById(id);
    }
}