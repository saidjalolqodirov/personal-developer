package uz.qodirov.jsonrpcserver.user;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class UserRepository {
    private final List<User> users = new ArrayList<>();

    @PostConstruct
    public void init() {
        users.add(new User(1, "user1", "user1", "user1", "user1", "02.12.2020", "Andijon"));
        users.add(new User(2, "user2", "user2", "user2", "user2", "01.10.2009", "Namangan"));
        users.add(new User(3, "user3", "user3", "user3", "user3", "13.06.2012", "Farg'ona"));
        users.add(new User(4, "user4", "user4", "user4", "user4", "17.04.2015", "Navoiy"));
        users.add(new User(5, "user5", "user5", "user5", "user5", "11.09.2020", "Buxoro"));
    }

    public User save(User user) {
        users.add(user);
        return user;
    }

    public List<User> findAll() {
        return users;
    }

    public void deleteById(Integer id) {
        User user = users.stream().filter(o -> Objects.equals(o.getId(), id)).toList().stream().findFirst().orElse(new User());
        users.remove(user);
    }
}
