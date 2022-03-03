package com.example.ticketReservationSystem.controller;

import com.example.ticketReservationSystem.model.User;
import com.example.ticketReservationSystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestRest {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/all")
    public List<User> getallusers(){
        return userRepository.findAll();
    }
}
