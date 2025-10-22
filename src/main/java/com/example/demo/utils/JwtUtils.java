package com.example.demo.utils;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtils {
    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    private final long expirationTime = 3 * 24 * 60 * 60 * 1000;

    public String generateToken(String first_name) {
        return Jwts.builder().setSubject(first_name).setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime)).signWith(key).compact();
    }

    // public String getUsernameFromToken(String token) {
    //     return Jwts.parseBuilder().setSigninKey(key).build().parseClaimsJws(token).getBody().getSubject();
    // }
}
