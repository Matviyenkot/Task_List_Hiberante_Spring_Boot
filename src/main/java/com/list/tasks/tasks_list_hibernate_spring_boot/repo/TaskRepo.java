package com.list.tasks.tasks_list_hibernate_spring_boot.repo;


import com.list.tasks.tasks_list_hibernate_spring_boot.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.transaction.annotation.Transactional;


public interface TaskRepo extends JpaRepository<Task, Integer> {

    @Transactional
    @Modifying
    @Query("update Task t set t.task = ?1, t.isFavorite = ?2, t.isReady = ?3 where t.id = ?4")
    void updateTask(String firstname, boolean isFavorite, boolean isReady, Integer taskId);

}
