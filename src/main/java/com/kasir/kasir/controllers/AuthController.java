package com.kasir.kasir.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kasir.kasir.models.user;
import com.kasir.kasir.services.AuthService;
import com.kasir.kasir.services.UserSession;

@Controller
public class AuthController {
    private final AuthService authService;
    private final UserSession userSession;

    public AuthController(AuthService authService, UserSession userSession) {
        this.authService = authService;
        this.userSession = userSession;
    }

    @GetMapping("/login")
    public String loginForm() {
        if (userSession.isLoggedIn()) {
            return "redirect:/kasir";
        }
        return "auth/login";
    }

    @PostMapping("/login")
    public String login(
            @RequestParam String username,
            @RequestParam String password,
            Model model) {
        
        user user = authService.authenticate(username, password);
        if (user != null) {
            userSession.login(user);
            return "redirect:/kasir";
        } else {
            model.addAttribute("error", "Username atau password salah");
            return "auth/login";
        }
    }

    @GetMapping("/logout")
    public String logout() {
        userSession.logout();
        return "redirect:/login";
    }
}