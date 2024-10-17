package com.example.bank.user.response;

import com.example.bank.user.domain.User;

public record UserResponse(
        Long id,
        String username
) {
    public static UserResponse from(User user){
        return new UserResponse(user.getId(), user.getUsername());
    }
}
