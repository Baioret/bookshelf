package org.baioret.bookshelf.controller;

import org.baioret.bookshelf.repository.User;
import org.baioret.bookshelf.service.UserService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping(path = "api/users")
public class UserController {

    private final UserService userService;

    // DEPENDENCY INJECTION
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping(path = "{id}")
    public User findById(@PathVariable long id) {
        return userService.findById(id);
    }

    @PostMapping
    public User create(@RequestBody User user) { // передать тело запроса в виде джсон объекта с данными о юзере,
                                                    // нужен маппинг этих данных на объект юзер
        return userService.create(user);
    }

    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable Long id) { // переменная пути (будет "api/users/{id}"
        userService.delete(id);
    }

    @PutMapping(path = "{id}")
    public void update(
            @PathVariable Long id,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String name) {

        userService.update(id, email, name);
    }
}
