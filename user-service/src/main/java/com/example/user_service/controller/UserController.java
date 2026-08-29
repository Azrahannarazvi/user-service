package com.example.user_service.controller;

import com.example.user_service.dto.UserResponse;
import com.example.user_service.service.UserService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Value("${app.message}")
    private String appMessage;

    @Value("${app.timeout}")
    private int appTimeout;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {

        UserResponse response = userService.getUserById(id);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/config")
    public String getConfig() {
        return "Message: " + appMessage + ", Timeout: " + appTimeout;
    }
}
