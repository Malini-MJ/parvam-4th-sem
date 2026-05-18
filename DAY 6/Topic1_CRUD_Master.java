import java.sql.*;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Properties;

/**
 * 📘 DAY 6 - TOPIC 1 MASTER (WARNING FIXED)
 * Real-World Example: Hotel Booking System
 */
public class Topic1_CRUD_Master {
    public static void main(String[] args) {
        String jarPath = "C:\\\\Users\\\\Mech\\\\Desktop\\\\malini\\\\DAY 5\\\\mysql-connector-j-9.7.0.jar";
        String dbUrl = "jdbc:mysql://localhost:3306/day6_training_db";

        try {
            URL jarUrl = new URL("file:///" + jarPath.replace("\\", "/"));
            
            // Fixed Resource Leak Warning
            try (URLClassLoader loader = new URLClassLoader(new URL[]{jarUrl}, ClassLoader.getSystemClassLoader())) {
                Driver driver = (Driver) loader.loadClass("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
                Properties props = new Properties();
                props.setProperty("user", "root");
                props.setProperty("password", "");
                Connection conn = driver.connect(dbUrl, props);
                Statement stmt = conn.createStatement();

                System.out.println("🚀 Connected to Hotel System!");

                // CREATE: Adding a guest
                stmt.executeUpdate("INSERT INTO hotel_bookings (guest_name, room_no, price) VALUES ('Rahul_Master', 101, 5000.00)");
                System.out.println("✅ Guest Checked-In.");

                // READ: List guests
                ResultSet rs = stmt.executeQuery("SELECT * FROM hotel_bookings");
                while(rs.next()) {
                    System.out.println("👤 Guest: " + rs.getString("guest_name"));
                }

                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}