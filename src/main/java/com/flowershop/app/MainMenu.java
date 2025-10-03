package com.flowershop.app;

import com.flowershop.util.DatabaseConnection;

import java.sql.*;
import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            System.out.println("Connected to PostgreSQL");

            Scanner scanner = new Scanner(System.in);
            boolean running = true;

            while (running) {
                System.out.println("\nFLOWER SHOP MENU");
                System.out.println("1. Show all flowers");
                System.out.println("2. Show all accessories");
                System.out.println("3. Show all bouquets");
                System.out.println("4. Show full bouquet composition");
                System.out.println("5. Create new bouquet (with flowers and accessories)");
                System.out.println("0. Exit");
                System.out.print("Choose option: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // clean buffer

                Statement stmt = conn.createStatement();

                switch (choice) {
                    case 1 -> {
                        System.out.println("\nFlowers:");
                        ResultSet rsFlowers = stmt.executeQuery(
                                "SELECT id, name, price, stem_length, harvest_date, shelf_life_days FROM flowers"
                        );
                        while (rsFlowers.next()) {
                            System.out.println(rsFlowers.getInt("id") + ". " +
                                    rsFlowers.getString("name") +
                                    " | price: " + rsFlowers.getDouble("price") +
                                    " | stem length: " + rsFlowers.getInt("stem_length") +
                                    " cm | harvested: " + rsFlowers.getDate("harvest_date") +
                                    " | shelf life: " + rsFlowers.getInt("shelf_life_days") + " days");
                        }
                    }
                    case 2 -> {
                        System.out.println("\nAccessories:");
                        ResultSet rsAcc = stmt.executeQuery("SELECT id, name, price FROM accessories");
                        while (rsAcc.next()) {
                            System.out.println(rsAcc.getInt("id") + ". " +
                                    rsAcc.getString("name") +
                                    " | price: " + rsAcc.getDouble("price"));
                        }
                    }
                    case 3 -> {
                        System.out.println("\nBouquets:");
                        ResultSet rsBouquets = stmt.executeQuery("SELECT id, name FROM bouquets");
                        while (rsBouquets.next()) {
                            System.out.println(rsBouquets.getInt("id") + ". " +
                                    rsBouquets.getString("name"));
                        }
                    }
                    case 4 -> {
                        System.out.println("\nBouquets full composition:");
                        String sql = """
                                SELECT b.id, b.name AS bouquet, f.name AS flower, a.name AS accessory
                                FROM bouquets b
                                LEFT JOIN bouquet_flowers bf ON b.id = bf.bouquet_id
                                LEFT JOIN flowers f ON bf.flower_id = f.id
                                LEFT JOIN bouquet_accessories ba ON b.id = ba.bouquet_id
                                LEFT JOIN accessories a ON ba.accessory_id = a.id
                                ORDER BY b.id;
                                """;
                        ResultSet rsJoin = stmt.executeQuery(sql);
                        while (rsJoin.next()) {
                            String bouquet = rsJoin.getString("bouquet");
                            String flower = rsJoin.getString("flower");
                            String accessory = rsJoin.getString("accessory");

                            System.out.println("Bouquet: " + bouquet +
                                    " | Flower: " + (flower != null ? flower : "-") +
                                    " | Accessory: " + (accessory != null ? accessory : "-"));
                        }
                    }
                    case 5 -> {
                        System.out.print("Enter new bouquet name: ");
                        String bouquetName = scanner.nextLine();

                        // вставляємо букет
                        String insertBouquet = "INSERT INTO bouquets (name) VALUES (?) RETURNING id";
                        int bouquetId;
                        try (PreparedStatement pstmt = conn.prepareStatement(insertBouquet)) {
                            pstmt.setString(1, bouquetName);
                            ResultSet rs = pstmt.executeQuery();
                            rs.next();
                            bouquetId = rs.getInt("id");
                        }
                        System.out.println("Bouquet \"" + bouquetName + "\" created with ID: " + bouquetId);

                        // додаємо квіти
                        System.out.println("\nAvailable flowers:");
                        ResultSet rsFlowers = stmt.executeQuery("SELECT id, name FROM flowers");
                        while (rsFlowers.next()) {
                            System.out.println(rsFlowers.getInt("id") + ". " + rsFlowers.getString("name"));
                        }

                        System.out.println("Add flowers by ID (enter 0 to stop):");
                        while (true) {
                            int flowerId = scanner.nextInt();
                            if (flowerId == 0) break;
                            String insertFlower = "INSERT INTO bouquet_flowers (bouquet_id, flower_id) VALUES (?, ?)";
                            try (PreparedStatement pstmt = conn.prepareStatement(insertFlower)) {
                                pstmt.setInt(1, bouquetId);
                                pstmt.setInt(2, flowerId);
                                pstmt.executeUpdate();
                            }
                            System.out.println("Flower with ID " + flowerId + " added.");
                        }

                        // додаємо аксесуари
                        System.out.println("\nAvailable accessories:");
                        ResultSet rsAcc = stmt.executeQuery("SELECT id, name FROM accessories");
                        while (rsAcc.next()) {
                            System.out.println(rsAcc.getInt("id") + ". " + rsAcc.getString("name"));
                        }

                        System.out.println("Add accessories by ID (enter 0 to stop):");
                        while (true) {
                            int accId = scanner.nextInt();
                            if (accId == 0) break;
                            String insertAcc = "INSERT INTO bouquet_accessories (bouquet_id, accessory_id) VALUES (?, ?)";
                            try (PreparedStatement pstmt = conn.prepareStatement(insertAcc)) {
                                pstmt.setInt(1, bouquetId);
                                pstmt.setInt(2, accId);
                                pstmt.executeUpdate();
                            }
                            System.out.println("Accessory with ID " + accId + " added.");
                        }

                        scanner.nextLine(); // чистимо буфер
                        System.out.println("Bouquet completed!");
                    }
                    case 0 -> {
                        running = false;
                        System.out.println("Exiting Flower Shop...");
                    }
                    default -> System.out.println("Invalid option, try again.");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}