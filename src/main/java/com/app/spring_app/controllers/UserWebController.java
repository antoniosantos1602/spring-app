package com.app.spring_app.controllers;

import com.app.spring_app.entities.User;
import com.app.spring_app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserWebController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";  // Agora procura templates/login.html
    }

    @GetMapping("/list-users")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "list-users";  // templates/list-user.html
    }

    @GetMapping("/add-user")
    public String showAddUser(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("edit", false);
        return "user";  // templates/user.html
    }

    @PostMapping("/add-user")
    public String addUser(@ModelAttribute User user) {
        userService.createUser(user);
        return "redirect:/list-users";
    }

    @GetMapping("/update-user")
    public String showUpdateUser(@RequestParam Long userid, Model model) {
        model.addAttribute("user", userService.getUserById(userid).get());
        model.addAttribute("edit", true);
        return "user";
    }

    @PostMapping("/update-user")
    public String updateUser(@ModelAttribute User user) {
        userService.updateUserById(user.getUserid(), user);
        return "redirect:/list-users";
    }

    @GetMapping("/delete-user")
    public String deleteUser(@RequestParam Long userid) {
        userService.deleteUserById(userid);
        return "redirect:/list-users";
    }
}
