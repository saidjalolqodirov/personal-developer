package com.example.rabbitmq;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String name;
    private Integer age;
    private String address;
    private String phone;
    private String email;
}
