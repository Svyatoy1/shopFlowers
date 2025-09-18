package com.flowershop.service;

import com.flowershop.model.Bouquet;
import com.flowershop.model.Accessory;
import com.flowershop.model.flower.FieldFlower;
import com.flowershop.model.flower.DecorativeFlower;
import com.flowershop.model.flower.Flower;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BouquetServiceTest {
    @Test
    void testGetDoublePrice() {
        Flower rose = new DecorativeFlower("Rose Douson", 50.0, 40, 5);
        Flower chamomile = new FieldFlower("Chamomile", 20.0, 25, 7, "Summer");

        Accessory ribbon = new Accessory("Red ribbon", 10.0);

        Bouquet bouquet = new Bouquet(
                Arrays.asList(rose, chamomile),
                Arrays.asList(ribbon)
        );

        BouquetService service = new BouquetService();

        double expected = 50.0 + 20.0 + 10.0;
        double actual = service.getTotalPrice(bouquet);

        assertEquals(expected, actual, 0.001); //delta for double
    }
}
