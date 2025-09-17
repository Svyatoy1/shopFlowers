package com.flowershop.service;

/*
service for working with bouquets:
- cost calculation
- sorting by freshness level
- find flower by stem length
 */

import com.flowershop.model.Bouquet;
import com.flowershop.model.flower.Flower;

import java.util.Comparator; // interface for comparing objects
import java.util.List; // interface for saving lists
import java.util.stream.Collectors; // for saving results in collection

public class BouquetService {
    public double getPrice(Bouquet bouquet) {
        // to do
        return 0.0; // temporary
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
