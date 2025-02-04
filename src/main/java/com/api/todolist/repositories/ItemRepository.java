package com.api.todolist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.api.todolist.entities.Item;

@Transactional(readOnly = true)
public interface ItemRepository extends JpaRepository<Item, Long> {

}
