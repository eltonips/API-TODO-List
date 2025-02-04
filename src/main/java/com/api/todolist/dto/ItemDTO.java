package com.api.todolist.dto;

public class ItemDTO {
	
	private Long id;
	private String nome;
	private Long listItemId;
	
	public ItemDTO() {		
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getListItemId() {
		return listItemId;
	}

	public void setListItemId(Long listItemId) {
		this.listItemId = listItemId;
	}
	
}
