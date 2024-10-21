package uz.qodirov.jsonrpcclent.user;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return service.create(user);
    }

    @GetMapping("/list")
    public Object list() {
        return service.list();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
