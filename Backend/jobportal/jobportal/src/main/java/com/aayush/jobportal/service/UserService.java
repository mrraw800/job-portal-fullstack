package com.aayush.jobportal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aayush.jobportal.model.User;
import com.aayush.jobportal.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

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

    public void deleteUser(Long id ){
        if(!userRepository.existsById(id)) {
            throw new RuntimeException("User not found");
        }
       userRepository.deleteById(id);
    }
}


