package com.example.bank.user.controller;

import com.example.bank.user.request.LoginRequest;
import com.example.bank.user.request.RegisterRequest;
import com.example.bank.user.response.UserResponse;
import com.example.bank.user.service.UserService;
import lombok.RequiredArgsConstructor;
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
    public UserResponse me(@RequestHeader("Authorization") String token){
        // Bearer token
        if (!token.startsWith("Bearer ")) throw new RuntimeException("토큰 틀림");
        return userService.getByToken(token.substring(7));
    }
}
