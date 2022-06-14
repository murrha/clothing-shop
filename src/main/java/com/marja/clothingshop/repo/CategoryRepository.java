package com.marja.clothingshop.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.marja.clothingshop.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
	List<Category> findByName(String name); 
}
