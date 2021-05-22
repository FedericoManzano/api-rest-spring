package com.proyecto.spring.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.spring.app.entity.Category;
import com.proyecto.spring.app.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	public List<Product> findByCategory(Category category);
	public Product findByName(String name);
}
