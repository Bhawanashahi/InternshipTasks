package com.example.blogApi.controllers;

import com.example.blogApi.endpoint.BlogService;
import com.example.blogApi.entities.Session;
import com.example.blogApi.entities.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;@Controller

public class UserController {
    private final BlogService service = BlogService.getInstance();

    @GetMapping("/user")
    public String listUsers(Model model, HttpSession session) {
        Session s = Helper.getAuthSession(session);
        if (!s.isAuthenticated()) {
            return "redirect:/home";
        }
        List<User> users = this.service.getUserService().listUser(); // Assuming the method to retrieve users is listUsers()

        model.addAttribute("users", users);
        return "users"; // Assuming "user" is the correct name of the view for displaying users
    }

    @GetMapping("/user/new")
    public String showAddUserForm(Model model, HttpSession session) {
        Session s = Helper.getAuthSession(session);
        if (!s.isAuthenticated()) {
            return "redirect:/home";
        }
        model.addAttribute("user", new User()); // Assuming User is the entity class for users
        return "add_user"; // Assuming "add_user" is the name of the view for adding a new user
    }
}
