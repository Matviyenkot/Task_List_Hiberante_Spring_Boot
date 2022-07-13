package com.list.tasks.tasks_list_hibernate_spring_boot.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "task")
    private String task;
    @Column(name = "ready")
    private boolean isReady;
    @Column(name = "favorite", columnDefinition = "BIT")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean isFavorite;
    @Column(name = "created_date")
    private LocalDate createdDate;
    @Column(name = "user_id")
    private Integer userId;

    public Task() {
    }

    public Task(String task, boolean isReady, boolean isFavorite, LocalDate createdDate, Integer userId) {
        this.task = task;
        this.isReady = isReady;
        this.isFavorite = isFavorite;
        this.createdDate = createdDate;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public boolean isReady() {
        return isReady;
    }

    public void setReady(boolean ready) {
        isReady = ready;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }
}
