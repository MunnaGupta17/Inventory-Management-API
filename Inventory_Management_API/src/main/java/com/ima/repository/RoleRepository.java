package com.ima.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ima.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

}
