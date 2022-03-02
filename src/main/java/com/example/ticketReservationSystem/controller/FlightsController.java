package com.example.ticketReservationSystem.controller;

import com.example.ticketReservationSystem.model.Flights;
import com.example.ticketReservationSystem.repository.FlightsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class FlightsController {

    @Autowired
    private FlightsRepository flightsRepository;

    //send all available flights to frontend
//    @GetMapping("/flights")
//    public String viewAllFlights(Model model) {
//        List<Flights> flights = flightsRepository.findAll();
//        model.addAttribute("listFlights", flights);
//        return "flights";
//    }

    @GetMapping({"/flights"})
    public ModelAndView viewAllFlights() {
        ModelAndView mav = new ModelAndView("flights");
        mav.addObject("flights", flightsRepository.findAll());
        return mav;
    }
}
