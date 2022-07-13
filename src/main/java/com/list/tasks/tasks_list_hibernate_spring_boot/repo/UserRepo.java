package com.list.tasks.tasks_list_hibernate_spring_boot.repo;

import com.list.tasks.tasks_list_hibernate_spring_boot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepo extends JpaRepository<User, Integer> {

    @Transactional
    @Modifying
    @Query("update User t set t.name = ?1, t.username = ?2, t.password = ?3 where t.id = ?4")
    void updateUser(String name, String username, String password, Integer userId);

}
