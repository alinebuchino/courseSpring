package com.example.courseSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.courseSpring.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
	
}
