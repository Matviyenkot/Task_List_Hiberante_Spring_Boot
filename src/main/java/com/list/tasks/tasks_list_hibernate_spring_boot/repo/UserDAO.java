package com.list.tasks.tasks_list_hibernate_spring_boot.repo;

import com.list.tasks.tasks_list_hibernate_spring_boot.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserDAO {

    @PersistenceContext
    private EntityManager entityManager;


    public User findUserById(int id){

        Session session = entityManager.unwrap(Session.class);
        Query<User> query = session.createQuery("from User where id =: userID", User.class);
        query.setParameter("userID", id);

        return query.getSingleResult();
    }

}
