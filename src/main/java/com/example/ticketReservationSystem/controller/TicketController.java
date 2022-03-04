package com.example.ticketReservationSystem.controller;

import com.example.ticketReservationSystem.model.Ticket;
import com.example.ticketReservationSystem.model.User;
import com.example.ticketReservationSystem.repository.TicketRepository;
import com.example.ticketReservationSystem.repository.UserRepository;
import com.example.ticketReservationSystem.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class TicketController {

    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private TicketService ticketService;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/tickets")
    public String viewAllTickets(Model model, @AuthenticationPrincipal UserDetails currentUser) {
        List<Ticket> ticket = ticketRepository.findAll();
        User user = userRepository.findByEmail(currentUser.getUsername());
        model.addAttribute("listTickets", ticket);
        model.addAttribute("user", user);
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

    @GetMapping("/deleteTicket")
    public String deleteTicket(@RequestParam Long id){
        ticketRepository.deleteById(id);
        return "redirect:/tickets";
    }
}