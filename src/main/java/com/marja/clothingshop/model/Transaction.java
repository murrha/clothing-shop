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
@Table(name="transaction")
@Data
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name = "transaction_id")
	private Long id;
	
	@Column(name="user_id")
	private Long userId; 
	
	@Column(name="order_id")
	private Long orderId;
	
	@Column(name = "amount")
	private BigDecimal amount;
	
	/*need enums for provider (Visa, American Express, Mastercard, Discover)*/
	/*need enums for status (Received, In-Progress, Confirmed, Shipped)*/
	
	
}
