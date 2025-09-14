package com.flowershop.model.flower;
/*
* abstract class Flower, basic for decorative and field flowers
* */

public abstract class Flower {
    private String name;
    private double price;
    private int stemLength;
    private int freshnessLevel; //1-dead, 10-fresh

    public Flower(String name, double price, int stemLength, int freshnessLevel) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        if (stemLength <= 0) {
            throw new IllegalArgumentException("Stem length should be positive");
        }
        if (freshnessLevel < 1 || freshnessLevel > 10) {
            throw new IllegalArgumentException("Freshness level should be between 1 and 10");
        }

        this.name = name;
        this.price = price;
        this.stemLength = stemLength;
        this.freshnessLevel = freshnessLevel;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStemLength() {
        return stemLength;
    }

    public int getFreshnessLevel() {
        return freshnessLevel;
    }

    public abstract String getFlowerType();

    @Override
    public String toString() {
        return String.format("%s [price=%.2f, length=%d см, freshness=%d]",
                name, price, stemLength, freshnessLevel);
    }
}
