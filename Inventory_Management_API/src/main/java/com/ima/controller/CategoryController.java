package com.ima.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ima.exception.CategoryException;
import com.ima.exception.ResourceNotFoundException;
import com.ima.models.Category;
import com.ima.models.Product;
import com.ima.service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService; 
	
	@PostMapping("/add")
	public ResponseEntity<Category> addCategoryController(@RequestBody Category category) throws ResourceNotFoundException{
		return ResponseEntity.ok(categoryService.addCategory(category));
	}
	
	@GetMapping("/get/{categoryId}")
	public ResponseEntity<Category> getCategoryController(@PathVariable Long categoryId) throws CategoryException{
		Category requestedCategory = categoryService.getCategoryById(categoryId);
		return ResponseEntity.ok(requestedCategory);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Category>> getAllcategoriesController(){
		List<Category> requestedCategories = categoryService.getAllCategories();
		return ResponseEntity.ok(requestedCategories);
	}
	
	@GetMapping("/get/product")
	public ResponseEntity<List<Product>> getCategoryAllProductController(@PathVariable Long categoryId) throws CategoryException{
		List<Product> requestedCategoryProducts = categoryService.getCategoryAllProducts(categoryId);
		return  ResponseEntity.ok(requestedCategoryProducts);
	}
	
	@PostMapping("/update/{categoryId}")
	public ResponseEntity<Category> updateCategoryController(@RequestBody Category newCategory,@PathVariable Long categoryId) throws CategoryException, ResourceNotFoundException{
		Category updatedCategory = categoryService.updateCategory(categoryId, newCategory);
		return ResponseEntity.ok(updatedCategory);
	}
	
	@DeleteMapping("/delete/{categoryId}")
	public ResponseEntity<String> deleteCategoryController(@PathVariable Long categoryId) throws CategoryException{
		String deleteMessage = categoryService.deleteCategory(categoryId);
		return ResponseEntity.ok(deleteMessage);
	}

}
