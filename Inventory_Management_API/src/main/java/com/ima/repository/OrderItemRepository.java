package com.ima.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ima.models.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
