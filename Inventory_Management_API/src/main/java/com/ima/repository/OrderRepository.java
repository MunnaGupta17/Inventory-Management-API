package com.ima.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ima.models.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
