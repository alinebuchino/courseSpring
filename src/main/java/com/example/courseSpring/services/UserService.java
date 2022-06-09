package com.example.courseSpring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.courseSpring.entities._User;
import com.example.courseSpring.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<_User> findAll() {
		return repository.findAll();
	}
	
	public _User findById(Long id) {
		Optional<_User> obj = repository.findById(id);
		return obj.get();
	}
	
	public _User insert(_User obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public _User update(Long id, _User obj) {
		_User entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(_User entity, _User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		
	}
}
