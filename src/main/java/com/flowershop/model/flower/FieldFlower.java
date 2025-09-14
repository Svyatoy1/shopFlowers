package com.flowershop.model.flower;

/*
field type from class Flower (sunflower, lavender etc.)
additional info: flowering season
 */

public class FieldFlower extends Flower {
    private String bloomingSeason; // like 'Spring' or 'Summer'

    public FieldFlower (String name, double price, int stemLength, int freshnessLevel, String bloomingSeason) {
        super(name, price, stemLength, freshnessLevel);
        this.bloomingSeason = bloomingSeason;
    }

    public String getBloomingSeason() {
        return bloomingSeason;
    }

    // override for correct console output

    @Override
    public String getFlowerType(){
        return "FieldFlower (season: " + bloomingSeason + ")";
    }
}
