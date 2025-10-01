package com.flowershop.model;

import com.flowershop.model.flower.Flower;
import com.flowershop.model.flower.DecorativeFlower;
import com.flowershop.model.flower.FieldFlower;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class FlowerValidationTest {

    @Test
    void testCreateDecorativeFlower() {
        Flower rose = new DecorativeFlower(
                "Rose",
                50.0,
                45,
                LocalDate.of(2023, 12, 20),
                10
        );

        assertEquals("Rose", rose.getName());
        assertEquals(50.0, rose.getPrice());
        assertEquals(45, rose.getStemLength());
        assertEquals(LocalDate.of(2023, 12, 20), rose.getHarvestDate());
        assertEquals(10, rose.getShelfLifeDays());
    }

    @Test
    void testCreateFieldFlower() {
        Flower chamomile = new FieldFlower(
                "Chamomile",
                20.0,
                25,
                LocalDate.of(2023, 12, 25),
                7,
                "Summer"
        );

        assertEquals("Chamomile", chamomile.getName());
        assertEquals(20.0, chamomile.getPrice());
        assertEquals(25, chamomile.getStemLength());
        assertEquals(LocalDate.of(2023, 12, 25), chamomile.getHarvestDate());
        assertEquals(7, chamomile.getShelfLifeDays());
        assertEquals("Summer", ((FieldFlower) chamomile).getBloomingSeason());
    }

    @Test
    void testIsFreshTrue() {
        Flower tulip = new FieldFlower(
                "Tulip",
                15.0,
                30,
                LocalDate.now().minusDays(2),
                5,
                "Spring"
        );

        assertTrue(tulip.isFresh());
    }

    @Test
    void testIsFreshFalse() {
        Flower tulip = new FieldFlower(
                "Tulip",
                15.0,
                30,
                LocalDate.now().minusDays(10),
                5,
                "Spring"
        );

        assertFalse(tulip.isFresh());
    }
}