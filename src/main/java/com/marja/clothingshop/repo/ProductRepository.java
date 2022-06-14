package com.marja.clothingshop.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.marja.clothingshop.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
	List<Product> findByName(String name); 
}
