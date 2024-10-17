package com.example.bank.global;

import org.junit.jupiter.api.Test;

class JwtUtilsTest {
// spring 안 쓰는 코드니까 빠른 테스트 가능
    @Test
    void generateToken() {
        JwtUtils jwtUtils = new JwtUtils(1000 * 60, "sdlfjqefsldkfsadkfnakwejffaldkjfhasdufbwjeshsbcvusebsdfabekufsmnbvsehrq231jh2j4k13251b23123k12j4123");
        String token = jwtUtils.generateToken("hello");
        System.out.println(token);
    }

}