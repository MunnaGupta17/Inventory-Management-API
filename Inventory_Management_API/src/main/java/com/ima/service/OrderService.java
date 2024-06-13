package com.ima.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ima.exception.ResourceNotFoundException;
import com.ima.models.CustomerOrder;
import com.ima.models.OrderItem;

@Service
public interface OrderService {
	
	CustomerOrder placeOrder(CustomerOrder order)throws ResourceNotFoundException;
    List<CustomerOrder> getAllOrders();
    CustomerOrder getOrderById(Long id)throws ResourceNotFoundException;
    OrderItem getOrderItembyId(Long orderItemId) throws ResourceNotFoundException;
    String CancelOrder(Long CustomerOrderId)throws ResourceNotFoundException;
    OrderItem updateCustomerOrderItem(Long orderItemId, OrderItem updatedOrderItem) throws ResourceNotFoundException;

}
