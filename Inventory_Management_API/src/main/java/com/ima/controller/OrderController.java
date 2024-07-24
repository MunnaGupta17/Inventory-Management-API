package com.ima.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ima.exception.ResourceNotFoundException;
import com.ima.models.CustomerOrder;
import com.ima.models.OrderItem;
import com.ima.service.OrderService;

@RestController
@RequestMapping("/user/api/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/customer/add")
	public ResponseEntity<CustomerOrder> placeOrderController(@RequestBody CustomerOrder customerOrder) throws ResourceNotFoundException{
		return  ResponseEntity.ok(orderService.placeOrder(customerOrder));
	}
	@GetMapping("/customer/{customerOrderId}")
	public ResponseEntity<CustomerOrder> getCustomerOrderController(@PathVariable Long customerOrderId) throws ResourceNotFoundException{
		return  ResponseEntity.ok(orderService.getOrderById(customerOrderId));
	}
	@GetMapping("/customer/all")
	public ResponseEntity<List<CustomerOrder>> getAllCustomerOrdersController(){
		return  ResponseEntity.ok(orderService.getAllOrders());
	}
	@GetMapping("/item/{orderItemId}")
	public ResponseEntity<OrderItem> getCustomerOrderItemController(@PathVariable Long orderItemId) throws ResourceNotFoundException{
		return  ResponseEntity.ok(orderService.getOrderItembyId(orderItemId));
	}
	
	@PostMapping("/item/update/{currentOrderItemId}")
	public ResponseEntity<OrderItem> updateCustomerOrderItemController(@PathVariable Long currentOrderItemId,@RequestBody OrderItem currentOrderItem) throws ResourceNotFoundException{
		return  ResponseEntity.ok(orderService.updateCustomerOrderItem(currentOrderItemId, currentOrderItem));
	}
	
	@DeleteMapping("/customer/delete/{customerOrderId}")
	public ResponseEntity<String> cancelOrderController(@PathVariable Long customerOrderId) throws ResourceNotFoundException{
		return ResponseEntity.ok(orderService.CancelOrder(customerOrderId));
	}

}
