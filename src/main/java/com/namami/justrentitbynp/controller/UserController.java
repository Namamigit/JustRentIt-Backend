package com.namami.justrentitbynp.controller;

import com.namami.justrentitbynp.entity.User;
import com.namami.justrentitbynp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;


@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // CREATE
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        User existing = userService.findByEmailAndPassword(user.getEmail(), user.getPassword());

        if (existing != null) {
            return ResponseEntity.ok(existing); // send user data
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }
    // GET ALL
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "User deleted";
    }

    // UPDATE
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }


    }

