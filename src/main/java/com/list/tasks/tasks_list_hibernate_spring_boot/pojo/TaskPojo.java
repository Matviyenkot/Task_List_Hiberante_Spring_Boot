package com.list.tasks.tasks_list_hibernate_spring_boot.pojo;

public class TaskPojo {

    private String task;
    private boolean isReady;
    private boolean isFavorite;

    public TaskPojo() {
    }

    public TaskPojo(String task, boolean isReady, boolean isFavorite) {
        this.task = task;
        this.isReady = isReady;
        this.isFavorite = isFavorite;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
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

}
