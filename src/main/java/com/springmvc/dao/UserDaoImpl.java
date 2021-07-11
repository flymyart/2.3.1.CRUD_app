package com.springmvc.dao;

import org.springframework.stereotype.Repository;
import com.springmvc.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
//    private static int USERS_COUNT;
//    private List<User> users;
//
//
//    {
//        users = new ArrayList<>();
//
//        users.add(new User(++USERS_COUNT, "Kate", 35));
//        users.add(new User(++USERS_COUNT, "Mike", 30));
//        users.add(new User(++USERS_COUNT, "Ivan", 37));
//        users.add(new User(++USERS_COUNT, "Tom", 39));
//    }

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public User show(int id) {

//        return users.stream().filter(user -> user.getId() == id).findAny().orElse(null);

        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> listUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
//        return users;
//        return null;
    }

    @Override
    public void save(User user) {
//        user.setId(++USERS_COUNT);
//        users.add(user);

        entityManager.persist(user);
    }

    @Override
    public void update(int id, User updatedUser) {
//        User personToBeUpdated = show(id);
//
//        personToBeUpdated.setName(updatedUser.getName());
//        personToBeUpdated.setAge(updatedUser.getAge());
        entityManager.merge(updatedUser);
    }

    @Override
    public void delete(int id) {

//        users.removeIf(u -> u.getId() == id);
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }
}
