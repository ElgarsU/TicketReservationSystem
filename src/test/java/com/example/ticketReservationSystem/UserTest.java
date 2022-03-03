package com.example.ticketReservationSystem;

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
    RoleRepository role;
    @Autowired
    UserRepository userRepository;


    @Test
    public void createTestRoles(){
        Role user = new Role("User");
        Role admin = new Role("Admin");
        role.saveAll(List.of(user,admin));
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
        user.setEmail("adminE@gmail.com");
        user.setName("adminE");
        user.setSurname("adminE");
        user.setPassword(encoded);
        Role roleuser = role.findByName("ROLE_ADMIN");
        ArrayList<Role> roles = new ArrayList<Role>();
        roles.add(roleuser);
        user.setRoles(roles);
        userRepository.save(user);

        System.out.println("great");


    }


}
