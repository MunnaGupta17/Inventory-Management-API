package com.ima.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ima.exception.ResourceNotFoundException;
import com.ima.models.User;

@Service
public interface UserService {
	
	User addUser(User user);
    User updateUser(Long userId, User user)throws ResourceNotFoundException;
    void deleteUser(Long userId) throws ResourceNotFoundException;
    List<User> getAllUsers();
    User getUserById(Long userId)throws ResourceNotFoundException;
    User getUserByUsername(String username)throws ResourceNotFoundException;

}
