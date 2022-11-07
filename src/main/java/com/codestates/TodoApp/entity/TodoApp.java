package com.codestates.TodoApp.entity;

import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@Entity
@NoArgsConstructor
public class TodoApp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false , name = "seq")
    private Long order;

    @Column(nullable = false)
    private Boolean completed;
}
