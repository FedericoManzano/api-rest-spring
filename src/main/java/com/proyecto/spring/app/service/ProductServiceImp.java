package com.proyecto.spring.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.spring.app.entity.Category;
import com.proyecto.spring.app.entity.Product;
import com.proyecto.spring.app.repository.ProductRepository;

@Service
public class ProductServiceImp implements ProductService {

	@Autowired
	private ProductRepository productRepository; 
	
	
	@Override
	public Product save(Product product) {
		product.setState(true);
		return productRepository.save(product);
	}

	@Override
	public Optional<Product> findById(Long id) {
		return productRepository.findById(id);
	}

	@Override
	public List<Product> all() {
		return productRepository.findAll();
	}

	@Override
	public List<Product> findByCategory(Category category) {
		return productRepository.findByCategory(category);
	}

	@Override
	public void delete(Product product) {
		productRepository.delete(product);
	}

	@Override
	public Product update(Product product) {
		Optional<Product> pro = productRepository.findById(product.getId());
		if(!pro.isPresent())
			return null;
		Product proAct = pro.get();
		proAct.setStock(product.getStock());
		proAct.setDescription(product.getDescription());
		proAct.setName(product.getName());
		proAct.setPrice(product.getPrice());
		return productRepository.save(proAct);
	}

	@Override
	public Product findByName(String name) {
		Product pro = productRepository.findByName(name);
		if(pro == null)
			return null;
		return pro;
	}

}
