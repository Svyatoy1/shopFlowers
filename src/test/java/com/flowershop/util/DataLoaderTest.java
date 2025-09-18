package com.flowershop.util;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataLoaderTest {

    @Test
    void testLoadLinesFromFile () {
        List<String> lines = DataLoader.loadLines("flowers.txt");

        assertFalse(lines.isEmpty());
        assertEquals("Rose;50.0;40;5", lines.get(0));
    }
}
