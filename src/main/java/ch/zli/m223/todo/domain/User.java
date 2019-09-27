package ch.zli.m223.todo.domain;

public class User {
    private long id;
    private String firstname;
    private String lastname;
    private String email;
    private int permission;

    // Setter
    public void setId(long id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }

    // Getter
    public long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public int getPermission() {
        return permission;
    }
}
