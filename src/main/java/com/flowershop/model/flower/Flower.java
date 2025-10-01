package com.flowershop.model.flower;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Flower {
    private String name;
    private double price;
    private int stemLength;
    private LocalDate harvestDate;   // дата зривання
    private int shelfLifeDays;       // термін придатності (в днях)

    public Flower(String name, double price, int stemLength, LocalDate harvestDate, int shelfLifeDays) {
        this.name = name;
        this.price = price;
        this.stemLength = stemLength;
        this.harvestDate = harvestDate;
        this.shelfLifeDays = shelfLifeDays;
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

    // залишок терміну придатності
    public long getRemainingShelfLife() {
        long daysPassed = ChronoUnit.DAYS.between(harvestDate, LocalDate.now());
        return shelfLifeDays - daysPassed;
    }

    public abstract String getFlowerType();
}