package com.kasir.kasir.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kasir.kasir.models.orderList;

public interface orderListRepository extends JpaRepository<orderList, Integer> {
    
}
