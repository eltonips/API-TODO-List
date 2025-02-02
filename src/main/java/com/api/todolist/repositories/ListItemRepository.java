package com.api.todolist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.todolist.entities.ListItem;

public interface ListItemRepository extends JpaRepository<ListItem, Long> {

}
