import java.sql.*; // 📦 Import JDBC classes for database work
import java.net.URL; // 📦 Import URL for JAR path
import java.net.URLClassLoader; // 📦 Import Loader to use the JAR
import java.util.Properties; // 📦 Import Properties for DB login

public class Day6ConnectionCheck {
    public static void main(String[] args) {
        // 📍 Define where the MySQL Driver (The Translator) is on your PC
        String jarPath = "C:\\\\Users\\\\Mech\\\\Desktop\\\\malini\\\\DAY 5\\\\mysql-connector-j-9.7.0.jar";
        
        // 📍 Define the server address (Connecting to XAMPP Server)
        String serverUrl = "jdbc:mysql://localhost:3306/"; 
        
        // 📍 Define the name of the database we want to create
        String dbName = "day6_training_db";

        try {
            // 1️⃣ Convert the file path into a URL format that Java understands
            URL jarUrl = new URL("file:///" + jarPath.replace("\\", "/"));
            
            // 2️⃣ Use a 'Loader' to read the MySQL rules inside the JAR file
            try (URLClassLoader loader = new URLClassLoader(new URL[]{jarUrl}, ClassLoader.getSystemClassLoader())) {
                
                // 3️⃣ Tell Java to find and use the 'MySQL Driver' class from the loader
                Driver driver = (Driver) loader.loadClass("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
                
                // 4️⃣ Setup Login info (XAMPP uses 'root' and no password by default)
                Properties props = new Properties();
                props.setProperty("user", "root");
                props.setProperty("password", "");
                
                // 5️⃣ Open the actual 'Bridge' (Connection) to the XAMPP Server
                Connection conn = driver.connect(serverUrl, props);
                
                // 6️⃣ Create a 'Messenger' (Statement) to send SQL commands
                Statement stmt = conn.createStatement();
                System.out.println("🔗 [1/4] Connected to MySQL Server successfully!");

                // 7️⃣ Command: Create the Database if it doesn't exist
                stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS " + dbName);
                System.out.println("📂 [2/4] Database '" + dbName + "' created/verified.");

                // 8️⃣ Command: Tell Java to use this specific database now
                stmt.executeUpdate("USE " + dbName);

                // 9️⃣ Create all required tables (users, products, hotel_bookings)
                stmt.executeUpdate("CREATE TABLE IF NOT EXISTS users (id INT AUTO_INCREMENT PRIMARY KEY, username VARCHAR(50) UNIQUE, password VARCHAR(50))");
                stmt.executeUpdate("CREATE TABLE IF NOT EXISTS products (pid INT AUTO_INCREMENT PRIMARY KEY, pname VARCHAR(100), price DECIMAL(10,2))");
                stmt.executeUpdate("CREATE TABLE IF NOT EXISTS hotel_bookings (bid INT AUTO_INCREMENT PRIMARY KEY, guest_name VARCHAR(100), room_no INT, price DECIMAL(10,2))");
                System.out.println("📊 [3/4] Tables (users, products, hotel_bookings) are ready.");

                // 🔟 Insert a default user so we can test login later
                stmt.executeUpdate("INSERT IGNORE INTO users (username, password) VALUES ('admin', 'admin123')");
                System.out.println("✅ [4/4] Setup Complete! You are ready to start Day 6.");

                // 🔚 Close the bridge (Always clean up!)
                conn.close();
            }
        } catch (Exception e) {
            // If anything fails (like XAMPP being off), show the error here
            System.out.println("❌ ERROR: " + e.getMessage());
        }
    }
}