package com.flowershop.service;

import com.flowershop.model.Bouquet;
import com.flowershop.model.Accessory;
import com.flowershop.model.flower.FieldFlower;
import com.flowershop.model.flower.DecorativeFlower;
import com.flowershop.model.flower.Flower;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BouquetServiceTest {
    @Test
    void testGetDoublePrice() {
        // квітка зірвана 2 дні тому, термін придатності 7 днів
        Flower rose = new DecorativeFlower("Rose Douson", 50.0, 40,
                LocalDate.now().minusDays(2), 7);

        // квітка зірвана 1 день тому, термін придатності 5 днів
        Flower chamomile = new FieldFlower("Chamomile", 20.0, 25,
                LocalDate.now().minusDays(1), 5, "Summer");

        // аксесуар
        Accessory ribbon = new Accessory("Red ribbon", 10.0);

        // створюємо букет
        Bouquet bouquet = new Bouquet(
                Arrays.asList(rose, chamomile),
                Arrays.asList(ribbon)
        );

        // тестуємо сервіс
        BouquetService service = new BouquetService();

        double expected = 50.0 + 20.0 + 10.0;
        double actual = service.getTotalPrice(bouquet);

        assertEquals(expected, actual, 0.001); // delta для double
    }
}