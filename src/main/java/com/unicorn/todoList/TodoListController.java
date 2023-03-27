package com.unicorn.todoList;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/todo")
public class TodoListController {

    @Autowired
    private TodoListRepository todoListRepository;
    @Autowired
    private ToDoListService toDoListService;

    @GetMapping("/list")
    public Iterable<TodoListEntity> findAll() {
        return toDoListService.returnAllTodoList();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public TodoListEntity create(@RequestBody TodoListEntity todo) {
        return toDoListService.createTodoList(todo);

    }

    @PutMapping("/{id}/update")
    @ResponseStatus(HttpStatus.OK)
    public TodoListEntity update(@PathVariable Long id, @RequestBody TodoListEntity todo) {
        toDoListService.updateTodoList(id, todo);
        return toDoListService.updateTodoList(id, todo);
    }

    @DeleteMapping("/{id}/delete")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        toDoListService.deleteTodoList(id);
    }

}

