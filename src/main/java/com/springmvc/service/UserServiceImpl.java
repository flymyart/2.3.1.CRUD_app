package com.springmvc.service;

import com.springmvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.springmvc.dao.UserDao;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save(User user) {
        this.userDao.save(user);
    }

    @Override
    public void update(int id, User updatedUser) {
        this.userDao.update(id, updatedUser);
    }

    @Override
    public void delete(int id) {
        this.userDao.delete(id);
    }

    @Override
    public User show(int id) {
        return this.userDao.show(id);
    }

    @Override
    public List<User> listUsers() {
        return this.userDao.listUsers();
    }
}
