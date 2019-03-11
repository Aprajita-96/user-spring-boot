package com.stackroute.userservice.controller;

import com.stackroute.userservice.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.stackroute.userservice.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("user")
    public ResponseEntity<User> saveUser(@RequestBody User user){
         User savedUser=userService.saveUser(user);
         return new ResponseEntity<User>(savedUser, HttpStatus.OK);

    }
    @DeleteMapping("user")
    public void deleteUser(@RequestBody User user){
        userService.deleteUser(user);
    }
    @GetMapping("users")
    public ResponseEntity<List> getAll(){
        List<User> saved=userService.getAll();
        return new ResponseEntity <List>(saved,HttpStatus.OK);
    }
    @GetMapping("user/{id}")
    public ResponseEntity<User> getById(@PathVariable("id") int id){

        return new ResponseEntity<User>(userService.findUserById(id),HttpStatus.OK);
    }
    @PutMapping("/user/{id}")
    public User updateUser(@RequestBody User user,@PathVariable("id") int id){
        return userService.updateUser(user,id);
    }
}
