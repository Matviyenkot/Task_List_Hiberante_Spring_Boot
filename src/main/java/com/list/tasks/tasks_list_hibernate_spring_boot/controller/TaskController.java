package com.list.tasks.tasks_list_hibernate_spring_boot.controller;

import com.list.tasks.tasks_list_hibernate_spring_boot.entity.Task;
import com.list.tasks.tasks_list_hibernate_spring_boot.pojo.TaskPojo;
import com.list.tasks.tasks_list_hibernate_spring_boot.repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {


    private TaskRepo taskRepo;

    @Autowired
    public TaskController(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    @GetMapping("/get/{id}")
    private Task getTaskById(@PathVariable int id){

        return taskRepo.findById(id).get();
    }

    @GetMapping("/get")
    public List<Task> getAllTasks(){

        return taskRepo.findAll();
    }

    @PostMapping("/add")
    private Task addTask(@RequestBody Task task){

        LocalDate localDate = LocalDate.now();
        task.setCreatedDate(localDate);

       return taskRepo.save(task);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTask(@PathVariable int id){

        taskRepo.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public void updateTask(@RequestBody TaskPojo task, @PathVariable int id){

        taskRepo.updateTask(task.getTask(), task.isFavorite(), task.isReady(), id);
    }
}
