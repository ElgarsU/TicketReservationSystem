package com.example.ticketReservationSystem.controller;

import com.example.ticketReservationSystem.model.User;
import com.example.ticketReservationSystem.model.UserRegistrationDto;
import com.example.ticketReservationSystem.repository.UserRepository;
import com.example.ticketReservationSystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {
    private UserService userService;
    @Autowired
    UserRepository userRepository;



    @RequestMapping("/login")
    public String showlogin(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken))
            return "tickets";
        return "index";
    }
    @GetMapping("/")
    public String home(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken))
            return "tickets";

        return "index";
    }


    

    @GetMapping("/admin")
    public String forAdmin(){
        return "admin_test";
    }
    @ModelAttribute("currentUser")
    public UserDetails getCurrentUser(Authentication authentication) {
        return (authentication == null) ? null : (UserDetails) authentication.getPrincipal();
    }


    @GetMapping("/profile")
    public String profile(Model model, @AuthenticationPrincipal UserDetails currentUser){
        User user = userRepository.findByEmail(currentUser.getUsername());
         model.addAttribute("user", user);
        return "user_profile";
    }

}
