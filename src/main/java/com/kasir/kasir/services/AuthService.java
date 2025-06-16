package com.kasir.kasir.services;

import org.springframework.stereotype.Service;

import com.kasir.kasir.models.user;
import com.kasir.kasir.repository.userRepository;

@Service
public class AuthService {
    private final userRepository userRepository;

    public AuthService(userRepository userRepository) {
        this.userRepository = userRepository;
    }

    public user authenticate(String username, String password) {
        user user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
    
    public boolean isAdmin(user user) {
        return user != null && "ADMIN".equals(user.getRole());
    }
}