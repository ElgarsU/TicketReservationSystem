package com.example.ticketReservationSystem.controller;

import com.example.ticketReservationSystem.model.Ticket;
import com.example.ticketReservationSystem.repository.TicketRepository;
import com.example.ticketReservationSystem.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Controller
public class TicketController {

    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private TicketService ticketService;

    @GetMapping("/tickets")
    public String viewAllTickets(Model model) {
        List<Ticket> ticket = ticketRepository.findAll();
        model.addAttribute("listTickets", ticket);
        return "tickets";
    }


    @GetMapping("/tickets/{id}")
    public String getTicket(@PathVariable("id") Long id, Model model) {
        Ticket ticket = ticketService.getTicketById(id);
        model.addAttribute("ticket", ticket);
        return "show_ticket";
    }

    @ModelAttribute("currentUser")
    public UserDetails getCurrentUser(Authentication authentication) {
        return (authentication == null) ? null : (UserDetails) authentication.getPrincipal();
    }
}