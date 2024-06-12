package com.ima.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ima.models.CustomerOrder;
import com.ima.models.OrderItem;

@Service
public interface OrderService {
	
	CustomerOrder placeOrder(CustomerOrder order);
    List<CustomerOrder> getAllOrders();
    OrderItem getOrderById(Long id);
    void CancelOrder(Long CustomerOrderId);
    OrderItem ProductUpdateOrder(Long id, OrderItem productOrder);

}
