package com.people.servies;

import com.people.models.User;
import lombok.extern.log4j.Log4j;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

@Log4j
public class UserService implements Service<User> {

    public User read(int id) {
        EntityManager entityManager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
        User User = new User();
        try {
            entityManager.getTransaction().begin();
            User = entityManager.find(User.class, id);
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (RuntimeException ex) {
            exceptionCatcher(entityManager, ex);
        } finally {
            entityManager.close();
        }
        return User;
    }

    public void create(User User) {
        EntityManager entityManager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(User);
            entityManager.getTransaction().commit();
        } catch (RuntimeException ex) {
            exceptionCatcher(entityManager, ex);
        } finally {
            entityManager.close();
        }
    }

    public void update(User User) {
        EntityManager entityManager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(User);
            entityManager.getTransaction().commit();
        } catch (RuntimeException ex) {
            exceptionCatcher(entityManager, ex);
        } finally {
            entityManager.close();
        }
    }

    public void delete(User user) {
        EntityManager entityManager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entityManager.contains(user) ? user : entityManager.merge(user));
            entityManager.getTransaction().commit();
        } catch (RuntimeException ex) {
            exceptionCatcher(entityManager, ex);
        } finally {
            entityManager.close();
        }
    }

    public List<User> list() {
        EntityManager entityManager = Persistence.createEntityManagerFactory("JPA").createEntityManager();
        List<User> Users = new ArrayList<>();
        try {
            entityManager.getTransaction().begin();
            Users = entityManager.createQuery("from User").getResultList();
            entityManager.getTransaction().commit();
        } catch (RuntimeException ex) {
            exceptionCatcher(entityManager, ex);
        } finally {
            entityManager.close();
        }
        return Users;
    }

    private void exceptionCatcher(EntityManager entityManager, RuntimeException e) {
        entityManager.getTransaction().rollback();
        log.error(e.getMessage());
    }
}
