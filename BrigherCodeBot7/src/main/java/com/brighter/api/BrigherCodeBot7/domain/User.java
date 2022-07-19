package com.brighter.api.BrigherCodeBot7.domain;

public class User {
    long id;
    String name;
    String username;
    String location;

    public User(long id, String name, String username, String location) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.location = location;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
