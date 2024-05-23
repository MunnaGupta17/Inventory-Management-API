package com.ima.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ima.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
