package konta.bai3.entity;

public class Account {
    private int id;
    private String username;
    private String password;
    private Boolean permission;
    private Boolean status;

    public Account() {
    }

    public Account(int id, String username, String password, Boolean permission, Boolean status) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.permission = permission;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getPermission() {
        return permission;
    }

    public void setPermission(Boolean permission) {
        this.permission = permission;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
