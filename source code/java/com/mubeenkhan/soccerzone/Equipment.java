package com.mubeenkhan.soccerzone;

public class Equipment {
    String name, brand, type, availability, cost,description;
    int image;

    public Equipment(String name,String description, String brand, String type, String availability, String cost,int image) {
        this.name = name;
        this.description=description;
        this.brand = brand;
        this.type = type;
        this.availability = availability;
        this.cost = cost;
        this.image=image;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}