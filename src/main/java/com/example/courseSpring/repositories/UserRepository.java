package com.example.courseSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.courseSpring.entities._User;

public interface UserRepository extends JpaRepository<_User, Long>{
	
}
