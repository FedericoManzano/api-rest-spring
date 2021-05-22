package com.proyecto.spring.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name="product")
@Data
@AllArgsConstructor
public class Product {
	
	public Product() {
		this.id = -3L;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id; 
	
	@Column(length=20, unique=true)
	private String name;
	
	private String description;
	
	private Double price;
	
	private boolean state;
	
	private Double stock;
	
	@ManyToOne
	@JoinColumn(name="id_category")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name="id_maker")
	private Maker maker;
}
