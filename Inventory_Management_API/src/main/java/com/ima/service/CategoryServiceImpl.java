package com.ima.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.ima.models.Category;
import com.ima.models.Product;
import com.ima.repository.CategoryRepository;
import com.ima.repository.ProductRepository;

public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
    private CategoryRepository categoryRepository;
	
	@Autowired
    private ProductRepository productRepository;

	@Override
	public Category addCategory(Category category) {
		// TODO Auto-generated method stub
		return categoryRepository.save(category);
	}

	@Override
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}

	@Override
	public Category getCategoryById(Long id) {
		// TODO Auto-generated method stub
		Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            return category.get();
        } else {
            throw new RuntimeException("Category not found with id: " + id);
        }
	}

	@Override
	public List<Product> getCategoryAllProducts(Long categoryId) {
		// TODO Auto-generated method stub
		Category category = getCategoryById(categoryId);
        return productRepository.findByCategoryId(category.getId());
	}

	@Override
	public Category updateCategory(Long id, Category categoryDetails) {
		// TODO Auto-generated method stub
		 Category category = getCategoryById(id);
	        category.setName(categoryDetails.getName());
	        return categoryRepository.save(category);
	}

	@Override
	public void deleteCategory(Long id) {
		// TODO Auto-generated method stub
		Category category = getCategoryById(id);
        categoryRepository.delete(category);
		
	}

}
