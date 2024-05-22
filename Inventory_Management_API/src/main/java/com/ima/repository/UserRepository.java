package com.ima.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ima.models.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
