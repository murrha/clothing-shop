package com.marja.clothingshop.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Entity
@Table(name = "product")
@Data
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;

	
	@Column(name = "price")
	private BigDecimal price;
	
	@Column(name = "stock")
	private int stock;
	
	@Column(name = "image_url")
	private String imageUrl; 
	
	@Column(name = "active")
	private boolean active; 
	
	//to associate a product with a category
	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	private Category category; 
	
	//for infinite Json recursion error
	@JsonBackReference
	public Category getCategory() {
		return category; 
	}

}
