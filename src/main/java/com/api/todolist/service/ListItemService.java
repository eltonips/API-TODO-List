package com.api.todolist.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;

import com.api.todolist.entities.ListItem;
import com.api.todolist.repositories.ListItemRepository;
import com.api.todolist.service.exceptions.DatabaseException;
import com.api.todolist.service.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

public class ListItemService {
	
	@Autowired
	private ListItemRepository repository;
	
	public List<ListItem> findAll() {
		return repository.findAll();
	}
	
	public ListItem findById(Long id) {
		Optional<ListItem> obj = repository.findById(id); 
		return obj.get();
	}
	
	public ListItem insert(ListItem obj) {
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
	
	public ListItem update(Long id, ListItem obj) {
		try {
			ListItem entity = repository.getReferenceById(id);
			entity.setName(obj.getName());
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

}
