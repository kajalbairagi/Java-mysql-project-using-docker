// File Name: StudentManagement.java

import java.sql.*;
import java.util.Scanner;

public class StudentManagement {

    // MySQL Database Details
    static final String URL = "jdbc:mysql://mysql-container:3306/testdb";
    static final String USER = "root";
    static final String PASSWORD = "root";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create Connection
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            // Create Table if not exists
            String createTable = "CREATE TABLE IF NOT EXISTS students ("
                    + "id INT PRIMARY KEY AUTO_INCREMENT,"
                    + "name VARCHAR(100),"
                    + "age INT)";
            
            Statement stmt = con.createStatement();
            stmt.execute(createTable);

            while (true) {

                System.out.println("\n===== MENU =====");
                System.out.println("1. Add Student");
                System.out.println("2. View Students");
                System.out.println("3. Exit");
                System.out.print("Enter Choice: ");

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    case 1:
                        // Add Student
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Age: ");
                        int age = sc.nextInt();

                        String insertQuery = "INSERT INTO students(name, age) VALUES (?, ?)";

                        PreparedStatement ps = con.prepareStatement(insertQuery);
                        ps.setString(1, name);
                        ps.setInt(2, age);

                        int rows = ps.executeUpdate();

                        if (rows > 0) {
                            System.out.println("Student Added Successfully!");
                        }

                        break;

                    case 2:
                        // View Students
                        String selectQuery = "SELECT * FROM students";

                        ResultSet rs = stmt.executeQuery(selectQuery);

                        System.out.println("\n--- Student Data ---");

                        while (rs.next()) {
                            System.out.println(
                                    "ID: " + rs.getInt("id")
                                            + ", Name: " + rs.getString("name")
                                            + ", Age: " + rs.getInt("age"));
                        }

                        break;

                    case 3:
                        // Exit
                        System.out.println("Exiting...");
                        con.close();
                        sc.close();
                        System.exit(0);

                    default:
                        System.out.println("Invalid Choice!");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
