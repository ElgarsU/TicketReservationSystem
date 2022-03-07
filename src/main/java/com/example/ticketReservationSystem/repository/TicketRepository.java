//package com.example.ticketReservationSystem.repository;
//
//import com.example.ticketReservationSystem.model.Flights;
//import com.example.ticketReservationSystem.model.Ticket;
//import com.example.ticketReservationSystem.model.User;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//
//@Repository
//public interface TicketRepository extends JpaRepository<Ticket, Long> {
//    public Ticket findByUserAndFlight(User user, Flights flight);
//
//}