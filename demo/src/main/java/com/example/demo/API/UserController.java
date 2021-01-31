package com.example.demo.API;

import com.example.demo.Model.User;
import com.example.demo.service.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/user")
@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity addUser(@RequestBody User user) {

        if (userService.insertUser(user) == true) {
            return ResponseEntity.ok(user);
        }

        if (user == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        return ResponseEntity.status(400).body("Incorret values");
    }

    @PutMapping
    public ResponseEntity updateUser(@RequestBody User user) {
        if (userService.updateUser(user) == true) {
            return ResponseEntity.ok(user);
        }

        if (user == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        return ResponseEntity.status(400).body("Something wrong");
    }

    @DeleteMapping
    public ResponseEntity deleteUser(@RequestBody User user) {
        int id = user.getUser_id();

        if (user == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        if (userService.deleteUser(id) == true) {
            return ResponseEntity.ok(user);
        }

        return ResponseEntity.status(400).body("something broke");
    }

    @GetMapping
    public ResponseEntity getUser(@RequestBody User user) {
        int id = user.getUser_id();

        if (user == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        User userRecived = userService.getUser(id);

        if (userRecived != null) {
            return ResponseEntity.ok(userRecived);
        }

        return ResponseEntity.status(400).body("could not retrive user");
    }


    @RequestMapping(method = RequestMethod.GET, value = "/all")
    public ResponseEntity getUsers() {

        return ResponseEntity.ok(userService.getUsers());
    }

}
