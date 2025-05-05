package org.openjfx;

import java.util.*;
import java.sql.*;

public class ReviewerDatabase {
    private static final String URL = "jdbc:mysql://localhost:3306/cs321";
    private static final String USER = "root";
    private static final String PASSWORD = "Nanos1960%%";

    private static Connection connection;

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void createImmigrant(int immigrantSSN, String name, String address, String email,
                                       int dob, int mob, int yob, int income, int ssn,
                                       String employmentInfo, String financialAssets,
                                       String supportingDocuments, String immigrantName) {
        String insertQuery = "INSERT INTO reviewerdatabase (ImmigrantSSN, Name, Address, Email, Dob, Mob, Yob, Income, SSN, EmploymentInfo, FinancialAssets, SupportingDocuments, ImmigrantName) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(insertQuery)) {

            stmt.setInt(1, immigrantSSN);
            stmt.setString(2, name);
            stmt.setString(3, address);
            stmt.setString(4, email);
            stmt.setInt(5, dob);
            stmt.setInt(6, mob);
            stmt.setInt(7, yob);
            stmt.setInt(8, income);
            stmt.setInt(9, ssn);
            stmt.setString(10, employmentInfo);
            stmt.setString(11, financialAssets);
            stmt.setString(12, supportingDocuments);
            stmt.setString(13, immigrantName);

            int rowsAffected = stmt.executeUpdate();
            System.out.println(rowsAffected > 0 ? "Immigrant added successfully." : "Error adding immigrant.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void selectUsers() {
        String selectQuery = "SELECT * FROM reviewerdatabase";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(selectQuery)) {

            while (rs.next()) {
                System.out.println("Immigrant SSN: " + rs.getInt("ImmigrantSSN") +
                        ", Name: " + rs.getString("Name") +
                        ", Address: " + rs.getString("Address") +
                        ", Email: " + rs.getString("Email") +
                        ", Dob: " + rs.getInt("Dob") +
                        ", Mob: " + rs.getInt("Mob") +
                        ", Yob: " + rs.getInt("Yob") +
                        ", Income: " + rs.getInt("Income") +
                        ", SSN: " + rs.getInt("SSN") +
                        ", Employment Info: " + rs.getString("EmploymentInfo") +
                        ", Financial Assets: " + rs.getString("FinancialAssets") +
                        ", Supporting Documents: " + rs.getString("SupportingDocuments") +
                        ", Immigrant Name: " + rs.getString("ImmigrantName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateUser(int immigrantSSN, String name, String address, String email,
                                  int dob, int mob, int yob, int income, int ssn,
                                  String employmentInfo, String financialAssets,
                                  String supportingDocuments, String immigrantName) {
        String updateQuery = "UPDATE reviewerdatabase SET Name = ?, Address = ?, Email = ?, Dob = ?, Mob = ?, Yob = ?, Income = ?, SSN = ?, EmploymentInfo = ?, FinancialAssets = ?, SupportingDocuments = ?, ImmigrantName = ? WHERE ImmigrantSSN = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(updateQuery)) {

            stmt.setString(1, name);
            stmt.setString(2, address);
            stmt.setString(3, email);
            stmt.setInt(4, dob);
            stmt.setInt(5, mob);
            stmt.setInt(6, yob);
            stmt.setInt(7, income);
            stmt.setInt(8, ssn);
            stmt.setString(9, employmentInfo);
            stmt.setString(10, financialAssets);
            stmt.setString(11, supportingDocuments);
            stmt.setString(12, immigrantName);
            stmt.setInt(13, immigrantSSN);

            int rowsAffected = stmt.executeUpdate();
            System.out.println(rowsAffected > 0 ? "User updated successfully." : "User not found.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String menuOption;

        System.out.println("Menu Option (Insert / Update / Display Users / Exit): ");
        menuOption = sc.nextLine();

        while (!menuOption.equalsIgnoreCase("Exit")) {
            int immigrantSSN, dob, mob, yob, income, ssn;
            String name, email, address, employmentInfo, financialAssets, supportingDocuments, immigrantName;

            switch (menuOption) {
                case "Insert":
                    System.out.println("Immigrant SSN: "); immigrantSSN = sc.nextInt(); sc.nextLine();
                    System.out.println("Name: "); name = sc.nextLine();
                    System.out.println("Email: "); email = sc.nextLine();
                    System.out.println("Address: "); address = sc.nextLine();
                    System.out.println("Dob: "); dob = sc.nextInt();
                    System.out.println("Mob: "); mob = sc.nextInt();
                    System.out.println("Yob: "); yob = sc.nextInt();
                    System.out.println("Income: "); income = sc.nextInt();
                    System.out.println("SSN: "); ssn = sc.nextInt(); sc.nextLine();
                    System.out.println("Employment Info: "); employmentInfo = sc.nextLine();
                    System.out.println("Financial Assets: "); financialAssets = sc.nextLine();
                    System.out.println("Supporting Documents: "); supportingDocuments = sc.nextLine();
                    System.out.println("Immigrant Name: "); immigrantName = sc.nextLine();

                    createImmigrant(immigrantSSN, name, address, email, dob, mob, yob, income, ssn, employmentInfo, financialAssets, supportingDocuments, immigrantName);
                    break;

                case "Update":
                    System.out.println("Immigrant SSN: "); immigrantSSN = sc.nextInt(); sc.nextLine();
                    System.out.println("Name: "); name = sc.nextLine();
                    System.out.println("Email: "); email = sc.nextLine();
                    System.out.println("Address: "); address = sc.nextLine();
                    System.out.println("Dob: "); dob = sc.nextInt();
                    System.out.println("Mob: "); mob = sc.nextInt();
                    System.out.println("Yob: "); yob = sc.nextInt();
                    System.out.println("Income: "); income = sc.nextInt();
                    System.out.println("SSN: "); ssn = sc.nextInt(); sc.nextLine();
                    System.out.println("Employment Info: "); employmentInfo = sc.nextLine();
                    System.out.println("Financial Assets: "); financialAssets = sc.nextLine();
                    System.out.println("Supporting Documents: "); supportingDocuments = sc.nextLine();
                    System.out.println("Immigrant Name: "); immigrantName = sc.nextLine();

                    updateUser(immigrantSSN, name, address, email, dob, mob, yob, income, ssn, employmentInfo, financialAssets, supportingDocuments, immigrantName);
                    break;

                case "Display Users":
                    selectUsers();
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }

            System.out.println("\nMenu Option (Insert / Update / Display Users / Exit): ");
            menuOption = sc.nextLine();
        }

        sc.close();
    }
}
