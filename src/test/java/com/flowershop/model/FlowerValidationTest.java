package com.flowershop.model;

import com.flowershop.model.flower.DecorativeFlower;
import com.flowershop.model.flower.FieldFlower;
import com.flowershop.model.flower.Flower;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FlowerValidationTest {

    @Test
    void testCreateDecorativeFlower() {
        Flower rose = new DecorativeFlower(
                "Rose",
                50.0,
                45,
                LocalDate.of(2023, 12, 20), // дата зривання
                10 // термін придатності у днях
        );

        assertEquals("Rose", rose.getName());
        assertEquals(50.0, rose.getPrice());
        assertEquals(45, rose.getStemLength());

        // тут замість геттера напряму перевіряємо через toString()
        assertEquals("DecorativeFlower", rose.getFlowerType());
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

        // знову ж, перевірка типу
        assertEquals("FieldFlower (season: Summer)", chamomile.getFlowerType());
    }
}