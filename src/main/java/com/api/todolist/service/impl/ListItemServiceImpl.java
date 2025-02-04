package com.api.todolist.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.api.todolist.dto.ListItemDTO;
import com.api.todolist.entities.ListItem;
import com.api.todolist.repositories.ListItemRepository;
import com.api.todolist.service.ListItemService;
import com.api.todolist.service.exceptions.DatabaseException;
import com.api.todolist.service.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ListItemServiceImpl implements ListItemService {

	@Autowired
	private ListItemRepository repository;
	
	public List<ListItemDTO> findAll() {
		return repository.findAll().stream().map(listaItem -> converteParaDto(listaItem)).collect(Collectors.toList());
	}
	
	public ListItem findById(Long id) {
		Optional<ListItem> obj = repository.findById(id); 
		return obj.get();
	}
	
	public ListItemDTO findByIdDto(Long id) {
		Optional<ListItem> obj = repository.findById(id); 
		return converteParaDto(obj.get());
	}
	
	private ListItemDTO converteParaDto(ListItem entity) {
		ListItemDTO listDTO = new ListItemDTO();
		
		listDTO.setId(entity.getId());
		listDTO.setName(entity.getNome());
		listDTO.setItems(entity.getItems());
		
		return listDTO;
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
			entity.setNome(obj.getNome());
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

}
