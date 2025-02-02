package com.api.todolist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.todolist.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
