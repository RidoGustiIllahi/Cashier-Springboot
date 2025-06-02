package com.kasir.kasir.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "orders")

public class order {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOrder;
    
    private String orderDate;
    
    @ManyToOne
    @JoinColumn(name = "idUser")
    private user user;
    
    public int getIdOrder() {
        return idOrder;
    }
    public String getOrderDate() {
        return orderDate;
    }
    public user getUser() {
        return user;
    }
    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
    public void setUser(user user) {
        this.user = user;
    }
}
