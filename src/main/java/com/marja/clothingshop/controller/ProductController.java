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

import com.marja.clothingshop.model.Product;
import com.marja.clothingshop.repo.ProductRepository;

@RestController
@RequestMapping(path = "/product")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@PostMapping(path = "/add")
	public ResponseEntity<Product> addNewProduct(@RequestBody Product p){
		try{
			Product product = productRepository.save(p);
			return new ResponseEntity<>(product, HttpStatus.CREATED); 
		} catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); 
		}
		
	}
	
	@GetMapping(path = "")
	public ResponseEntity<List<Product>> getAllProducts(@RequestParam(required=false) String name){
		try {
			List<Product> products = new ArrayList<Product>();
			if(name == null)
				productRepository.findAll().forEach(products::add);
			if(products.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(products, HttpStatus.OK); 
		}catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(path="/{name}")
	public ResponseEntity<List<Product>> getProductByName(@PathVariable("name") String name){
		return new ResponseEntity<List<Product>> (productRepository.findByName(name), HttpStatus.OK); 
	}

}
