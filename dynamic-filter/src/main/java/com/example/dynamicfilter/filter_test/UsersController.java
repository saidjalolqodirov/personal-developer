package com.example.dynamicfilter.filter_test;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.Predicate;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RestController
public class UsersController {
    private final UserRepository repository;

    public UsersController(UserRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/list")
    public List<Users> getList(@RequestBody HashMap<String, String> filter) {
        return repository.findAll(getSpecification(filter));
    }

    private Specification<Users> getSpecification(HashMap<String, String> filter) {
//        HashMap<String, String> filter = filterDto.getFilter();
        return ((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new LinkedList<>();
            query.orderBy(criteriaBuilder.desc(root.get("id")));
            for (Map.Entry<String, String> entry : filter.entrySet()) {
                predicates.add(criteriaBuilder.equal(root.get(entry.getKey()), entry.getValue()));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }
}
