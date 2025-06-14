package com.kasir.kasir.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.kasir.kasir.models.product;

@Service
@SessionScope
public class cartService {
    ArrayList<product> cartItems = new ArrayList<>();
    double totalPrice = 0.0;

    public void addProduct(product p) {
        cartItems.add(p);
        totalPrice += p.getPrice();
    }

    public void removeProduct(product p) {
        for (int i = 0; i < cartItems.size(); i++) {
            if (cartItems.get(i).getIdProduct() == p.getIdProduct()) {
                cartItems.remove(i);
                totalPrice -= p.getPrice();
                break;
            }
        }
    }

    public void emptyProducts() {
        cartItems.clear();
        totalPrice = 0.0;
    }

    public ArrayList<product> getCartItems() {
        return cartItems;
    }
    public double getTotalPrice() {
        return totalPrice;
    }
}
