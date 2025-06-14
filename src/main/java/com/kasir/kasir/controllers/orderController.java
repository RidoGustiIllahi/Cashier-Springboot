package com.kasir.kasir.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kasir.kasir.models.order;
import com.kasir.kasir.models.user;
import com.kasir.kasir.repository.orderRepository;


@Controller
@RequestMapping("/order")

public class orderController {
    
    @Autowired
    private orderRepository orderRepo;

    @GetMapping({"", "/"})
    public String showUsersList(Model model) {
        List<order> orders = orderRepo.findAll();
        model.addAttribute("orders", orders);
        return "order/orderList";
    }

    @GetMapping("/create")
    public String createOrder() {
        Date createdAt = new Date();

        order newOrder = new order();
        newOrder.setOrderDate(createdAt.toString());

        user dummyUser = new user();
        dummyUser.setIdUser(2);
        newOrder.setUser(dummyUser);

        orderRepo.save(newOrder);

        return "redirect:/order";
    }
    
}
