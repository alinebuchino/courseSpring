package com.example.courseSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.courseSpring.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	
}
