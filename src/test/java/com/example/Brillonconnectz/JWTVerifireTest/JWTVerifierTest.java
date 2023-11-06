package com.example.Brillonconnectz.JWTVerifireTest;

import com.example.Brillonconnectz.TaskQuestionOne.JWTGenerator;
import com.example.Brillonconnectz.TaskQuestionOne.JWTVerifier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JWTVerifierTest {

    @Test
    public void testValidToken() {
        String token = JWTGenerator.generateToken("user01");
        String result = JWTVerifier.verifyToken(token);
        assertEquals("Verification pass", result);
    }

    @Test
    public void testInvalidToken() {
        String token = "invalid token";
        String result = JWTVerifier.verifyToken(token);
        assertEquals("Verification fails", result);
    }
}