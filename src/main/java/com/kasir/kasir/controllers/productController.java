package com.kasir.kasir.controllers;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kasir.kasir.models.product;
import com.kasir.kasir.models.productDto;
import com.kasir.kasir.repository.productRepository;
import com.kasir.kasir.services.UserSession;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/product")

public class productController {

    @Autowired
    private productRepository productRepo;

    @Autowired
    private UserSession userSession;

    private boolean isAdminAccess() {
        return userSession.isLoggedIn() && "ADMIN".equals(userSession.getLoggedInUser().getRole());
    }

    @GetMapping({"", "/"})
    public String showProductsList(Model model) {

        if (!isAdminAccess()) {
            return "redirect:/kasir";
        }

        List<product> products = productRepo.findAll();
        model.addAttribute("products", products);
        return "product/productsList";
    }

    @GetMapping("/create")
    public String showCreateProductForm(Model model) {

        if (!isAdminAccess()) {
            return "redirect:/kasir";
        }

        productDto productDto = new productDto();
        model.addAttribute("productDto", productDto);
        return "product/createProduct";
    }

    @PostMapping("/create")
    public String createProduct(
            @Valid @ModelAttribute productDto productDto,
            BindingResult result 
            ) {
        
        if (productDto.getImage().isEmpty()) {
            result.addError(new FieldError("productDto", "image", "Gambar tidak boleh kosong"));
        }

        if (result.hasErrors()) {
            return "product/createProduct";
        }


        MultipartFile image = productDto.getImage();
        Date createdAt = new Date();
        String storageFileName = createdAt.getTime() + "_" + image.getOriginalFilename();
        try {
            String uploadDir = "public/image/";
            Path uploadPath = Paths.get(uploadDir);

            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            try (InputStream inputStream = image.getInputStream()) {
                Files.copy(inputStream, Paths.get(uploadDir + storageFileName),
                        StandardCopyOption.REPLACE_EXISTING);
            }
        }  catch (Exception e) {
            System.out.println("Gagal menyimpan gambar: " + e.getMessage());
        }


        product product = new product();
        product.setName(productDto.getName());
        product.setImage(storageFileName);
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        product.setStock(productDto.getStock());

        productRepo.save(product); 

        return "redirect:/product";
    }
    
    @GetMapping("/edit")
    public String showEditPage(
            Model model,
            @RequestParam int idProduct
        ) {

        if (!isAdminAccess()) {
            return "redirect:/kasir";
        }

        try {
            product product = productRepo.findById(idProduct).get();
            model.addAttribute("product", product);

            productDto productDto = new productDto();
            productDto.setName(product.getName());
            productDto.setPrice(product.getPrice());
            productDto.setDescription(product.getDescription());
            productDto.setStock(product.getStock());

            model.addAttribute("productDto", productDto);
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return "redirect:/product";
        }
        return "product/editProduct";
    }

    @PostMapping("/edit")
    public String editProduct(
            Model model,
            @RequestParam int idProduct,
            @Valid @ModelAttribute productDto productDto,
            BindingResult result
            ) {

        try {
            product product = productRepo.findById(idProduct).get();
            model.addAttribute("product", product);
            
            if (result.hasErrors()) {
                return "product/editProduct";
            }

            if (!productDto.getImage().isEmpty()){
                String uploadDir = "public/image/";
                Path oldImagePath = Paths.get(uploadDir + product.getImage());

                try {
                    Files.deleteIfExists(oldImagePath);
                }
                catch (Exception e) {
                    System.out.println("Exception: " + e.getMessage());
                }

                MultipartFile image = productDto.getImage();
                Date createdAt = new Date();
                String storageFileName = createdAt.getTime() + "_" + image.getOriginalFilename();

                try (InputStream inputStream = image.getInputStream()) {
                    Files.copy(inputStream, Paths.get(uploadDir + storageFileName),
                            StandardCopyOption.REPLACE_EXISTING);
                } 

                product.setImage(storageFileName);
            }

            product.setName(productDto.getName());
            product.setPrice(productDto.getPrice());
            product.setDescription(productDto.getDescription());
            product.setStock(productDto.getStock());
            
            productRepo.save(product);
            
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return "redirect:/product";
        }
        return "redirect:/product";
    }

    @GetMapping("/delete")
    public String deleteProduct(
            @RequestParam int idProduct
        ) {

        if (!isAdminAccess()) {
            return "redirect:/kasir";
        }
        
        try {
            product product = productRepo.findById(idProduct).get();

            Path imagePath = Paths.get("public/image/" + product.getImage());

            try {
                Files.deleteIfExists(imagePath);
            }
            catch (Exception e) {
                System.out.println("Exception: " + e.getMessage());
            }

            productRepo.delete(product);
        }
        catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            return "redirect:/product";
        }
        return "redirect:/product";
    }
}