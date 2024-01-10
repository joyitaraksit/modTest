package com.fullstacktest.backend.service;

import com.fullstacktest.backend.model.UserRegistration;
import com.fullstacktest.backend.persist.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser(UserRegistration userRegistration) {
        userRepository.save(userRegistration);
    }
}
