package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.kata.spring.boot_security.demo.service.UserDetailsServiceImpl;
import ru.kata.spring.boot_security.demo.service.UserServiceImpl;


@Controller
public class UserController {

    private UserDetailsServiceImpl userDetailsServiceImpl;
    private UserServiceImpl userServiceImpl;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl,UserDetailsServiceImpl userDetailsServiceImpl) {
        this.userServiceImpl = userServiceImpl;
        this.userDetailsServiceImpl = userDetailsServiceImpl;
    }


    @GetMapping("/user/{id}")
    public String showCurrentUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user",userServiceImpl.showById(id));
        return "/user";
    }
}