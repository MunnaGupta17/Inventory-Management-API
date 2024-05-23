package com.ima.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ima.models.Category;

@Service
public interface CategoryService {
	
	Category addCategory(Category category);
    List<Category> getAllCategories();

}
