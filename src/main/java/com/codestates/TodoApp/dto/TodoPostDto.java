package com.codestates.TodoApp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter

public class TodoPostDto {
    private Long id;
    private String title;
    private Long order;
    private Boolean completed;
}
