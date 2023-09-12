package com.springmvc.dao;

import org.springframework.stereotype.Repository;
import com.springmvc.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public User show(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> listUsers() {
        entityManager.createNativeQuery("CREATE TABLE IF NOT EXISTS users (id BIGINT" +
                " NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                "name VARCHAR(50) NOT NULL, age TINYINT NOT NULL)").executeUpdate();
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(int id, User updatedUser) {
        entityManager.merge(updatedUser);
    }

    @Override
    public void delete(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }
}
