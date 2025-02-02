package com.api.todolist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.todolist.entities.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
