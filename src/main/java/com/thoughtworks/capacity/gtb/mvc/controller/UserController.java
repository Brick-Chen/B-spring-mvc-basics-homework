package com.thoughtworks.capacity.gtb.mvc.controller;

import com.thoughtworks.capacity.gtb.mvc.dto.UserDto;
import com.thoughtworks.capacity.gtb.mvc.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity register(@Valid @RequestBody UserDto userDto) {
        userService.register(userDto);
        return ResponseEntity.created(null).build();
    }

    @GetMapping("/login")
    public ResponseEntity<UserDto> login(@RequestParam("name") String name, @RequestParam("password") String password) {
        return ResponseEntity.ok(userService.login(name, password));
    }
}
