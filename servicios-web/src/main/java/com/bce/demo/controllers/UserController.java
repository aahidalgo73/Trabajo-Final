package com.bce.demo.controllers;

import java.net.http.HttpClient;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bce.demo.entities.User;
import com.bce.demo.services.UserService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/users")


public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<User> getAllUsers(){
        return userService.findAll();
    }

    @PostMapping("/add")
    public User createUser(@RequestBody User user){
        return userService.create(user);
        //return new ResponseEntity<List<User>>(userService.create(user), HttpClient.ok);
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") Integer userId){
        return userService.getUserByIdUser(userId);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<User> deleteUser(@PathVariable("userId") Integer userId) {
    User deletedUser = userService.deleteUserByIdUser(userId);
        if (deletedUser != null) {
            return ResponseEntity.ok(deletedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable int id, @RequestBody User user) {
        User updatedUser = userService.updateUser(id, user);
        if (updatedUser != null) {
            Map<String, String> response = new HashMap<>();
            response.put("status", "success");
            response.put("message", "Usuario actualizado correctamente");
            return ResponseEntity.ok(response);
        } else {
            Map<String, String> response = new HashMap<>();
            response.put("status", "error");
            response.put("message", "Usuario no encontrado");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

}
