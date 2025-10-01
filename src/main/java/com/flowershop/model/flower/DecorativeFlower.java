package com.flowershop.model.flower;

import java.time.LocalDate;

public class DecorativeFlower extends Flower {
    public DecorativeFlower(String name, double price, int stemLength, LocalDate harvestDate, int shelfLifeDays) {
        super(name, price, stemLength, harvestDate, shelfLifeDays);
    }

    @Override
    public String getFlowerType() {
        return "DecorativeFlower";
    }
}