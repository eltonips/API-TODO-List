package com.api.todolist.service;

import java.util.List;

import com.api.todolist.dto.ListItemDTO;
import com.api.todolist.entities.ListItem;

public interface ListItemService {

	List<ListItemDTO> findAll();
	
	ListItem findById(Long id);
	
	ListItemDTO findByIdDto(Long id);
	
	ListItem insert(ListItem obj);
	
	void delete(Long id);
	
	ListItem update(Long id, ListItem obj);
	
}
