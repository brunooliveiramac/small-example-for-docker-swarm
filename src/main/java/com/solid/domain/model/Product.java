package com.solid.domain.model;

public class Product {


    private String name;
    private double value;

    public Product(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public String name() {
        return name;
    }

    public double value() {
        return value;
    }
}
