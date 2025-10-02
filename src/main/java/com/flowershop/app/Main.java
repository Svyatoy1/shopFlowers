package com.flowershop.app;

import com.flowershop.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            System.out.println("Connected to PostgreSQL!");

            Statement stmt = conn.createStatement();

            // ---- Виводимо квіти ----
            System.out.println("\nFlowers:");
            ResultSet rsFlowers = stmt.executeQuery("SELECT id, name, price, stem_length, harvest_date, shelf_life_days FROM flowers");
            while (rsFlowers.next()) {
                System.out.println(
                        rsFlowers.getInt("id") + ". " +
                                rsFlowers.getString("name") +
                                " | price: " + rsFlowers.getDouble("price") +
                                " | stem length: " + rsFlowers.getInt("stem_length") +
                                " cm | harvested: " + rsFlowers.getDate("harvest_date") +
                                " | shelf life: " + rsFlowers.getInt("shelf_life_days") + " days"
                );
            }

            // ---- Виводимо аксесуари ----
            System.out.println("\nAccessories:");
            ResultSet rsAcc = stmt.executeQuery("SELECT id, name, price FROM accessories");
            while (rsAcc.next()) {
                System.out.println(
                        rsAcc.getInt("id") + ". " +
                                rsAcc.getString("name") +
                                " | price: " + rsAcc.getDouble("price")
                );
            }

            // ---- Виводимо букети ----
            System.out.println("\nBouquets:");
            ResultSet rsBouquets = stmt.executeQuery("SELECT id, name FROM bouquets");
            while (rsBouquets.next()) {
                System.out.println(
                        rsBouquets.getInt("id") + ". " +
                                rsBouquets.getString("name")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}