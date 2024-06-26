package com.ima.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ima.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
