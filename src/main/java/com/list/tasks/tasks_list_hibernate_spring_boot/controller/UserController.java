package com.list.tasks.tasks_list_hibernate_spring_boot.controller;

import com.list.tasks.tasks_list_hibernate_spring_boot.entity.User;
import com.list.tasks.tasks_list_hibernate_spring_boot.pojo.UserPojo;
import com.list.tasks.tasks_list_hibernate_spring_boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get/{id}")
    private User getUserById(@PathVariable int id){

        return userService.getUserById(id);
    }

    @GetMapping("/get")
    private List<User> getAllUsers(){

        return userService.getAllUsers();
    }

    @PutMapping("/update/{id}")
    public void updateUser(@PathVariable int id, @RequestBody UserPojo userPojo){

        userService.updateUser(id, userPojo);
    }

    @PostMapping("/add")
    public void addNewUser(@RequestBody User user){

        userService.addNewUser(user);
    }


}
