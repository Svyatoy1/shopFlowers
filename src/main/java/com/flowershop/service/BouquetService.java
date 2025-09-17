package com.flowershop.service;

/*
service for working with bouquets:
- cost calculation
- sorting by freshness level
- find flower by stem length
 */

import com.flowershop.model.Accessory;
import com.flowershop.model.Bouquet;
import com.flowershop.model.flower.Flower;

import java.util.Comparator; // interface for comparing objects
import java.util.List; // interface for saving lists
import java.util.stream.Collectors; // for saving results in collection

public class BouquetService {
    public double getPrice(Bouquet bouquet) {
        double total = 0.0;

        for (Flower flower : bouquet.getFlowers()) {
            total += flower.getPrice();
        }

        for (Accessory accessory : bouquet.getAccessories()) {
            total += accessory.getPrice();
        }

        return total;
    }

    public List<Flower> sortFlowersByFreshness(Bouquet bouquet) {
        // to do
        return List.of(); // temporary
    }

    public List<Flower> findFlowersByStemLength(Bouquet bouquet) {
        // to do
        return List.of();
    }

}
