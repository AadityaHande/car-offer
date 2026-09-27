package com.example.phoneservice.entity;

public class Phone {

    private long phoneId;
    private String model;
    private String companyName;
    private String colour;
    private double price;
    private int launchedYear;

    
    public Phone() {
    }

    public Phone(long phoneId, String model, String companyName, String colour, double price, int launchedYear) {
        this.phoneId = phoneId;
        this.model = model;
        this.companyName = companyName;
        this.colour = colour;
        this.price = price;
        this.launchedYear = launchedYear;
    }

    public long getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(long phoneId) {
        this.phoneId = phoneId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getLaunchedYear() {
        return launchedYear;
    }

    public void setLaunchedYear(int launchedYear) {
        this.launchedYear = launchedYear;
    }
}
