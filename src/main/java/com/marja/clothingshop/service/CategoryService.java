package com.marja.clothingshop.service;

import java.util.List;

import com.marja.clothingshop.model.Category;

//where I can define the business logic and methods to be used
public interface CategoryService {
	
	Category getCategory(Long id);
	Category getCategoryByName(String name);
	Category saveCategory(Category category); 
	void deleteCategory(Long id);
	List<Category> getCategories(); 

}
