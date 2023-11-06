package com.example.Brillonconnectz.TaskQuestionOne;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JWTVerifier {

    private static final String SECRET_KEY = "763979244226452948404D635166546A576E5A7134743777217A25432A462D4A";

    public static String verifyToken(String token) {

        try {
            Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
            return "Verification pass";
        } catch (Exception e) {
            return "Verification fails";
        }
    }
}