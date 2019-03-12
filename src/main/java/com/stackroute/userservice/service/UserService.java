package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.User;

import java.util.List;
import java.util.Optional;


public interface UserService {

    public List<User> getAllUsers();
    public User saveUser(User user);
    public Optional<User> getById(int id);
    public User updateUser(User user,int id);
    public void deleteUser(int id);
}
