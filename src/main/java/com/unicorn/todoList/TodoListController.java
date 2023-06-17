package com.unicorn.todoList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/todo")
public class TodoListController {

    @Autowired
    private TodoListRepository todoListRepository;
    @Autowired
    private ToDoListService toDoListService;


    @GetMapping("/list")
    public Iterable<TodoDTO> findAll() {
        return toDoListService.returnAllTodoList();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TodoDTO getById(@PathVariable Long id){
        return toDoListService.returnTodoById(id);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public TodoDTO create(@Valid @RequestBody TodoDTO todoDTO) {
        return toDoListService.createTodoList(todoDTO);
    }

    @PutMapping("/{id}/update")
    @ResponseStatus(HttpStatus.OK)
    public TodoDTO update(@PathVariable Long id, @Valid @RequestBody TodoDTO todoDTO) {
        return toDoListService.updateTodoList(id, todoDTO);
    }

    @DeleteMapping("/{id}/delete")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        toDoListService.deleteTodoList(id);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        return ex.getBindingResult()
                .getAllErrors().stream()
                .map(objectError -> objectError.getDefaultMessage())
                .collect(Collectors.toList());
    }

}

