package com.kasir.kasir.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "orders")

public class order {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOrder;
    
    private String orderDate;
    private String idUser;
    
    public int getIdOrder() {
        return idOrder;
    }
    public String getOrderDate() {
        return orderDate;
    }
    public String getIdUser() {
        return idUser;
    }
    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }
}
