package com.example.ticketReservationSystem;

import com.example.ticketReservationSystem.controller.RegisterController;
import com.example.ticketReservationSystem.controller.UserTestController;
import com.example.ticketReservationSystem.model.Flights;
import com.example.ticketReservationSystem.model.Role;

import com.example.ticketReservationSystem.model.User;
import com.example.ticketReservationSystem.repository.RoleRepository;

import com.example.ticketReservationSystem.repository.UserRepository;
import com.example.ticketReservationSystem.service.UserService;
import com.example.ticketReservationSystem.web.LoginSuccessHandler;
//import com.example.ticketReservationSystem.web.SecurityConfiguration;
import com.example.ticketReservationSystem.web.SecurityConfiguration;
import com.fasterxml.jackson.databind.ObjectMapper;
import nonapi.io.github.classgraph.utils.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.StatusAssertions;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@Rollback(false)
//@ContextConfiguration(classes=SecurityConfiguration.class)
//@EnableAutoConfiguration(exclude = { SecurityAutoConfiguration.class,SecurityConfiguration.class })
//@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = UserTestController.class)

//@SpringBootApplication( exclude = { SecurityConfiguration.class} )
@WebMvcTest(RegisterController.class)
//@AutoConfigureMockMvc(addFilters = false)
public class UserTest {


    @Autowired
    private WebApplicationContext webApplicationContext;
    @MockBean
    RoleRepository role;
    @MockBean
    UserRepository userRepository;
    @Autowired
    ObjectMapper mapper;
    @MockBean
    UserService userService;
    @MockBean
    LoginSuccessHandler loginSuccessHandler;
    @Autowired
    MockMvc mvc;
//    @Autowired
//    RoleRepository roleRepository;

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
    public void testCreateUser() throws Exception{
        Role roleuser = role.findByName("ROLE_ADMIN");
        ArrayList<Role> roles = new ArrayList<Role>();
        roles.add(roleuser);

        User user = User.builder()
                .name("admina")
                .surname("adminb")
                .email("admin@gmail.com")
                .password("admin")
                .build();
        Mockito.when(userRepository.save(user)).thenReturn(user);
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/testuser")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(user));
        

        MvcResult result = mvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",notNullValue()))
                .andExpect(jsonPath("$.name",is("admina")))
                .andReturn();
        String content = result.getResponse().getContentAsString();
        System.out.println(content);

    }



}
