package com.spring.tests.productservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.tests.productservices.dao.ProductDao;
import com.spring.tests.productservices.model.Product;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductDao productDao;

	@GetMapping
	public List<Product> listAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int qtdPage, @RequestParam(defaultValue = "name") String sort,
			@RequestParam(defaultValue = "ASC") Sort.Direction sortDirection) {
		return productDao.findAll(PageRequest.of(page, qtdPage, sortDirection, sort)).getContent();
	}

	@GetMapping("/{id}")
	public Product find(@PathVariable Long id) {
		return productDao.findById(id).get();
	}

	@PostMapping
	public Product save(@RequestBody Product product) {
		return productDao.save(product);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		productDao.deleteById(id);
	}

}
