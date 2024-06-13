package com.ima.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ima.models.CustomerOrder;

@Repository
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long>{

}
