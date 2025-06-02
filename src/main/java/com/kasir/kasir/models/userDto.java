package com.kasir.kasir.models;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotEmpty;

public class userDto {
    @NotEmpty(message = "Nama tidak boleh kosong")
    private String name;
    
    private MultipartFile profile;

    @NotEmpty(message = "Username tidak boleh kosong")
    private String username;

    @NotEmpty(message = "Password tidak boleh kosong")
    private String password;
        
    @NotEmpty(message = "Role tidak boleh kosong")
    private String role;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public MultipartFile getProfile() {
        return profile;
    }
    public void setProfile(MultipartFile profile) {
        this.profile = profile;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
}
