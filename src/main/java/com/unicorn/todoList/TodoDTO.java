package com.unicorn.todoList;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.unicorn.todoList.validation.DateInFuture;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class TodoDTO {

    @JsonProperty("id")
    @NotNull(message = "ID cannot be null")
    private Long id;

    @JsonProperty("text")
    @NotBlank(message = "Text cannot be blank")
    @Size(max = 100, message = "Text cannot be longer than 100 characters")
    private String text;

    @JsonProperty("date")
    @DateInFuture
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate date;

    // getters and setters...

    public TodoListEntity toEntity() {
        TodoListEntity entity = new TodoListEntity();
        entity.setId(this.id);
        entity.setText(this.text);
        entity.setDate(this.date);
        return entity;
    }

    public static TodoDTO fromEntity(TodoListEntity todoListEntity){
        TodoDTO fromEntity = new TodoDTO();
        fromEntity.setId(todoListEntity.getId());
        fromEntity.setText(todoListEntity.getText());
        fromEntity.setDate(todoListEntity.getDate());
        return fromEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
