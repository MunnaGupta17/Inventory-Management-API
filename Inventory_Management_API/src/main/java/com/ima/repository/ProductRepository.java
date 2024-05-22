package com.ima.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ima.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
