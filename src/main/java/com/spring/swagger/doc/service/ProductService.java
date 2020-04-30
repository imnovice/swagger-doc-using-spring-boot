package com.spring.swagger.doc.service;

import java.util.List;

import com.spring.swagger.doc.dto.Product;

public interface ProductService {

	public Product save(Product product);

	public Product fetchByID(Long id);

	public List<Product> fetch();
	
	public Product delete(Long id);
}
