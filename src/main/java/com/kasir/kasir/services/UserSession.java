package com.kasir.kasir.services;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.kasir.kasir.models.user;

@Component
@SessionScope
public class UserSession {
    private user loggedInUser;

    public void login(user user) {
        this.loggedInUser = user;
    }

    public void logout() {
        this.loggedInUser = null;
    }

    public user getLoggedInUser() {
        return loggedInUser;
    }

    public boolean isLoggedIn() {
        return loggedInUser != null;
    }

    public boolean isAdmin() {
        return isLoggedIn() && "ADMIN".equals(loggedInUser.getRole());
    }
}