package com.ima.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ima.models.CustomerOrder;
import com.ima.models.OrderItem;
import com.ima.repository.OrderRepository;

public class OrderServiceImpl implements OrderService{
	
	@Autowired
    private OrderRepository orderRepository;

	@Override
	public CustomerOrder placeOrder(CustomerOrder order) {
		// TODO Auto-generated method stub
		return orderRepository.save(order);
	}

	@Override
	public List<CustomerOrder> getAllOrders() {
		// TODO Auto-generated method stub
		return orderRepository.findAll();
	}

	@Override
	public OrderItem getOrderById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void CancelOrder(Long CustomerOrderId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public OrderItem ProductUpdateOrder(Long id, OrderItem productOrder) {
		// TODO Auto-generated method stub
		return null;
	}

}
