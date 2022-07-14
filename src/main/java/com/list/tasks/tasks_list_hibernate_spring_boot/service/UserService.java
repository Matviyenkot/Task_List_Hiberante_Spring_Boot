package com.list.tasks.tasks_list_hibernate_spring_boot.service;

import com.list.tasks.tasks_list_hibernate_spring_boot.entity.User;
import com.list.tasks.tasks_list_hibernate_spring_boot.pojo.UserPojo;

import java.util.List;

public interface UserService {

    User getUserById(int id);
    List<User> getAllUsers();
    void updateUser(int id, UserPojo userPojo);
    void addNewUser(User user);
    User findByUsername(String username);
}
