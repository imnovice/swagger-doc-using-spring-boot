package com.spring.swagger.doc.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.swagger.doc.dto.Product;
import com.spring.swagger.doc.dto.Status;
import com.spring.swagger.doc.service.ProductService;

@Validated
@RestController
@RequestMapping(path = "api")
public class ProductResource {

	@Autowired
	private ProductService productService;

	@GetMapping("products")
	public List<Product> products() {
		return productService.fetch();
	}

	@GetMapping("products/{id}")
	public Product productByID(@PathVariable("id") Long id, @RequestParam(required = false) Status status) {
		Product product = productService.fetchByID(id);
		if (status != null) {
			return (product.getStatus().equals(status)) ? product : null;
		}
		return product;
	}

	@PutMapping("products/{id}")
	public Product put(@PathVariable("id") Long id, @Valid @RequestBody Product product) {
		product.setId(id);
		return productService.save(product);
	}

	@PostMapping("product/post")
	public Product post(@Valid @RequestBody Product product) {
		return productService.save(product);
	}

	@DeleteMapping("products/{id}")
	public Product delete(@PathVariable("id") Long id) {
		return productService.delete(id);
	}
}
