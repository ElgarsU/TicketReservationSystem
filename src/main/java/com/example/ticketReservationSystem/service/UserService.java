package com.example.ticketReservationSystem.service;

import com.example.ticketReservationSystem.model.User;
import com.example.ticketReservationSystem.model.UserRegistrationDto;
import com.example.ticketReservationSystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(UserRegistrationDto userRegistrationDto){
        User register = new User(userRegistrationDto.getName(), userRegistrationDto.getSurname(), userRegistrationDto.getEmail(), userRegistrationDto.getPassword());
        return userRepository.save(register);
    }



}
