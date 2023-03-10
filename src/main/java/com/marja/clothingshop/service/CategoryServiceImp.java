package com.marja.clothingshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.marja.clothingshop.model.Category;
import com.marja.clothingshop.repo.CategoryRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor //so we dont have to put Autowired over repositories
@Service
public class CategoryServiceImp implements CategoryService {
	
	private CategoryRepository categoryRepository; 

	@Override
	public Category getCategory(Long id) {
		Optional<Category> category = categoryRepository.findById(id);
		return unwrapCategory(category, id); 
	}

	@Override
	public Category getCategoryByName(String name) {
		Category category = categoryRepository.findByName(name);
		return category;
	}

	@Override
	public Category saveCategory(Category category) {
		return categoryRepository.save(category); 
	}

	@Override
	public void deleteCategory(Long id) {
		categoryRepository.deleteById(id);
		
	}

	@Override
	public List<Category> getCategories() {
		return (List<Category>) categoryRepository.findAll(); 
	}

	
	//to unwrap Optional
	static Category unwrapCategory(Optional<Category> entity, Long id) {
		if(entity.isPresent()) return entity.get();
		else return null; 
	}
}
