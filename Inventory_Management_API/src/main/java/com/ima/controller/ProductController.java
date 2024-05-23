package com.ima.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ima.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Other CRUD endpoints
    
//    <dependency>
//	<groupId>org.springframework.boot</groupId>
//	<artifactId>spring-boot-starter-security</artifactId>
//</dependency>

    @PostMapping("/alerts/low-stock")
    public ResponseEntity<Void> generateLowStockAlerts() {
        productService.generateLowStockAlerts();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
