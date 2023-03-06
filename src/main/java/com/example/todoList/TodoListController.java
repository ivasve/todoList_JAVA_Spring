package com.example.todoList;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
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

    @GetMapping("/list")
    public Iterable<TodoListEntity> findAll() {
        return todoListRepository.findAll();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public TodoListEntity create(@RequestBody TodoListEntity todo) {
        return todoListRepository.save(todo);

    }

    @PutMapping("/{id}/update")
    @ResponseStatus(HttpStatus.OK)
    public TodoListEntity update(@PathVariable Long id, @RequestBody TodoListEntity todo) {
        TodoListEntity existingTodo = todoListRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Todo not found"));
        existingTodo.setText(todo.getText());
//        existingTodo.setCompleted(todo.isCompleted());
        return todoListRepository.save(existingTodo);
    }

    @DeleteMapping("/{id}/delete")
    public void delete(@PathVariable Long id) {
        TodoListEntity todo = todoListRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Todo not found"));
        todoListRepository.delete(todo);
    }
}

