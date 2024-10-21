package com.example.jpainitailization;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    private final UserService service;

    public Controller(UserService service) {
        this.service = service;
    }


    @GetMapping("/list")
    public List<User> getList() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Integer id) {
        return service.getById(id);
    }
}
