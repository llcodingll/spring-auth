package com.example.bank.user.request;

import com.example.bank.user.domain.User;

public record RegisterRequest(
        String email,
        String password,
        String username
) {
    public User toEntity() {
        return User.builder()
                .username(username)
                .email(email)
                .password(password)
                .build();
    }
}
