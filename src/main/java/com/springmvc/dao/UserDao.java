package com.springmvc.dao;

import com.springmvc.model.User;

import java.util.List;

public interface UserDao {
    public void save(User user);
    public void update(int id, User updatedUser);
    public void delete(int id);
    public User show(int id);
    public List<User> listUsers();
 }
