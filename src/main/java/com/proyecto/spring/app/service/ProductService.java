package com.proyecto.spring.app.service;


import java.util.List;
import java.util.Optional;

import com.proyecto.spring.app.entity.Category;
import com.proyecto.spring.app.entity.Product;

public interface ProductService {
	
	public static final int ID_INEXISTENTE = -3;
	
	
	public Product save(Product product);
	public Optional<Product> findById(Long id);
	public List<Product> all();
	public List<Product> findByCategory(Category category);
	public void delete(Product product);
	public Product update(Product product);
	public Product findByName(String name);
}
