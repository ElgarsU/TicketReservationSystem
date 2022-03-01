package com.example.ticketReservationSystem.repository;

import com.example.ticketReservationSystem.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
