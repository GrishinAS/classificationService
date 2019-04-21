package ru.innoreport.classification.models;

public class Entity {
    private String name;
    private String email;
    private String address;
    private String[] tags;

    public Entity(String name, String email, String address, String[] tags) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.tags = tags;
    }

    public Entity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }
}
