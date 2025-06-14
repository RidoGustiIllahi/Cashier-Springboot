package com.kasir.kasir.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class user {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;

    private String name;
    private String profile;
    private String username;
    private String password;
    private String role;

    @OneToMany(mappedBy = "user")
    private List<order> orders;

    public int getIdUser() {
        return idUser;
    }
    public String getProfile() {
        return profile;
    }
    public String getName() {
        return name;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getRole() {
        return role;
    }
    public List<order> getOrders() {
        return orders;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setProfile(String profile) {
        this.profile = profile;
    }    
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public void setOrders(List<order> orders) {
        this.orders = orders;
    }
}
