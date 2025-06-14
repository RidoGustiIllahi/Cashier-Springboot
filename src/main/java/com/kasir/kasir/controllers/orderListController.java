package com.kasir.kasir.controllers;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kasir.kasir.models.order;
import com.kasir.kasir.models.orderList;
import com.kasir.kasir.models.product;
import com.kasir.kasir.models.user;
import com.kasir.kasir.repository.orderListRepository;
import com.kasir.kasir.repository.orderRepository;
import com.kasir.kasir.repository.productRepository;
import com.kasir.kasir.services.cartService;


@Controller
@RequestMapping("/kasir")
public class orderListController {
    
    @Autowired
    private productRepository productRepo;

    @Autowired
    private cartService cartService;

    @Autowired
    private orderRepository orderRepo;

    @Autowired
    private orderListRepository orderListRepo;
    
    @GetMapping({"", "/"})
    public String showProductsList(Model model) {
        List<product> products = productRepo.findAll();
        model.addAttribute("products", products);
        model.addAttribute("cartItems", cartService.getCartItems());
        model.addAttribute("total", cartService.getTotalPrice());
        return "kasir/kasir";
    }

    @PostMapping("/addToCart")
    public String addToCart(@RequestParam("idProduct") int idProduct) {
        product p = productRepo.findById(idProduct).get();
        if (p != null) {
            cartService.addProduct(p);
            p.setStock(p.getStock() - 1);
            productRepo.save(p);
        }
        return "redirect:/kasir";
    }

    @PostMapping("/removeFromCart")
    public String removeFromCart(@RequestParam("idProduct") int idProduct) {
        product p = productRepo.findById(idProduct).get();
        if (p != null) {
            cartService.removeProduct(p);
            p.setStock(p.getStock() + 1);
            productRepo.save(p);
        }
        return "redirect:/kasir";
    }

    @PostMapping("/checkout")
    public String checkout() {
        
        Date createdAt = new Date();

        order newOrder = new order();
        newOrder.setOrderDate(createdAt.toString());

        user dummyUser = new user();
        dummyUser.setIdUser(2);
        newOrder.setUser(dummyUser);
        newOrder.setTotalPrice(cartService.getTotalPrice());

        orderRepo.save(newOrder);

        for (product p : cartService.getCartItems()) {
            orderList orderList = new orderList();
            orderList.setOrder(newOrder);
            orderList.setProduct(p);
            orderListRepo.save(orderList);
        }

        cartService.emptyProducts();
        return "redirect:/kasir";
    }

    @PostMapping("/emptyCart")
public String emptyCart() {
    // Get all cart items first
    List<product> itemsInCart = cartService.getCartItems();
    
    // Return stock for each product in cart
    for (product item : itemsInCart) {
        Optional<product> productOpt = productRepo.findById(item.getIdProduct());
        if (productOpt.isPresent()) {
            product product = productOpt.get();
            product.setStock(product.getStock() + 1); // Or + quantity if cart items have quantities
            productRepo.save(product);
        }
    }
    
    // Empty the cart
    cartService.emptyProducts();
    return "redirect:/kasir";
}
}