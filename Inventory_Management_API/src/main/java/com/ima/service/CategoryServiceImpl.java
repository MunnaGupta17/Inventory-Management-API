package com.ima.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ima.exception.CategoryException;
import com.ima.exception.ResourceNotFoundException;
import com.ima.models.Category;
import com.ima.models.Product;
import com.ima.repository.CategoryRepository;
import com.ima.repository.ProductRepository;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
    private CategoryRepository categoryRepository;
	
	@Autowired
    private ProductRepository productRepository;

	@Override
	public Category addCategory(Category category) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		if(category == null) throw new ResourceNotFoundException("category is null");
		return categoryRepository.save(category);
	}

	@Override
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}

	@Override
	public Category getCategoryById(Long id)throws CategoryException {
		// TODO Auto-generated method stub
		Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            return category.get();
        } else {
            throw new CategoryException("Category not found with id: " + id);
        }
	}

	@Override
	public List<Product> getCategoryAllProducts(Long categoryId) throws CategoryException {
		// TODO Auto-generated method stub
		Category category = getCategoryById(categoryId);
        return productRepository.findByCategoryId(category.getId());
	}

	@Override
	public Category updateCategory(Long id, Category newCategory) throws ResourceNotFoundException, CategoryException {
		// TODO Auto-generated method stub
		if(newCategory == null)throw new ResourceNotFoundException("newCategory is null");
		 Category category = getCategoryById(id);
	      category.setName(newCategory.getName());
	      return categoryRepository.save(category);
	}

	@Override
	public String deleteCategory(Long id) throws CategoryException {
		// TODO Auto-generated method stub
		Category category = getCategoryById(id);
        categoryRepository.delete(category);
        return "category deleted....";
		
	}

}
