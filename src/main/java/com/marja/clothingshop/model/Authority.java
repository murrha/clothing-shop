package com.marja.clothingshop.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="authority")
@Data
public class Authority {
	 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "authority_id")
	private Long id;
	
	@Column(name="authority")
	private String authority;
	
	@ManyToMany(cascade = CascadeType.ALL, mappedBy="authorities")
	private Collection<User> users; 
}
