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
@Table(name="order")
@Data
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name = "order_id")
	private Long id;
	
	@Column(name="user_id")
	private Long userId;
	
	@Column(name="total")
	private BigDecimal total;

	/*
	 * created at
	 * modified at
	 * */
	
	
}
