package com.example.store;

import java.io.Serializable;

public class service implements Serializable {
    private String title;
    private String description;
    private double price;
    private int numbers;
    private int ImageId;

    public service(String title) {
        this.title = title;
    }

    public service(String title, String description, double price) {
        this.title = title;
        this.description = description;
        this.price = price;
    }

    public int getImageId() {
        return ImageId;
    }

    public void setImageId(int imageId) {
        ImageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public service(String title, double price, int imageId,String description) {
        this.title = title;
        this.ImageId=imageId;
        this.description = description;
        this.price = price;
    }
    public service(String title, double price, int imageId) {
        this.title = title;
        this.ImageId=imageId;
        this.price = price;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumbers() {
        return numbers;
    }

    public void setNumbers(int numbers) {
        this.numbers = numbers;
    }
}
