package com.ima.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ima.exception.CategoryException;
import com.ima.exception.ResourceNotFoundException;
import com.ima.models.Category;
import com.ima.models.Product;

@Service
public interface CategoryService {
	
	Category addCategory(Category category)throws ResourceNotFoundException;
    List<Category> getAllCategories();
    Category getCategoryById(Long id)throws CategoryException;
    List<Product> getCategoryAllProducts(Long categoryId)throws CategoryException;
    Category updateCategory(Long id, Category categoryDetails)throws CategoryException,ResourceNotFoundException;
    String deleteCategory(Long id)throws CategoryException;

}
