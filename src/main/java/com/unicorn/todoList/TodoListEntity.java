package com.unicorn.todoList;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "todolist")
public class TodoListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @JsonProperty("text")
    @Column(name = "text")
    private String text;

    @JsonProperty("date")
    @Column(name = "date")
    private Date date;

    public TodoListEntity(Long id, String text, Date date) {
        this.id = id;
        this.text = text;
        this.date = date;
    }

    public TodoListEntity(Long id, String text) {
        this.id = id;
        this.text = text;
    }
    public TodoListEntity() {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    // constructors, getters and setters
}
