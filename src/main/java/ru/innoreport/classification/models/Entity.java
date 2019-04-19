package ru.innoreport.classification.models;

public class Entity {
    private String name;
    private String category;
    private String address;
    private String[] tags;

    public Entity(String name, String category, String address, String[] tags) {
        this.name = name;
        this.category = category;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
