package com.codestates.TodoApp.mapper;

import com.codestates.TodoApp.dto.TodoPatchDto;
import com.codestates.TodoApp.dto.TodoPostDto;
import com.codestates.TodoApp.dto.TodoResponseDto;
import com.codestates.TodoApp.entity.TodoApp;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface TodoMapper {
    public TodoApp TodoPostDtoToTodoApp(TodoPostDto todoPostDto);
    public TodoApp TodoPatchDtoToTodoApp(TodoPatchDto todoPatchDto);
    public TodoResponseDto TodoAppToTodoResponseDto(TodoApp todoApp);

}
