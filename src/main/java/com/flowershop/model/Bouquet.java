package com.flowershop.model;

import com.flowershop.model.flower.Flower;
import java.util.ArrayList;
import java.util.List;

/*
Bouquet is a mix from Flowers and Accessory
 */

public class Bouquet {
    private List<Flower> flowers;
    private List<Accessory> accessories;

    public Bouquet() {
        this.flowers = new ArrayList<>();
        this.accessories = new ArrayList<>();
    }

    public void addFlower(Flower flower) {
        flowers.add(flower);
    }

    public void addAccessory(Accessory accessory) {
        accessories.add(accessory);
    }

    public List<Flower> getFlowers() {
        return flowers;
    }

    public List<Accessory> getAccessories() {
        return accessories;
    }

    @Override
    public String toString() {
        return "Bouquet{" + "flowers=" + flowers + ", accessories=" + accessories + '}';
    }
}
