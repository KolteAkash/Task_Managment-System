package com.example.Security.service;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.Security.config.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DemoService {
    public ResponseEntity<?> demoService(){
        return ResponseEntity.ok().body("Response from backend");
    }
}
