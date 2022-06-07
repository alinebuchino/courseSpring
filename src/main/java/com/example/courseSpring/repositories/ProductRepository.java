package com.example.courseSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.courseSpring.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
}
