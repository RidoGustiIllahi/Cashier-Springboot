package com.kasir.kasir.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "orders")

public class order {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOrder;
    
    private String orderDate;
    private Double totalPrice;
    
    @ManyToOne
    @JoinColumn(name = "idUser")
    private user user;

    @OneToMany(mappedBy = "order")
    private List<orderList> orderLists;
    
    public int getIdOrder() {
        return idOrder;
    }
    public String getOrderDate() {
        return orderDate;
    }
    public Double getTotalPrice() {
        return totalPrice;
    }
    public user getUser() {
        return user;
    }
    public List<orderList> getOrderLists() {
        return orderLists;
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
    public void setOrderLists(List<orderList> orderLists) {
        this.orderLists = orderLists;
    }
    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
