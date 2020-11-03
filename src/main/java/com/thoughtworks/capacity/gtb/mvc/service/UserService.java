package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.dto.UserDto;
import com.thoughtworks.capacity.gtb.mvc.exception.UserAlreadyExistException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private final Map<String, UserDto> users;

    public UserService() {
        users = new HashMap<>();
    }

    public void register(UserDto userDto) {
        if (users.containsKey(userDto.getUserName())) {
            throw new UserAlreadyExistException("用户已存在");
        }
        users.put(userDto.getUserName(), userDto);
    }
}
