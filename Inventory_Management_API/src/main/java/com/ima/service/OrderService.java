package com.ima.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ima.models.CustomerOrder;

@Service
public interface OrderService {
	
	CustomerOrder placeOrder(CustomerOrder order);
    List<CustomerOrder> getAllOrders();

}
