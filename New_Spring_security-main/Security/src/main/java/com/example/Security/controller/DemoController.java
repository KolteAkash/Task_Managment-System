package com.example.Security.controller;

import com.example.Security.service.AuthenticationService;
import com.example.Security.service.DemoService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")
@RequiredArgsConstructor
@CrossOrigin
public class DemoController {

    private final AuthenticationService authenticationService;
    @Autowired
    private DemoService demoService;
    @GetMapping("/test")
    public ResponseEntity<?> login(){
        return ResponseEntity.ok(demoService.demoService());
    }
}
