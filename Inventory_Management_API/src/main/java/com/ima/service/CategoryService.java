package com.ima.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ima.models.Category;
import com.ima.models.Product;

@Service
public interface CategoryService {
	
	Category addCategory(Category category);
    List<Category> getAllCategories();
    Category getCategoryById(Long id);
    List<Product> getCategoryAllProducts(Long categoryId);
    Category updateCategory(Long id, Category categoryDetails);
    void deleteCategory(Long id);

}
