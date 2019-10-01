package ch.zli.m223.todo.controller;

import ch.zli.m223.todo.domain.User;
import ch.zli.m223.todo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/entries")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllEntries() {
        return userService.findAll();
    }

    @PostMapping("new")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@Valid @RequestBody User user) {
        return userService.createUser(user);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public User updateUser(@Valid @RequestBody User user, @PathVariable Long id) {
        return userService.updateUser(user, id);
    }
}