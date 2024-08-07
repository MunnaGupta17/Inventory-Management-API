package com.ima.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ima.exception.ProductException;
import com.ima.exception.ResourceNotFoundException;
import com.ima.models.Product;
import com.ima.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

	
	@Autowired
    private ProductRepository productRepository;
	
	@Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String fromEmail;

	@Override
	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(Long productId, Product product) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		if(product == null) throw new ResourceNotFoundException("product is null");
		Product existingProduct = getProductById(productId);
		BeanUtils.copyProperties(product, existingProduct, "id");
        return productRepository.save(existingProduct);
	}

	@Override
	public String deleteProduct(Long productId)throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		if (!productRepository.existsById(productId)) {
            throw new ResourceNotFoundException("Product not found with id: " + productId);
        }
        productRepository.deleteById(productId);
        return "Product Deleted...";
		
	}

	@Override
	public List<Product> getAllProducts() throws ProductException {
		 try {
		        return productRepository.findAll();
		    } catch (DataAccessException e) {
		        // Log the exception (optional)
		        logger.error("Error fetching all products", e);
		        // Throw a custom exception
		        throw new ProductException("Failed to fetch all products"+ e);
		    }
	}

	@Override
	public Product getProductById(Long productId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + productId));
	}

	@Override
	public void generateLowStockAlerts() {
		// TODO Auto-generated method stub
		int threshold = 10; // Replace with your actual threshold
        List<Product> lowStockProducts = productRepository.findByQuantityLessThanEqual(threshold);

        for (Product product : lowStockProducts) {
            sendLowStockAlertEmail(product);
        }
	}
	
	private void sendLowStockAlertEmail(Product product) {
        String toEmail = "mgabd17@gmail.com"; // Replace with the actual recipient
        String subject = "Low Stock Alert: " + product.getName();
        String body = "The stock for product " + product.getName() + " (ID: " + product.getId() + ") is low. "
                    + "Current quantity: " + product.getQuantity() + ". Please restock soon.";

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmail);
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(body);

        try {
            mailSender.send(message);
            logger.info("Email sent successfully to " + toEmail);
        } catch (Exception e) {
            logger.error("Error sending email: ", e);
        }
    }

}
