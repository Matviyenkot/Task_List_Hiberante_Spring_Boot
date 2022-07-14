package com.list.tasks.tasks_list_hibernate_spring_boot.service;

import com.list.tasks.tasks_list_hibernate_spring_boot.entity.User;
import com.list.tasks.tasks_list_hibernate_spring_boot.pojo.UserPojo;
import com.list.tasks.tasks_list_hibernate_spring_boot.repo.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {

    private UserRepo userRepo;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepo userRepo, BCryptPasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if(user == null){
            log.error("User was not found!");
            throw new UsernameNotFoundException("User was not found!");
        } else {
            log.info("User was found: {}", username);
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }

    @Override
    public User getUserById(int id) {
        return userRepo.findById(id).get();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public void updateUser(int id, UserPojo userPojo) {
//        String password = userPojo.getPassword();
//        String bCryptedPassword = passwordEncoder.encode()
        userRepo.updateUser(userPojo.getName(), userPojo.getUsername(), userPojo.getPassword(), id);
    }

    @Override
    public void addNewUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

}
