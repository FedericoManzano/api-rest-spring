package com.proyecto.spring.app.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="spec")
@Data
public class Spec implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@OneToOne
	@JoinColumn(name="id_producto")
	private Product product;
	
	private String memory;
	private String storage;
	private String processor;
	private String motherboard;
	private String video;
	
	
}
