package com.proyecto.spring.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.spring.app.entity.Category;
import com.proyecto.spring.app.entity.Product;
import com.proyecto.spring.app.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ControllerProduct {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Product product) {
		Product pro = productService.findByName(product.getName());
		if(pro != null) 
			return ResponseEntity.noContent().build();
		product.setState(true);
		return ResponseEntity.ok(productService.save(product));
	}
	
	@PostMapping("/product_x_category")
	public ResponseEntity<?> findByCategory(@RequestBody Category category) {
		List<Product> listado = productService.findByCategory(category);
		if(listado.isEmpty())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(listado);
	}
	
	@GetMapping("name/{name}")
	public ResponseEntity<?> findbyName(@PathVariable String name) {
		return ResponseEntity.ok(productService.findByName(name));
	}
	
	@GetMapping("id/{id}")
	public ResponseEntity<?> findbyId(@PathVariable Long id) {
		return ResponseEntity.ok(productService.findById(id));
	}
	
	@PutMapping("id/{id}") 
	public ResponseEntity<?> update(@RequestBody Product product, @PathVariable Long id) {
		product.setId(id);
		Product pro = productService.update(product);
		if(pro == null)
			return ResponseEntity.status(HttpStatus.CONFLICT).body("El producto no existe");
		return ResponseEntity.ok(pro);
	}
	
	
}
