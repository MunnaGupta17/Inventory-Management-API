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
		return new ResponseEntity<Category>(categoryService.addCategory(category),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/get/{categoryId}")
	public ResponseEntity<Category> getCategoryController(@PathVariable Long categoryId) throws CategoryException{
		Category requestedCategory = categoryService.getCategoryById(categoryId);
		return new ResponseEntity<Category>(requestedCategory,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<Category>> getAllcategoriesController(){
		List<Category> requestedCategories = categoryService.getAllCategories();
		return new ResponseEntity<List<Category>>(requestedCategories,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/get/product")
	public ResponseEntity<List<Product>> getCategoryAllProductController(@PathVariable Long categoryId) throws CategoryException{
		List<Product> requestedCategoryProducts = categoryService.getCategoryAllProducts(categoryId);
		return new ResponseEntity<List<Product>>(requestedCategoryProducts,HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/update/{categoryId}")
	public ResponseEntity<Category> updateCategoryController(@RequestBody Category newCategory,@PathVariable Long categoryId) throws CategoryException, ResourceNotFoundException{
		Category updatedCategory = categoryService.updateCategory(categoryId, newCategory);
		return new ResponseEntity<Category>(updatedCategory,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{categoryId}")
	public ResponseEntity<String> deleteCategoryController(@PathVariable Long categoryId) throws CategoryException{
		String deleteMessage = categoryService.deleteCategory(categoryId);
		return new ResponseEntity<String>(deleteMessage,HttpStatus.ACCEPTED);
	}

}
