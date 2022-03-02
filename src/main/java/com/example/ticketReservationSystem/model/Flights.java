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
public class Flights {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "departure_location", nullable = false)
    private String departureLocation;

    @Column(name = "arrival_location", nullable = false)
    private String arrivalLocation;

    @Column(name = "flight_start", nullable = false)
    private String flightStart;

    @Column(name = "flight_end", nullable = false)
    private String flightEnd;

    @Column(name = "ticket_price", nullable = false)
    private int ticketPrice;

    @Column(name = "flight_capacity", nullable = false)
    private int flightCapacity;

}
