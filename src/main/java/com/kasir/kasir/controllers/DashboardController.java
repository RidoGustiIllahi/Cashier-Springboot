package com.kasir.kasir.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kasir.kasir.services.UserSession;

@Controller
public class DashboardController {
    private final UserSession userSession;

    public DashboardController(UserSession userSession) {
        this.userSession = userSession;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        if (!userSession.isLoggedIn()) {
            return "redirect:/login";
        }

        model.addAttribute("user", userSession.getLoggedInUser());
        model.addAttribute("isAdmin", userSession.isAdmin());
        return "dashboard";
    }
}