package com.mubeenkhan.soccerzone;

public class item {
    int id;
    String name;
    String brand;
    String type;
    int itemsRemaining;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
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

    public int getItemsRemaining() {
        return itemsRemaining;
    }

    public void setItemsRemaining(int itemsRemaining) {
        this.itemsRemaining = itemsRemaining;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(float originalPrice) {
        this.originalPrice = originalPrice;
    }

    public float getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(float discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    String description;
    float originalPrice;
    float discountedPrice;
    String releaseDate;


    public item(int id, String name, String brand, String type,int itemsRemaining,String description,float originalPrice,float discountedPrice,String releaseDate ) {
        this.id=id;
        this.name=name;
        this.brand=brand;
        this.type=type;
        this.itemsRemaining=itemsRemaining;
        this.originalPrice=originalPrice;
        this.discountedPrice=discountedPrice;
        this.releaseDate=releaseDate;
    }

    public item() {

    }
}
