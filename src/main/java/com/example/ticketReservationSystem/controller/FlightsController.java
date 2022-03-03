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

    @GetMapping({"/flights"})
    public ModelAndView viewAllFlights() {
        ModelAndView mav = new ModelAndView("flights");
        mav.addObject("flights", flightsRepository.findAll());
        return mav;
    }

    @GetMapping({"/addFlight"})
    public ModelAndView addFlightForm() {
        ModelAndView mav = new ModelAndView("add-flight");
        Flights newFlight = new Flights();
        mav.addObject("flight", newFlight);
        return mav;
    }
}
