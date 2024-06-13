package com.ima.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ima.exception.ResourceNotFoundException;
import com.ima.models.CustomerOrder;
import com.ima.models.OrderItem;
import com.ima.repository.CustomerOrderRepository;
import com.ima.repository.OrderItemRepository;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private CustomerOrderRepository customerOrderRepo;
	
	@Autowired
	private OrderItemRepository orderItemRepo;

	@Override
	public CustomerOrder placeOrder(CustomerOrder order) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		if(order == null)throw new ResourceNotFoundException("order is empty please provide order details");
		return customerOrderRepo.save(order);
	}

	@Override
	public List<CustomerOrder> getAllOrders() {
		// TODO Auto-generated method stub
		return customerOrderRepo.findAll();
	}

	@Override
	public CustomerOrder getOrderById(Long customerOrderId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Optional<CustomerOrder> customerOrder = customerOrderRepo.findById(customerOrderId);
		if(!customerOrder.isPresent()) throw new ResourceNotFoundException("Customer Order not found with this id");
		
		return customerOrder.get();
	}

	@Override
	public String CancelOrder(Long customerOrderId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Optional<CustomerOrder> customerOrder = customerOrderRepo.findById(customerOrderId);
		if(!customerOrder.isPresent()) throw new ResourceNotFoundException("Customer Order not found with this id");
		return "order cancelled successfully";
	}

	@Override
	public OrderItem updateCustomerOrderItem(Long orderItemId, OrderItem updatedOrderItem) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		if(updatedOrderItem == null) throw new ResourceNotFoundException("OrderItem is empty");
		OrderItem orderItem = getOrderItembyId(orderItemId);
		orderItem.setId(updatedOrderItem.getId());
		return orderItemRepo.save(updatedOrderItem);
	}

	@Override
	public OrderItem getOrderItembyId(Long orderItemId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		Optional<OrderItem> orderItem =orderItemRepo.findById(orderItemId);
		if(!orderItem.isPresent()) throw new ResourceNotFoundException("order item is not present with this id");
		return orderItem.get();
	}
	


}
