package com.api.todolist.service;

import java.util.List;

import com.api.todolist.dto.ItemDTO;
import com.api.todolist.entities.Item;

public interface ItemService {

	List<Item> findAll();
	
	Item findById(Long id);
	
	ItemDTO insert(ItemDTO obj);
	
	void delete(Long id);
	
	Item update(Long id, Item obj);
}
