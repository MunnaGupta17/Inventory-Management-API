package com.ima.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ima.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
