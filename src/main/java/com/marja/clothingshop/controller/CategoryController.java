package com.marja.clothingshop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.marja.clothingshop.model.Category;
import com.marja.clothingshop.repo.CategoryRepository;

@RestController
@RequestMapping(path="/category")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {

	@Autowired //get the bean called CategoryRepository
	private CategoryRepository categoryRepository;
	
	@PostMapping(path="/add")
	public ResponseEntity<Category> addNewCategory (@RequestBody Category c) {
		try {
			Category category = categoryRepository.save(c); 
			return new ResponseEntity<> (category, HttpStatus.OK); 
		}catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping(path = "")
	public ResponseEntity<List<Category>> getAllCategories(@RequestParam(required=false) String name){
		try {
			List<Category> categories = new ArrayList<Category>();
			if(name == null)
				categoryRepository.findAll().forEach(categories::add);
			if(categories.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(categories, HttpStatus.OK); 
		}catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(path = "/{name}")
	public ResponseEntity<List<Category>> getCategoryByName(@PathVariable("name") String name){
		return new ResponseEntity<List<Category>> (categoryRepository.findByName(name), HttpStatus.OK); 
	}
}
