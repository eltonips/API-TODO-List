package com.api.todolist.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.api.todolist.entities.Item;
import com.api.todolist.repositories.ItemRepository;
import com.api.todolist.service.exceptions.DatabaseException;
import com.api.todolist.service.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ItemService {

	@Autowired
	private ItemRepository repository;
	
	public List<Item> findAll() {
		return repository.findAll();
	}
	
	public Item findById(Long id) {
		Optional<Item> obj = repository.findById(id); 
		return obj.get();
	}
	
	public Item insert(Item obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Item update(Long id, Item obj) {
		try {
			Item entity = repository.getReferenceById(id);
			entity.setName(obj.getName());
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
}
