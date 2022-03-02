package com.example.ticketReservationSystem.repository;

import com.example.ticketReservationSystem.model.Flights;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightsRepository extends JpaRepository<Flights, Long> {
}
