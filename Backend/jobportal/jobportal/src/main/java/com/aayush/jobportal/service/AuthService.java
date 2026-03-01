package com.aayush.jobportal.service;

import com.aayush.jobportal.dto.AuthRequest;
import com.aayush.jobportal.dto.AuthResponse;
import com.aayush.jobportal.model.User;

public interface AuthService {

    AuthResponse register(User user);

    AuthResponse login(AuthRequest request);
}