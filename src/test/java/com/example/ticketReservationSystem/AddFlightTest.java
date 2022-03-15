package com.example.ticketReservationSystem;

import com.example.ticketReservationSystem.controller.FlightsController;
import com.example.ticketReservationSystem.controller.FlightsTestController;
import com.example.ticketReservationSystem.model.Flights;
import com.example.ticketReservationSystem.repository.FlightsRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ContextConfiguration(classes = FlightsTestController.class)
@WebMvcTest(FlightsController.class)
public class AddFlightTest {


    @Autowired
    private WebApplicationContext webApplicationContext;
    @MockBean
    FlightsRepository flightsRepository;
    @Autowired
    ObjectMapper mapper;
    @Autowired
    MockMvc mvc;


    @Test
    public void testAddFlight() throws Exception{

        Flights flight = Flights.builder()
                .departureLocation("Riga")
                .arrivalLocation("Vilnius")
                .flightStart("14:00")
                .flightEnd("15:00")
                .ticketPrice(250)
                .flightCapacity(300)
                .flightDate("11.04.2022")
                .flightStatus("confirmed")
                .build();
        Mockito.when(flightsRepository.save(flight)).thenReturn(flight);
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/testFlight")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(flight));


        MvcResult result = mvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",notNullValue()))
                .andExpect(jsonPath("$.departureLocation",is("Riga")))
                .andExpect(jsonPath("$.arrivalLocation",is("Vilnius")))
                .andExpect(jsonPath("$.flightStart",is("14:00")))
                .andExpect(jsonPath("$.flightEnd",is("15:00")))
                .andExpect(jsonPath("$.ticketPrice",is(250)))
                .andExpect(jsonPath("$.flightCapacity",is(300)))
                .andExpect(jsonPath("$.flightDate",is("11.04.2022")))
                .andExpect(jsonPath("$.flightStatus",is("confirmed")))
                .andReturn();
        String content = result.getResponse().getContentAsString();
        System.out.println(content);

    }

}
