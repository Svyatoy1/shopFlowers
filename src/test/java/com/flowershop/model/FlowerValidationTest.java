package com.flowershop.model;

import com.flowershop.model.flower.Flower;
import com.flowershop.model.flower.DecorativeFlower;
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
}
