package com.springmvc.dao;

import com.springmvc.model.User;

import java.util.List;

public interface UserDao {
    void save(User user);
    void update(int id, User updatedUser);
    void delete(int id);
    User show(int id);
    List<User> listUsers();
 }
