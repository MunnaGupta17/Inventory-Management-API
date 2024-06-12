package com.ima.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ima.exception.ResourceNotFoundException;
import com.ima.models.Product;

@Service
public interface ProductService {
	
	Product addProduct(Product product);
    Product updateProduct(Long productId, Product product)throws ResourceNotFoundException;
    String deleteProduct(Long productId)throws ResourceNotFoundException;
    List<Product> getAllProducts();
    Product getProductById(Long productId)throws ResourceNotFoundException;
    void generateLowStockAlerts();

}
