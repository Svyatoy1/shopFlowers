package com.flowershop.util;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataLoaderTest {

    @Test
    void testLoadLinesFromFile() {
        List<String> lines = DataLoader.loadLines("flowers.txt");

        assertFalse(lines.isEmpty()); // перевіряємо, що файл не пустий
        assertEquals("Rose;50.0;40;2023-12-20;10", lines.get(0)); // перший рядок = декоративна квітка
        assertEquals("Chamomile;20.0;25;2023-12-25;7;Summer", lines.get(1)); // другий рядок = польова квітка
    }
}