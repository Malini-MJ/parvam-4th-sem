import java.sql.*;
import java.util.Scanner;

/**
 * 🏢 FULL SOLUTION: NEXUS MALL MANAGEMENT SYSTEM
 * Professional JDBC application with a Menu System.
 */
public class MallManagerSolution {

    // Database connection details
    private static final String URL = "jdbc:mysql://localhost:3306/nexus_mall_db";
    private static final String USER = "root";   // Default XAMPP username
    private static final String PASS = "";       // Default XAMPP password is empty

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("🚀 Starting Nexus Mall Control Center...");

        // Load MySQL JDBC Driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("✅ MySQL driver loaded successfully!");
        } catch (ClassNotFoundException e) {
            System.out.println("❌ JDBC Driver not found! Make sure the MySQL Connector JAR is added.");
            return;
        }

        while (true) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. View All Shops");
            System.out.println("2. View Total Mall Revenue");
            System.out.println("3. Find Premium Shops");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            if (choice == 4) {
                System.out.println("👋 Shutting down system. Goodbye!");
                break;
            }

            processChoice(choice);
        }
        sc.close();
    }

    private static void processChoice(int choice) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             Statement stmt = conn.createStatement()) {

            switch (choice) {
                case 1:
                    ResultSet rsShops = stmt.executeQuery("SELECT * FROM shops");
                    System.out.println("\nID | Name | Category | Rent");
                    while (rsShops.next()) {
                        System.out.printf("%d | %-15s | %-10s | %.2f%n",
                                rsShops.getInt("shop_id"),
                                rsShops.getString("name"),
                                rsShops.getString("category"),
                                rsShops.getDouble("daily_rent"));
                    }
                    break;

                case 2:
                    ResultSet rsRev = stmt.executeQuery("SELECT SUM(amount) FROM daily_sales");
                    if (rsRev.next()) {
                        System.out.println("\n💰 Total Revenue: " + rsRev.getDouble(1));
                    }
                    break;

                case 3:
                    ResultSet rsPrem = stmt.executeQuery("SELECT name FROM shops WHERE daily_rent > 5000");
                    System.out.println("\n💎 PREMIUM SHOPS:");
                    while (rsPrem.next()) {
                        System.out.println("- " + rsPrem.getString("name"));
                    }
                    break;

                default:
                    System.out.println("❌ Invalid Choice!");
            }

        } catch (SQLException e) {
            System.out.println("❌ Database Error: " + e.getMessage());
        }
    }
}
