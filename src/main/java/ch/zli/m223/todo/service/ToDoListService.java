package ch.zli.m223.todo.service;

import ch.zli.m223.todo.domain.ToDoList;
import ch.zli.m223.todo.repository.ToDoListRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoListService {
    private ToDoListRepository toDoListRepository;

    public ToDoListService(ToDoListRepository toDoListRepository) {
        this.toDoListRepository = toDoListRepository;
    }

    public List<ToDoList> findAll() {
        return toDoListRepository.findAll();
    }

    private Optional<ToDoList> findToDoListById(long id) {
        return toDoListRepository.findById(id);
    }

    public ToDoList createToDoList(ToDoList toDoList) {
        return toDoListRepository.saveAndFlush(toDoList);
    }

    public void deleteToDoListById(long id) {
        if (toDoListRepository.existsById(id)) {
            toDoListRepository.deleteById(id);
        }
    }

    public ToDoList updateToDoList(ToDoList toDoList, Long id) {
        ToDoList updatedToDoList;
        Optional<ToDoList> optionalUpdatedToDoList = findToDoListById(id);

        if (optionalUpdatedToDoList.isPresent()) {
            updatedToDoList = optionalUpdatedToDoList.get();
            updatedToDoList.setName(toDoList.getName());
            updatedToDoList.setDescription(toDoList.getDescription());
            updatedToDoList.setProject(toDoList.getProject());
        } else {
            updatedToDoList = toDoList;
            updatedToDoList.setId(id);
        }
        return toDoListRepository.saveAndFlush(updatedToDoList);
    }
}
