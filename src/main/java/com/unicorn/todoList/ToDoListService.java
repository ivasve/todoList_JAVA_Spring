package com.unicorn.todoList;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.stream.Collectors;

@Configuration
public class ToDoListService {

    @Autowired
    private TodoListRepository todoListRepository;


    public TodoDTO updateTodoList(Long id, TodoDTO todoDTO) {
        TodoListEntity entity = todoListRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Todo not found"));
        if (todoDTO.getText() != null || !todoDTO.getText().isEmpty()) {
           entity.setText(todoDTO.getText());
        }
        if (todoDTO.getDate() != null) {
            entity.setDate(todoDTO.getDate());
        }
        TodoListEntity updatedEntity = todoListRepository.save(entity);
        return TodoDTO.fromEntity(updatedEntity);
    }


    public TodoDTO createTodoList(TodoDTO todoDTO) {
        TodoListEntity entity = todoDTO.toEntity();
        entity = todoListRepository.save(entity);
        return TodoDTO.fromEntity(entity);
    }

    public Iterable<TodoDTO> returnAllTodoList(){
        return todoListRepository.findAll().stream().map(TodoDTO::fromEntity).collect(Collectors.toList());
    }

    public void deleteTodoList(Long id){
        TodoListEntity todo = todoListRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Todo not found"));
        todoListRepository.delete(todo);
    }

    public TodoDTO returnTodoById(Long id) {
        TodoListEntity todo = todoListRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Todo not found"));
        return TodoDTO.fromEntity(todo);
    }
}
