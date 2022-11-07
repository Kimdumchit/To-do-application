package com.codestates.TodoApp.service;

import com.codestates.TodoApp.entity.TodoApp;
import com.codestates.TodoApp.repository.TodoRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    public TodoApp createTodo(TodoApp todoApp){
        return todoRepository.save(todoApp);
    }

    public TodoApp updateTodo(TodoApp todoApp){
        TodoApp findTodo = findVerifiedTodo(todoApp.getId());

        Optional.ofNullable(todoApp.getTitle())
                .ifPresent(title -> findTodo.setTitle(title));
        Optional.ofNullable(todoApp.getOrder())
                .ifPresent(orders -> findTodo.setOrder(orders));
        Optional.ofNullable(todoApp.getCompleted())
                .ifPresent(completed -> findTodo.setCompleted(completed));

        return todoRepository.save(findTodo);
    }
    public TodoApp findTodo(Long todo_id){
        return findVerifiedTodo(todo_id);
    }

    public List<TodoApp> findAllTodo(){
        return (List<TodoApp>) todoRepository.findAll();
    }

    public void deleteTodo(Long id){
        todoRepository.deleteById(id);
    }

    public void deleteAllTodo(){

        todoRepository.deleteAll();
    }

    public TodoApp findVerifiedTodo(long id){
        Optional<TodoApp> optionalTodo = todoRepository.findById(id);
        TodoApp findTodo = optionalTodo.orElseThrow(() -> new RuntimeException());
        return findTodo;
    }
}
