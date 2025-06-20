package com.kasir.kasir.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kasir.kasir.models.user;

public interface userRepository extends JpaRepository<user, Integer> {
    user findByUsername(String username);    
}
