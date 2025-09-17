package com.flowershop.model;

/*
accessory for flowers (paper, ribbon etc.)
 */

public class Accessory {
    private String name;
    private double price;

    public Accessory(String name, double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Price: %.2f", name, price);
    }
}
