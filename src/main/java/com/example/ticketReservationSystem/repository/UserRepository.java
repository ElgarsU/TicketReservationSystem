package com.example.ticketReservationSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ticketReservationSystem.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User findByEmail(String email);
}
