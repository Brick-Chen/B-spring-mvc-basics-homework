package com.thoughtworks.capacity.gtb.mvc.controller;

import com.thoughtworks.capacity.gtb.mvc.dto.UserDto;
import com.thoughtworks.capacity.gtb.mvc.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@RestController
@Validated
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
    public ResponseEntity<UserDto> login(@RequestParam("username") @Pattern(regexp = "[0-9A-Za-z_]{3,10}", message = "用户名不合法") String username, @RequestParam("password") @Size(min = 5, max = 12, message = "密码不合法") String password) {
        return ResponseEntity.ok(userService.login(username, password));
    }
}
