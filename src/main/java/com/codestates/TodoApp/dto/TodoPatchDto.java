package com.codestates.TodoApp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoPatchDto {
    private String title;
    private Long order;
    private Boolean completed;
}
