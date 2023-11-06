package com.example.Brillonconnectz.TaskQuestionOne;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JWTGenerator {
    public static String generateToken(String username) {
        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + 86400000);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expirationDate)
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }
    private static Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode("763979244226452948404D635166546A576E5A7134743777217A25432A462D4A");
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
