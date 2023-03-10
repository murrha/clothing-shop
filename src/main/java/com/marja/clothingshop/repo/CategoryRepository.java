package com.marja.clothingshop.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.marja.clothingshop.model.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
	Category findByName(String name); 
}
