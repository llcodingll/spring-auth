package com.example.bank.user.controller;

import com.example.bank.user.domain.User;
import com.example.bank.user.request.LoginRequest;
import com.example.bank.user.request.RegisterRequest;
import com.example.bank.user.response.UserResponse;
import com.example.bank.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/api/v1/auth/login")
    public String login(
            @RequestBody LoginRequest loginRequest
    ) {
        return userService.login(loginRequest);
    }

    @PostMapping("/api/v1/auth/register")
    public void register(
            @RequestBody RegisterRequest registerRequest
    ) {
        userService.register(registerRequest);
    }

    @GetMapping("/api/v1/auth/me")
    public UserResponse me(@AuthenticationPrincipal User user){
        return UserResponse.from(user);
    }
}
