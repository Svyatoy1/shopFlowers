package com.flowershop.model.flower;
/*
abstract class Flower, basic for decorative and field flowers
*/
import java.time.LocalDate;

public abstract class Flower {
    private String name;
    private double price;
    private int stemLength;

    private LocalDate harvestDate;
    private int shelfLifeDays;

    public Flower(String name, double price, int stemLength, LocalDate harvestDate, int shelfLifeDays) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        if (stemLength <= 0) {
            throw new IllegalArgumentException("Stem length should be positive");
        }

        this.name = name;
        this.price = price;
        this.stemLength = stemLength;
        this.harvestDate = harvestDate;
        this.shelfLifeDays = shelfLifeDays;
    }

    public boolean isFresh() {
        LocalDate expiryDate = harvestDate.plusDays(shelfLifeDays);
        return LocalDate.now().isBefore(expiryDate);
    }

    public long daysLeft () {
        LocalDate expiryDate = harvestDate.plusDays(shelfLifeDays);
        return java.time.temporal.ChronoUnit.DAYS.between(LocalDate.now(), expiryDate);
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

    public LocalDate getHarvestDate() {
        return harvestDate;
    }

    public int getShelfLifeDays() {
        return shelfLifeDays;
    }

    public abstract String getFlowerType();

    @Override
    public String toString() {
        return String.format("%s [price=%.2f, length=%d cm, harvestDate=%s, shelfLifeDays=%d]",
                name, price, stemLength, harvestDate, shelfLifeDays);
    }
}
