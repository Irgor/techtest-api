package com.example.techtestapi.user;

import ch.qos.logback.core.net.SyslogOutputStream;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        User created = userService.createUser(user);
        return created;
    }

    @PutMapping("/{id}")
    public User updateUser(@RequestBody User user, @PathVariable int id) {
        User updated = userService.updateUser(user, id);
        return updated;
    }

    @DeleteMapping(path = "/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
    }

}
