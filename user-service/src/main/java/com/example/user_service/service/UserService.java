package com.example.user_service.service;

import com.example.user_service.dto.UserResponse;
import com.example.user_service.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public UserResponse getUserById(Long userId) {
        if (userId == null || userId < 1) {
            throw new UserNotFoundException(userId);
        }

        return new UserResponse(userId, "User " + userId, "user" + userId + "@example.com");
    }
}
