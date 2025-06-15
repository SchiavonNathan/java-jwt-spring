package com.elielentrega.atividade.dto;

import jakarta.validation.constraints.NotBlank;

public class UserLoginDto {
    
    @NotBlank(message = "Nome de usuario é necessario")
    private String username;

    @NotBlank(message = "Senha é necessario")
    private String password;

    public UserLoginDto() {}

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
} 