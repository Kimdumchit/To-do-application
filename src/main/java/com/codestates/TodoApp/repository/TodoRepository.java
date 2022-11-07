package com.codestates.TodoApp.repository;

import com.codestates.TodoApp.entity.TodoApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<TodoApp,Long> {
}
