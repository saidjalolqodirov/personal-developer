package com.example.dynamicfilter.filter_test;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepository extends JpaRepository<Users, Integer>,
        JpaSpecificationExecutor<Users> {
}
