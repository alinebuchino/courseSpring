package com.example.courseSpring.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.courseSpring.entities._User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<_User> findAll() {
		_User u = new _User(1L, "Maria", "maria@gmail.com", "99999", "12345");
		return ResponseEntity.ok().body(u);
	}
}
