package com.example.ticketReservationSystem.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "flights")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "departure_location", nullable = false)
    private String departureLocation;
    @Column(name = "arrival_location", nullable = false)
    private String arrivalLocation;
    @Column(name = "ticket_price", nullable = false)
    private int ticketPrice;
    @Column(name = "flight_capacity", nullable = false)
    private int flightCapacity;


}
