package com.elielentrega.atividade.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRegistrationDto {
    
    @NotBlank(message = "Nome de usuario é necessario")
    @Size(min = 3, max = 50, message = "Nome de usuario precisa ter entre 3 e 50 caracteres")
    private String username;

    @NotBlank(message = "Email é necessario")
    @Email(message = "Formato de email invalido")
    private String email;

    @NotBlank(message = "Senha é necessario")
    @Size(min = 6, message = "A senha precisa ter pelo menos 6 digitos")
    private String password;

    public UserRegistrationDto() {}

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
} 