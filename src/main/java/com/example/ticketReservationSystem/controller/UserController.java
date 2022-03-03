package com.example.ticketReservationSystem.controller;

import com.example.ticketReservationSystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class UserController {
    private UserService userService;



    @RequestMapping("/login")
    public String showlogin(){
//        if (userService.isAuthenticated()){
//    return "index";
//}
        return "login";
    }
    @GetMapping("/")
    public String home(){
        return "index_zhen";
    }

    @GetMapping("/admin")
    public String forAdmin(){
        return "admin";
    }





}
