package com.spring.swagger.doc.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.spring.swagger.doc.dto.Product;
import com.spring.swagger.doc.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	// NOTE:
	// Temporary storing all products into HashMap for this demo.
	private Map<Long, Product> productMap = new HashMap<>();

	@Override
	public Product save(Product product) {
		productMap.put(product.getId(), product);
		return product;
	}

	@Override
	public Product fetchByID(Long id) {
		return productMap.get(id);
	}

	@Override
	public List<Product> fetch() {
		return productMap.values().stream().collect(Collectors.toCollection(ArrayList::new));
	}

	@Override
	public Product delete(Long id) {
		return productMap.remove(id);
	}

}
