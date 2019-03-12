package com.stackroute.userservice.service;


import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    //add a user
    public User saveUser(User user){
        User savedUser=userRepository.save(user);
        return savedUser;
    }

    //Get all users
    public List<User> getAllUsers(){
        List<User> allUsers= (List<User>) userRepository.findAll();
        return allUsers;
    }

    @Override
    public Optional<User> getById(int id) {
        return userRepository.findById(id);

    }

    @Override
    public User updateUser(User user,int id) {

        User userToUpdate=userRepository.findById(id).get();
        userToUpdate.setAge(user.getAge());
        return userRepository.save(userToUpdate);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}
