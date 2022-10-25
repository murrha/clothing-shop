package com.marja.clothingshop.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="cart_item")
@Data
public class CartItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name = "cart_item_id")
	private Long id;
	
	@Column(name="product_id")
	private Long productId; 
	
	@Column(name="total")
	private BigDecimal total;
	
	@Column(name="quantity")
	private int quantity; 
}
