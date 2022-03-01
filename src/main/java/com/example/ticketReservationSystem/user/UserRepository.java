package com.example.ticketReservationSystem.user;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ticketReservationSystem.ticket.Ticket;

public interface UserRepository extends JpaRepository<Ticket, Long> {
}
