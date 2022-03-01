package com.example.ticketReservationSystem.ticket;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.ticketReservationSystem.user.User;

import javax.persistence.*;

@Builder
@Data
@Table (name="tickets")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "flight_number", nullable = false)
    private String flightNumber;
    @Column(name = "capacity", nullable = false)
    private short capacity;
    @ManyToOne
    User user;
}
