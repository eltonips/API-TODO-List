package com.api.todolist.endpoints;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.todolist.dto.ListItemDTO;
import com.api.todolist.entities.ListItem;
import com.api.todolist.service.ListItemService;

@RestController
@RequestMapping(value = "/lists")
public class ListEndpoint {
	
	@Autowired
	private ListItemService service;
	
	@GetMapping
	public ResponseEntity<List<ListItemDTO>> findAll() {
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ListItemDTO> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(service.findByIdDto(id));
	}
	
	@PostMapping
	public ResponseEntity<ListItem> insert(@RequestBody ListItem obj) {
		ListItem listItem = service.insert(obj); 
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(listItem.getId()).toUri();
		return ResponseEntity.created(uri).body(listItem);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ListItem> update(@PathVariable Long id, @RequestBody ListItem obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}

}
