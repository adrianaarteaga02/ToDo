package ch.zli.m223.todo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;

@Entity
public class Entry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(nullable = false)
    private ToDoList toDoList;

    // Setter
    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setToDoList(ToDoList toDoLists) {
        this.toDoList = toDoLists;
    }

    // Getter
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ToDoList getToDoList() {
        return toDoList;
    }

}
