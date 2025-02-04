package com.api.todolist.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.api.todolist.dto.ItemDTO;
import com.api.todolist.entities.Item;
import com.api.todolist.repositories.ItemRepository;
import com.api.todolist.service.ItemService;
import com.api.todolist.service.ListItemService;
import com.api.todolist.service.exceptions.DatabaseException;
import com.api.todolist.service.exceptions.ResourceNotFoundException;

import jakarta.annotation.Resource;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	private ItemRepository repository;
	
	@Resource
	private ListItemService listItemService;
	
	public List<Item> findAll() {
		return repository.findAll();
	}
	
	public Item findById(Long id) {
		Optional<Item> obj = repository.findById(id); 
		return obj.get();
	}
	
	public ItemDTO insert(ItemDTO obj) {
		Item item = this.converteDtoParaItem(obj);
		repository.saveAndFlush(item);
		return this.converterItemDto(item); 
	}
	
	private Item converteDtoParaItem(ItemDTO itemDto) {
		Item item = new Item();		
		item.setNome(itemDto.getNome());		
		item.setListItemId(listItemService.findById(itemDto.getListItemId()));
		return item;
	}	
	
	private ItemDTO converterItemDto(Item item) {
		ItemDTO itemDto = new ItemDTO();
		itemDto.setId(item.getId());
		itemDto.setNome(item.getNome());
		
		return itemDto;
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
			entity.setNome(obj.getNome());
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

}
