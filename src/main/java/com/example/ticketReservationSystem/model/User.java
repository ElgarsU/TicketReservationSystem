package com.example.ticketReservationSystem.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name =  "user", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    private String email;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))

    private Collection<Role> roles;

    @OneToMany
    List<Ticket> tickets;




    public User(String name, String surname, String email, String password) {
        this.name=name;
        this.surname=surname;
        this.email=email;
        this.password=password;
    }
    public User(String name, String surname, String email, String password,Collection<Role> roles) {
        this.name=name;
        this.surname=surname;
        this.email=email;
        this.password=password;
        this.roles = roles;
        this.tickets = tickets;
    }
    public User(String name, String surname, String email, String password,Collection<Role> roles,List<Ticket> tickets) {
        this.name=name;
        this.surname=surname;
        this.email=email;
        this.password=password;
        this.roles = roles;
        this.tickets = tickets;
    }
    public User(String name, String surname, String email, String password,List<Ticket> tickets) {
        this.name=name;
        this.surname=surname;
        this.email=email;
        this.password=password;
        this.tickets = tickets;
    }

    public void addRole(Role role){
        this.roles.add(role);
    }


}
