package com.thoughtworks.capacity.gtb.mvc.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class UserDto {
    @Pattern(regexp = "[0-9A-Za-z_]{3,10}")
    @NotEmpty
    private String userName;

    @Size(min = 5, max = 12)
    @NotEmpty
    private String password;

    @Email
    private String email;
}
