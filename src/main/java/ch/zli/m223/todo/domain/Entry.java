package ch.zli.m223.todo.domain;

public class Entry {
    private long id;
    private String name;
    private String description;
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

    public void setToDoList(ToDoList toDoList) {
        this.toDoList = toDoList;
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
