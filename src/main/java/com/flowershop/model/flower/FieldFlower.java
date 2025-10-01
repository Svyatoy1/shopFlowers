package com.flowershop.model.flower;

import java.time.LocalDate;

public class FieldFlower extends Flower {
    private String bloomingSeason; // додаткове поле

    public FieldFlower(String name, double price, int stemLength,
                       LocalDate harvestDate, int shelfLifeDays, String bloomingSeason) {
        super(name, price, stemLength, harvestDate, shelfLifeDays);
        this.bloomingSeason = bloomingSeason;
    }

    public String getBloomingSeason() {
        return bloomingSeason;
    }

    @Override
    public String getFlowerType() {
        return "FieldFlower (season: " + bloomingSeason + ")";
    }
}