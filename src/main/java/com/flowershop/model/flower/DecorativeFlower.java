package com.flowershop.model.flower;

/*
decorative type from class Flower (tulip, rose etc.)
no additional info
*/

public class DecorativeFlower extends Flower {
    public DecorativeFlower(String name, double price, int stemLength, int freshnessLevel) {
        super(name, price, stemLength, freshnessLevel);
    }

    @Override public String getFlowerType() {
        return "DecorativeFlower";
    }
}
