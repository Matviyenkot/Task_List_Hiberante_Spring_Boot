package com.list.tasks.tasks_list_hibernate_spring_boot.repo;

import com.list.tasks.tasks_list_hibernate_spring_boot.entity.Task;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class TaskDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public Task findTaskById(int id){

        Session session = entityManager.unwrap(Session.class);
//        Query<Task> query = session.createQuery("from Task where id = 1", Task.class);
////        query.setParameter("taskID", id);
//
//        return query.getSingleResult();

        Task task = session.get(Task.class, id);

        return task;
    }

    public void updateTask(Task task){
        Session session = entityManager.unwrap(Session.class);

        System.out.println("update");

        session.update(task);
//
////        Query<Task> query = session.createQuery("update Task set task =: task, isReady =: ready" +
////                ", isFavorite =: favorite where id =: taskId", Task.class);
//
//        String sql = "update tasks set task = '" + task.getTask() + "', ready = '" + task.isReady() +
//                "', favorite = '" + task.isFavorite() + "', where id = " + task.getId();
//
//        NativeQuery query = session.createSQLQuery(sql);
//
////        query.setParameter("taskId", task.getId());
////        query.setParameter("task", task.getTask());
////        query.setParameter("ready", task.isReady());
////        query.setParameter("favorite", task.isFavorite());
//
//        query.executeUpdate();

    }
}
