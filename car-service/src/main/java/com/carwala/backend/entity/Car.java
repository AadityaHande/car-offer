package com.carwala.backend.entity;

public class Car {

    private long id;
    private String name;
    private String model;
    private String company;
    private double price;

    public Car() {
    }

    public Car(long id, String name, String model, String company, double price) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.company = company;
        this.price = price;
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
