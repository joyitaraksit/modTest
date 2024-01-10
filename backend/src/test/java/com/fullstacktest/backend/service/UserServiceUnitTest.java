package com.fullstacktest.backend.service;

import com.fullstacktest.backend.model.UserRegistration;
import com.fullstacktest.backend.persist.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.verify;

@DataJpaTest
public class UserServiceUnitTest {

    @MockBean
    private UserRepository userRepository;

    @Test
    void registerUserTest() {
        // Arrange
        UserRegistration userRegistration = new UserRegistration();
        UserService userService = new UserService(userRepository);

        // Act
        userService.registerUser(userRegistration);

        // Assert
        verify(userRepository).save(userRegistration);
    }

    @Test
    void registerUser() {
    }
}