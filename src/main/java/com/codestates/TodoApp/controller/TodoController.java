package com.codestates.TodoApp.controller;

import com.codestates.TodoApp.dto.TodoPatchDto;
import com.codestates.TodoApp.dto.TodoPostDto;
import com.codestates.TodoApp.dto.TodoResponseDto;
import com.codestates.TodoApp.entity.TodoApp;
import com.codestates.TodoApp.mapper.TodoMapper;
import com.codestates.TodoApp.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping
@CrossOrigin
public class TodoController {
    private final TodoMapper mapper;
    private final TodoService todoService;

    public TodoController(TodoService todoService,
                          TodoMapper mapper){
        this.todoService = todoService;
        this.mapper = mapper;
    }

    @PostMapping("/")
    public ResponseEntity postTodo(@RequestBody TodoPostDto todoPostDto){
        System.out.println("CREATE");
        TodoApp result = todoService.createTodo(mapper.TodoPostDtoToTodoApp(todoPostDto));
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @PatchMapping("{id}")
    public ResponseEntity patchTodo(@RequestBody TodoPatchDto todoPatchDto,
                                    @PathVariable Long id){
        System.out.println("UPDATE");
        TodoApp result = todoService.updateTodo(mapper.TodoPatchDtoToTodoApp(todoPatchDto));
        return new ResponseEntity(result,HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity getTodo(@PathVariable Long id){
        TodoApp result = todoService.findTodo(id);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getTodos(){
        List<TodoApp> todoApps = todoService.findAllTodo();
        List<TodoResponseDto> result = todoApps.stream()
                .map(todoApp -> mapper.TodoAppToTodoResponseDto(todoApp))
                .collect(Collectors.toList());
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteTodo(@PathVariable Long id){
        System.out.println("DELETE");

        this.todoService.deleteTodo(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity deleteAllTodo(){
        this.todoService.deleteAllTodo();
        return ResponseEntity.ok().build();
    }
}
