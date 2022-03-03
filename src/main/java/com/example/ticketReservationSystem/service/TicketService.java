package com.example.ticketReservationSystem.service;

import com.example.ticketReservationSystem.model.Ticket;
import com.example.ticketReservationSystem.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    public Ticket getTicketById(Long id){
        return ticketRepository.findById(id).orElse(null);
    }
}