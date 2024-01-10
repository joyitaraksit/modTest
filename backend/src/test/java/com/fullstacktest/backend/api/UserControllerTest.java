package com.fullstacktest.backend.api;

import com.fullstacktest.backend.model.Sex;
import com.fullstacktest.backend.model.UserRegistration;
import com.fullstacktest.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(UserController.class)
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void successfulUserCreation() throws Exception {
        UserRegistration userRegistration = new UserRegistration();
        userRegistration.setName("Test User");
        userRegistration.setSex(Sex.MALE);
        userRegistration.setAge(30);
        userRegistration.setCountry("US");

        doNothing().when(userService).registerUser(any(UserRegistration.class));

        ObjectMapper objectMapper = new ObjectMapper();
        String userRegistrationJson = objectMapper.writeValueAsString(userRegistration);

        MvcResult mvcResult = mockMvc.perform(post("/user/register")
            .contentType(MediaType.APPLICATION_JSON)
            .content(userRegistrationJson))
            .andExpect(status().isCreated())
            .andExpect(content().string("User has been successfully registered"))
            .andReturn();

        String response = mvcResult.getResponse().getContentAsString();
        assertThat(response).isEqualTo("User has been successfully registered");
    }
    
}