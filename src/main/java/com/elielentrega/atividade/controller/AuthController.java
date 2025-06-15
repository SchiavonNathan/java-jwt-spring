package com.elielentrega.atividade.controller;

import com.elielentrega.atividade.dto.JwtResponseDto;
import com.elielentrega.atividade.dto.UserLoginDto;
import com.elielentrega.atividade.dto.UserRegistrationDto;
import com.elielentrega.atividade.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/authentication")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<JwtResponseDto> register(@Valid @RequestBody UserRegistrationDto registrationDto) {
        return ResponseEntity.ok(authService.register(registrationDto));
    }

    @PostMapping("/register/adm")
    public ResponseEntity<JwtResponseDto> registerAdmin(@Valid @RequestBody UserRegistrationDto registrationDto) {
        return ResponseEntity.ok(authService.registerAdmin(registrationDto));
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponseDto> login(@Valid @RequestBody UserLoginDto loginDto) {
        return ResponseEntity.ok(authService.login(loginDto));
    }
} 