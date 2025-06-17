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

import com.kasir.kasir.models.user;
import com.kasir.kasir.models.userDto;
import com.kasir.kasir.repository.userRepository;
import com.kasir.kasir.services.UserSession;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/user")

public class userController {

    @Autowired
    private userRepository userRepo;

    @Autowired
    private UserSession userSession;

    private boolean isAdminAccess() {
        return userSession.isLoggedIn() && "ADMIN".equals(userSession.getLoggedInUser().getRole());
    }

    @GetMapping({"", "/"})
    public String showUsersList(Model model) {

        if (!isAdminAccess()) {
            return "redirect:/kasir";
        }

        List<user> users = userRepo.findAll();
        model.addAttribute("users", users);
        return "user/userList";
    }

    @GetMapping("/create")
    public String showCreateUserForm(Model model) {
        
        if (!isAdminAccess()) {
            return "redirect:/kasir";
        }

        userDto userDto = new userDto();
        model.addAttribute("userDto", userDto);
        return "user/createUser";
    }

    @PostMapping("/create")
    public String createUser(
            @Valid @ModelAttribute userDto userDto,
            BindingResult result 
            ) {
        
        if (userDto.getProfile().isEmpty()) {
            result.addError(new FieldError("userDto", "profile", "Gambar tidak boleh kosong"));
        }

        if (result.hasErrors()) {
            return "user/createUser";
        }


        MultipartFile image = userDto.getProfile();
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


        user user = new user();
        user.setName(userDto.getName());
        user.setProfile(storageFileName);
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setRole(userDto.getRole());

        userRepo.save(user); 

        return "redirect:/user";
    }

    @GetMapping("/edit")
    public String showEditPage(
            Model model,
            @RequestParam int idUser
        ) {


        if (!isAdminAccess()) {
            return "redirect:/kasir";
        }

        try {
            user user = userRepo.findById(idUser).get();
            model.addAttribute("user", user);

            userDto userDto = new userDto();
            userDto.setName(user.getName());
            userDto.setUsername(user.getUsername());
            userDto.setPassword(user.getPassword());
            userDto.setRole(user.getRole());

            model.addAttribute("userDto", userDto);
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return "redirect:/user";
        }
        return "user/editUser";
    }
    
    @PostMapping("/edit")
    public String editUser(
            Model model,
            @RequestParam int idUser,
            @Valid @ModelAttribute userDto userDto,
            BindingResult result
            ) {

        try {
            user user = userRepo.findById(idUser).get();
            model.addAttribute("user", user);
            
            if (result.hasErrors()) {
                return "user/editUser";
            }

            if (!userDto.getProfile().isEmpty()){
                String uploadDir = "public/image/";
                Path oldImagePath = Paths.get(uploadDir + user.getProfile());

                try {
                    Files.deleteIfExists(oldImagePath);
                }
                catch (Exception e) {
                    System.out.println("Exception: " + e.getMessage());
                }

                MultipartFile image = userDto.getProfile();
                Date createdAt = new Date();
                String storageFileName = createdAt.getTime() + "_" + image.getOriginalFilename();

                try (InputStream inputStream = image.getInputStream()) {
                    Files.copy(inputStream, Paths.get(uploadDir + storageFileName),
                            StandardCopyOption.REPLACE_EXISTING);
                } 

                user.setProfile(storageFileName);
            }

            user.setName(userDto.getName());
            user.setUsername(userDto.getUsername());
            user.setPassword(userDto.getPassword());
            user.setRole(userDto.getRole());
            
            userRepo.save(user);
            
        }   
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return "redirect:/user";
        }
        return "redirect:/user";
    }

    @GetMapping("/delete")
    public String deleteUser(
            @RequestParam int idUser
        ) {
        
        if (!isAdminAccess()) {
            return "redirect:/kasir";
        }

        try {
            user user = userRepo.findById(idUser).get();

            Path imagePath = Paths.get("public/image/" + user.getProfile());

            try {
                Files.deleteIfExists(imagePath);
            }
            catch (Exception e) {
                System.out.println("Exception: " + e.getMessage());
            }

            userRepo.delete(user);
        }
        catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            return "redirect:/user";
        }
        return "redirect:/user";
    }
}