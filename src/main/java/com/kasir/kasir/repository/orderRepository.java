package com.kasir.kasir.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kasir.kasir.models.order;

public interface orderRepository extends JpaRepository<order, Integer> {
    
}
