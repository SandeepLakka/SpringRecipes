package io.github.sandeeplakka.restservice.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(GreetingController.class)
class GreetingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void greet_ShouldReturnDefaultResp() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/greeting"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.content").value("Hello, World"));
    }

    @Test
    public void greet_ShouldReturnGivenName() throws Exception {
        final String USER = "John Doe";
        mockMvc.perform(
                        MockMvcRequestBuilders.get("/greeting?name="+USER))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.content").value("Hello, "+USER));
    }


}