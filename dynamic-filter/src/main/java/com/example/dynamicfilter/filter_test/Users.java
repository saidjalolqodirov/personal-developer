package com.example.dynamicfilter.filter_test;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "dynamic_filter_for_users")
public class Users {
    @Id
    private Integer id;
    private String username;
    private String password;
    private String address;
    private String telNumber;
    private String email;

    @Enumerated(EnumType.STRING)
    private UserType userType;
}

enum UserType {
    ADMIN,
    WORKPLACE
}
