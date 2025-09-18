package com.flowershop.model;

import com.flowershop.model.flower.Flower;
import com.flowershop.model.flower.DecorativeFlower;
import com.flowershop.model.flower.FieldFlower;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlowerValidationTest {
    @Test
    void testCreateDecorativeFlower() {
        Flower rose = new DecorativeFlower("Rose", 50.0, 45,5);

        assertEquals("Rose", rose.getName());
        assertEquals(50.0, rose.getPrice());
        assertEquals(45, rose.getStemLength());
        assertEquals(5, rose.getFreshnessLevel());
    }

    @Test
    void testCreateFieldFlower() {
        Flower chamomile = new FieldFlower("Chamomile", 20.0, 25, 7, "Summer");

        assertEquals("Chamomile", chamomile.getName());
        assertEquals(20.0, chamomile.getPrice());
        assertEquals(25, chamomile.getStemLength());
        assertEquals(7, chamomile.getFreshnessLevel());
        assertEquals("Summer", ((FieldFlower) chamomile).getBloomingSeason());
    }
}
