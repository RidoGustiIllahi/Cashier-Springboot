package com.kasir.kasir.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orderList")
public class orderList {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOrderList;

    @ManyToOne
    @JoinColumn(name = "idProduct")
    private product product;

    @ManyToOne
    @JoinColumn(name = "idOrder")
    private order order;

    public int getIdOrderList() {
        return idOrderList;
    }
    public product getProduct() {
        return product;
    }
    public order getOrder() {
        return order;
    }

    public void setOrder(order order) {
        this.order = order;
    }
    public void setProduct(product product) {
        this.product = product;
    }
    public void setIdOrderList(int idOrderList) {
        this.idOrderList = idOrderList;
    }
}
