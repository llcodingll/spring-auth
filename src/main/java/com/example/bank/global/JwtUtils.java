package com.example.bank.global;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;

public class JwtUtils {
    // generate-token
    public String generateToken(String username) {
//        long expiration = 1000 * 60 * 60 * 24;
        long expiration = 30000;
        Date expirationDate = new Date(System.currentTimeMillis() + expiration);
        String secret = "qkdoqjbvjspfpekfnlfaldocfubwhelqkenfgakqjehudbsfsjdhf29404017303rhsdkkh87284949201009284ubdjskd123";
        Key key = Keys.hmacShaKeyFor(secret.getBytes());
        return Jwts.builder()
                .subject(username)
                .expiration(expirationDate)
                .signWith(key)
                .compact();
    }

    // parse-token
    public String parseToken(String token) {
        String secret = "qkdoqjbvjspfpekfnlfaldocfubwhelqkenfgakqjehudbsfsjdhf29404017303rhsdkkh87284949201009284ubdjskd123";
        SecretKey key = Keys.hmacShaKeyFor(secret.getBytes());
        Claims payload = (Claims) Jwts.parser() //Object가 뜨니까 강제 형변환 해서 긁어오기
                .verifyWith(key)
                .build()
                .parse(token)
                .getPayload();
        return payload.getSubject();
    }
}
