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
import com.ima.models.Product;
import com.ima.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    
    @PostMapping("/add")
    public ResponseEntity<Product> addProductController(@RequestBody Product product){
    	Product addedProduct = productService.addProduct(product);
    	return new ResponseEntity<Product>(addedProduct, HttpStatus.OK);
    	
    }
    
    @PostMapping("/update/{productId}")
    public ResponseEntity<Product> updateProductController(@RequestBody Product product, @PathVariable Long productId) throws ResourceNotFoundException{
    	
		Product updatedProduct = productService.updateProduct(productId, product);
		return new ResponseEntity<Product>(updatedProduct,HttpStatus.ACCEPTED);
		
    }
    
    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<String> deleteProductController(@PathVariable Long productId) throws ResourceNotFoundException{
    	
    	String deletedProduct = productService.deleteProduct(productId);
    	return new ResponseEntity<String>(deletedProduct,HttpStatus.NO_CONTENT);
    	
    }
    
    @GetMapping("/get")
    public ResponseEntity<List<Product>> getAllProductController(){
    	return new ResponseEntity<List<Product>>(productService.getAllProducts(),HttpStatus.ACCEPTED);
    }
    
    @GetMapping("/get/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable Long productId) throws ResourceNotFoundException{
    	Product product = productService.getProductById(productId); 
    	return new ResponseEntity<Product>(product,HttpStatus.ACCEPTED);
    }

    
    @PostMapping("/alerts/low-stock")
    public ResponseEntity<Void> generateLowStockAlerts() {
        productService.generateLowStockAlerts();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
