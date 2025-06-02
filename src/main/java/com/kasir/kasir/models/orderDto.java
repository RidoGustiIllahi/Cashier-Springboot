package com.kasir.kasir.models;

import jakarta.validation.constraints.NotEmpty;

public class orderDto {
    @NotEmpty(message = "ID User tidak boleh kosong")
    private int idUser;
    
    @NotEmpty(message = "Tanggal Pesanan tidak boleh kosong")
    private String orderDate;

    public int getIdUser() {
        return idUser;
    }
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
    public String getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
}
