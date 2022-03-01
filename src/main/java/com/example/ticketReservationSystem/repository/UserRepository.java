package com.example.ticketReservationSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ticketReservationSystem.model.Ticket;

public interface UserRepository extends JpaRepository<Ticket, Long> {
}
