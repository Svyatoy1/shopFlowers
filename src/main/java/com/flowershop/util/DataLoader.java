package com.flowershop.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// utilite class for downloading data from resource files

public class DataLoader {
    public static List<String> loadLines(String fileName) {
        List<String> lines = new ArrayList<>();

        try (InputStream is = DataLoader.class.getClassLoader().getResourceAsStream(fileName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {

            String line;
            while ((line = reader.readLine()) != null){
                lines.add(line.trim());
            }
        } catch (Exception e) {
            throw new RuntimeException("The file could not be downloaded: " + fileName, e);
        }

        return lines;
    }
}
