package com.list.tasks.tasks_list_hibernate_spring_boot.controller;

import com.list.tasks.tasks_list_hibernate_spring_boot.entity.User;
import com.list.tasks.tasks_list_hibernate_spring_boot.pojo.UserPojo;
import com.list.tasks.tasks_list_hibernate_spring_boot.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserRepo userRepo;

    @Autowired
    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping("/get/{id}")
    private User getUserById(@PathVariable int id){

        return userRepo.findById(id).get();
    }

    @GetMapping("/get")
    private List<User> getAllUsers(){

        return userRepo.findAll();
    }

    @PutMapping("/update/{id}")
    public void updateUser(@PathVariable int id, @RequestBody UserPojo userPojo){


        userRepo.updateUser(userPojo.getName(), userPojo.getUsername(), userPojo.getPassword(), id);
    }

    @PostMapping("/add")
    public User addNewUser(@RequestBody User user){

        return userRepo.save(user);
    }

}
