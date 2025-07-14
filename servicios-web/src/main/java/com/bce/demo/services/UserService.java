package com.bce.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bce.demo.dao.UserRepository;
import com.bce.demo.entities.User;

@Service

public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }
    public User create(User user){
        return userRepository.save(user);
    }

    public User getUserByIdUser(Integer userId){
        return userRepository.findById(userId).orElse(null);
    }

    public User deleteUserByIdUser(Integer userId) {
    Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            userRepository.deleteById(userId);
            return optionalUser.get();
        } else {
            return null;
        }
    }

    public User updateUser(int userId, User userDetails) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setName(userDetails.getName());
            user.setAddress(userDetails.getAddress());
            user.setPhone(userDetails.getPhone());
            // otros campos que necesites
            return userRepository.save(user);
        } else {
            return null;
        }
    }
}
