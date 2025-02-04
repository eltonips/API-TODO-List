package com.api.todolist.dto;

import java.util.List;

import com.api.todolist.entities.Item;

public class ListItemDTO {

	private Long id;
	private String name;
	private List<Item> items;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public ListItemDTO() {		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

}
