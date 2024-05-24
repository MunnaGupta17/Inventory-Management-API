package com.ima.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ima.models.Category;
import com.ima.repository.CategoryRepository;

public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
    private CategoryRepository categoryRepository;

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

}
