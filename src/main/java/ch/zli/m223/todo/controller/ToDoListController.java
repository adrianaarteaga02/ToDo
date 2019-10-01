package ch.zli.m223.todo.controller;

import ch.zli.m223.todo.domain.ToDoList;
import ch.zli.m223.todo.service.ToDoListService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/todolists")
public class ToDoListController {

    private ToDoListService toDoListService;

    public ToDoListController(ToDoListService toDoListService) {
        this.toDoListService = toDoListService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ToDoList> getAllToDoLists() {
        return toDoListService.findAll();
    }

    @PostMapping("new")
    @ResponseStatus(HttpStatus.CREATED)
    public ToDoList createToDoList(@Valid @RequestBody ToDoList toDoList) {
        return toDoListService.createToDoList(toDoList);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteToDoList(@PathVariable Long id) {
        toDoListService.deleteToDoListById(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public ToDoList updateToDoList(@Valid @RequestBody ToDoList toDoList, @PathVariable Long id) {
        return toDoListService.updateToDoList(toDoList, id);
    }
}
