package com.springmvc.service;

import com.springmvc.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.springmvc.dao.UserDao;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void save(User user) {
        this.userDao.save(user);
    }

    @Override
    @Transactional
    public void update(int id, User updatedUser) {
        this.userDao.update(id, updatedUser);
    }

    @Override
    @Transactional
    public void delete(int id) {
        this.userDao.delete(id);
    }

    @Override
    public User show(int id) {
        return this.userDao.show(id);
    }

    @Override
    @Transactional
    public List<User> listUsers() {
        return this.userDao.listUsers();
    }
}
