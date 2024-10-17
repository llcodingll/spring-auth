package com.example.bank.global;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JwtUtilsTest {
// spring 안 쓰는 코드니까 빠른 테스트 가능
    @Test
    void generateToken() {
        JwtUtils jwtUtils = new JwtUtils();
        String token = jwtUtils.generateToken("hello");
        System.out.println(token);
    }

    @Test
    void parseToken() {
        JwtUtils jwtUtils = new JwtUtils();

        String token = jwtUtils.parseToken("eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJoZWxsbyIsImV4cCI6MTcyOTEzOTg1NX0.0H-1sXS1vGDqq-r_-YXG3oWbBZboJZFFrhQuL614Fgs0Q_h5GtWxpoLuiFurvDkIayC0cEhEm2VkeKO4BUHkIA");
        System.out.println(token);
    }
}