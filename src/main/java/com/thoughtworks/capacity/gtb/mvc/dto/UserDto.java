package com.thoughtworks.capacity.gtb.mvc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@Builder
@AllArgsConstructor
public class UserDto {
    Integer id;
    @Pattern(regexp = "[0-9A-Za-z_]{3,10}", message = "用户名不合法")
    @NotBlank(message = "用户名不为空")
    private String userName;

    @Size(min = 5, max = 12, message = "密码不合法")
    @NotEmpty
    private String password;

    @Email(message = "邮箱地址不合法")
    private String email;
}
