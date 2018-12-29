package com.spring.tests.productservices.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.tests.productservices.model.Product;

public interface ProductDao extends JpaRepository<Product, Long> {

	Product findByNameStartingWithIgnoreCase(String name); 
}
