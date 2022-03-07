package com.example.ticketReservationSystem;

import com.example.ticketReservationSystem.model.Flights;
import com.example.ticketReservationSystem.model.Role;

import com.example.ticketReservationSystem.model.User;
import com.example.ticketReservationSystem.repository.RoleRepository;

import com.example.ticketReservationSystem.repository.UserRepository;
import nonapi.io.github.classgraph.utils.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@ComponentScan(basePackages = {"com.example.ticketReservationSystem.UserService"})
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserTest {


    @Autowired
    private TestEntityManager testEntityManager;
    @Autowired
    RoleRepository role;
    @Autowired
    UserRepository userRepository;

    private final long id=1;
    private final long id2=2;


    @Test
    public void createTestRoles(){
//        Role user = new Role("User");
        Role admin = new Role("ROLE_ADMIN");
        role.save(admin);
        List<Role> listRoles = role.findAll();

    }
    @Test
    public void testFindUserBVyEmail() {
        String email = "hhhhh@gmail.com";
        User user = userRepository.findByEmail(email);
    }

    @Test
    public void testCreateUser(){
        String password = "admin";
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10,new SecureRandom());
        String encoded = bCryptPasswordEncoder.encode(password);
        User user = new User();
        user.setEmail("admin12@gmail.com");
        user.setName("admin12345");
        user.setSurname("admin12345");
        user.setPassword(encoded);
        Role roleuser = role.findByName("ROLE_ADMIN");
        ArrayList<Role> roles = new ArrayList<Role>();
        roles.add(roleuser);
        user.setRoles(roles);
        userRepository.save(user);

        System.out.println("great");

    }



}
