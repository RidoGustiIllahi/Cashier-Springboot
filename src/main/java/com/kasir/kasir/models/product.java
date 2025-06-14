package com.kasir.kasir.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "product")

public class product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProduct;

    private String name;
    private String description;
    private Double price;
    private String image;
    private int stock;

    @OneToMany(mappedBy = "product")
    private List<orderList> orderLists;

    public int getIdProduct() {
        return idProduct;
    }
    public String getName() {
        return name;
    }   
    public String getDescription() {
        return description;
    }
    public Double getPrice() {
        return price;
    }
    public String getImage() {
        return image;
    }
    public int getStock() {
        return stock;
    }
    public List<orderList> getOrderLists() {
        return orderLists;
    }

    
    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public void setOrderLists(List<orderList> orderLists) {
        this.orderLists = orderLists;
    }
}
