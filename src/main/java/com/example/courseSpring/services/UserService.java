package com.example.courseSpring.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.courseSpring.entities._User;
import com.example.courseSpring.repositories.UserRepository;
import com.example.courseSpring.services.exceptions.DatabaseException;
import com.example.courseSpring.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<_User> findAll() {
		return repository.findAll();
	}

	public _User findById(Long id) {
		Optional<_User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public _User insert(_User obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) { // caso não encontre o ID a ser deletado
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) { // caso tente delete um id com pedidos associados a ele
			throw new DatabaseException(e.getMessage());
		}

	}

	public _User update(Long id, _User obj) {
		try {
			_User entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(_User entity, _User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());

	}
}
