package com.fullstacktest.backend.api;
import com.fullstacktest.backend.model.UserRegistration;
import com.fullstacktest.backend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.Valid;

@RestController
@RequestMapping("user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public @ResponseBody ResponseEntity<String> register(@Valid @RequestBody UserRegistration userRegistration) throws HttpClientErrorException.Conflict {
        userService.registerUser(userRegistration);
        return new ResponseEntity<String>("User has been successfully registered", HttpStatus.CREATED);
    }

}
