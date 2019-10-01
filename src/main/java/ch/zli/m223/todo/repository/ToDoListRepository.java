package ch.zli.m223.todo.repository;

import ch.zli.m223.todo.domain.Entry;
import ch.zli.m223.todo.domain.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoListRepository extends JpaRepository<ToDoList, Long> {
}
