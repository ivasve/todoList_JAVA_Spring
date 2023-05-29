package com.unicorn.todoList;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ToDoListService {

    @Autowired
    private TodoListRepository todoListRepository;

    public TodoListEntity updateTodoList(Long id, TodoListEntity todo){
        TodoListEntity findExistingTodo = todoListRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Todo not found"));
//        findExistingTodo.setDate((todo.getDate()));

        if (todo.getText() != null || !todo.getText().isEmpty()) {
            findExistingTodo.setText(todo.getText());
        }
        if (todo.getDate() != null) {
            findExistingTodo.setDate(todo.getDate());
        }

        todoListRepository.save(findExistingTodo);
        return todoListRepository.save(findExistingTodo);
    }

    public TodoListEntity createTodoList(TodoListEntity todo) {
        return todoListRepository.save(todo);
    }

    public Iterable<TodoListEntity> returnAllTodoList(){
        return todoListRepository.findAll();
    }

    public void deleteTodoList(Long id){
        TodoListEntity todo = todoListRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Todo not found"));
        todoListRepository.delete(todo);
    }

    public TodoListEntity returnTodoById(Long id) {
        TodoListEntity todo = todoListRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Todo not found"));
        return todo;
    }
}