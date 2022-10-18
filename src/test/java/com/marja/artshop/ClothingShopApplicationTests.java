package com.marja.artshop;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

import com.marja.clothingshop.repo.CategoryRepository;
import com.marja.clothingshop.repo.ProductRepository;

@SpringBootTest
class ClothingShopApplicationTests {

	private CategoryRepository categoryRepository;

	private ProductRepository productRepository; 
	
	@Test
	void getAllCategories() {
		
	}

}
