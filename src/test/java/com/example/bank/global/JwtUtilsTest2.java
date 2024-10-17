package com.example.bank.global;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
class JwtUtilsTest2 {
    @Value("${jwt.secret")
    String secret;

    @Test
    void test() {
        assertEquals("dlsdkfjefwpefskdlfjweijf12l3k12njk12n31l2kjlkfvlasdknvsofjlqk2j412952u23l4k3s89", secret);
    }
}