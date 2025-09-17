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
import java.util.ArrayList;
import java.util.Collections; // we use cycles for creating methods, without streams

public class BouquetService {
    public double getTotalPrice(Bouquet bouquet) {
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
        List<Flower> sortedFlowers = new ArrayList<>(bouquet.getFlowers()); // creating copy of flower list

        Collections.sort(sortedFlowers, new Comparator<Flower>() {
            @Override
            public int compare(Flower o1, Flower o2) {
                return Integer.compare(o1.getFreshnessLevel(), o2.getFreshnessLevel());
            }
        });
        return sortedFlowers;
    }

    public List<Flower> findFlowersByStemLength(Bouquet bouquet, int min, int max) {
        List<Flower> result = new ArrayList<>();

        for (Flower flower : bouquet.getFlowers()) {
            int length = flower.getStemLength();
            if (length >= min && length <= max) {
                result.add(flower);
            }
        }
        return result;
    }

}
