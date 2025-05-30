package com.kasir.kasir.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kasir.kasir.models.product;

public interface productRepository extends JpaRepository<product, Integer> {
    
}
