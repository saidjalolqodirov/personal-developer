package com.example.jpainitailization;

import org.hibernate.Session;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final EntityManager entityManager;

    public UserService(UserRepository userRepository, EntityManager entityManager) {
        this.userRepository = userRepository;
        this.entityManager = entityManager;
    }

    public List<User> getAll() {
        Session session = entityManager.unwrap(Session.class);
        if (session.isOpen()) {
            System.out.println("Sessiya ochiq");
        } else {
            System.out.println("Sessiya ochiq emas");
        }
        return getList();
    }

    private List<User> getList() {
        return userRepository.findAllByDaletedDateIsNull();
    }

    public User getById(Integer id) {
        User user = userRepository.findById(id).get();
        System.out.println("user = " + user);
        return user;
    }
}
