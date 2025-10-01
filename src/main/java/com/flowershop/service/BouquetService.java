package com.flowershop.service;

/*
service for working with bouquets:
- cost calculation
- sorting by freshness (days left)
- find flower by stem length
 */

import com.flowershop.model.Accessory;
import com.flowershop.model.Bouquet;
import com.flowershop.model.flower.Flower;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
        List<Flower> sortedFlowers = new ArrayList<>(bouquet.getFlowers());

        Collections.sort(sortedFlowers, new Comparator<Flower>() {
            @Override
            public int compare(Flower o1, Flower o2) {
                // більш свіжа квітка = більше днів до закінчення терміну придатності
                return Long.compare(o2.getRemainingShelfLife(), o1.getRemainingShelfLife());
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