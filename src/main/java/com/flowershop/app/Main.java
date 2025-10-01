package com.flowershop.app;

import com.flowershop.model.Bouquet;
import com.flowershop.model.Accessory;
import com.flowershop.model.flower.FieldFlower;
import com.flowershop.model.flower.DecorativeFlower;
import com.flowershop.service.BouquetService;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Bouquet bouquet = new Bouquet();

        bouquet.addFlower(new DecorativeFlower("Rose", 80, 40, LocalDate.now().minusDays(1), 7));
        bouquet.addFlower(new FieldFlower("Chamomile", 20, 25, LocalDate.now().minusDays(2), 5, "Summer"));
        bouquet.addFlower(new DecorativeFlower("Tulip", 50, 30, LocalDate.now(), 4));

        bouquet.addAccessory(new Accessory("Ribbon", 15));
        bouquet.addAccessory(new Accessory("Wrapping paper", 25));

        BouquetService service = new BouquetService();

        // 1. total price
        double totalPrice = service.getTotalPrice(bouquet);
        System.out.println("Total price is " + totalPrice);

        // 2. sorting by shelf life
        System.out.println("\nFlowers after sorting by remaining shelf life:");
        service.sortFlowersByFreshness(bouquet).forEach(f ->
                System.out.println(f.getName() + " remaining days: " + f.getRemainingShelfLife())
        );

        // 3. find by stem length
        System.out.println("\nFlowers with stem length 20 to 35 cm:");
        service.findFlowersByStemLength(bouquet, 20, 35).forEach(f ->
                System.out.println(f.getName() + " stem length: " + f.getStemLength() + " cm")
        );
    }
}