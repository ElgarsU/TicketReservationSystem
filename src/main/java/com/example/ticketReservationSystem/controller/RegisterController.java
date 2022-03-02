package com.example.ticketReservationSystem.controller;

import com.example.ticketReservationSystem.model.UserRegistrationDto;
import com.example.ticketReservationSystem.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private UserService userService;

    public RegisterController(UserService userService) {
        super();
        this.userService = userService;
    }
    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto(){
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showregister(Model model){
        model.addAttribute("user", new UserRegistrationDto());
        return "signup_form";
    }
    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto){
        userService.save(registrationDto);
        return "redirect:/register?success";
    }
}
