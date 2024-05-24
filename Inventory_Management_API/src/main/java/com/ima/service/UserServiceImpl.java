package com.ima.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ima.exception.ResourceNotFoundException;
import com.ima.models.User;
import com.ima.repository.UserRepository;

public class UserServiceImpl implements UserService{
	
	@Autowired
    private UserRepository userRepository;

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public User updateUser(Long userId, User user) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		if (!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException("User not found with id: " + userId);
        }
        user.setId(userId);
        return userRepository.save(user);
	}

	@Override
	public void deleteUser(Long userId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		if (!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException("User not found with id: " + userId);
        }
        userRepository.deleteById(userId);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User getUserById(Long userId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
	}

	@Override
	public User getUserByUsername(String username) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with username: " + username));
	}

}
