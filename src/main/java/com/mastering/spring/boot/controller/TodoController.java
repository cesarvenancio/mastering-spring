package com.mastering.spring.boot.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mastering.spring.boot.entity.Todo;
import com.mastering.spring.boot.service.TodoService;

@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;
    
    @GetMapping("/todos")
    public List<Todo> retrieveAllTodos() {
        return todoService.retrieveTodos();
    }

    @GetMapping("/users/{name}/todos")
    public List<Todo> retrieveTodos(@PathVariable String name) {
        return todoService.retrieveTodos(name);
    }

    @GetMapping(path = "/todos/{id}")
    public ResponseEntity<?> retrieveTodo(@PathVariable int id) {
        Todo todo = todoService.retrieveTodo(id);
        return todo != null ? new ResponseEntity(todo, HttpStatus.OK)
                : ResponseEntity.noContent().build();
    }

    @PostMapping("/users/todos")
    ResponseEntity<?> add(@RequestBody Todo todo) {
        Todo createdTodo = todoService.addTodo(todo.getUser(), todo.getDesc(), todo.getTargetDate(), todo.isDone());
        if (createdTodo == null) {
            return ResponseEntity.noContent().build();
        }
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(createdTodo.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
    
    @DeleteMapping("/todos/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable int id){
        Todo todo = todoService.deleteTodo(id);
        return todo != null ? new ResponseEntity(todo, HttpStatus.OK)
                : ResponseEntity.noContent().build();
    }
}
