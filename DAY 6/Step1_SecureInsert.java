import java.sql.*; // 📦 Import JDBC classes
import java.net.URL; // 📦 Import URL
import java.net.URLClassLoader; // 📦 Import Loader
import java.util.Properties; // 📦 Import Properties

/**
 * 🛡️ TOPIC 2 - STEP 1: THE SECURE SIGNUP
 * 🚀 RUN ORDER: [TOPIC 2 - A] - RUN THIS FIRST IN TOPIC 2.
 * 🎯 GOAL: Add a user securely using PreparedStatement.
 */
public class Step1_SecureInsert {
    public static void main(String[] args) {
        // 📍 Driver Path
        String jarPath = "C:\\\\Users\\\\Mech\\\\Desktop\\\\malini\\\\DAY 5\\\\mysql-connector-j-9.7.0.jar";
        
        // 📍 DB URL
        String dbUrl = "jdbc:mysql://localhost:3306/day6_training_db";

        try {
            // 1️⃣ Format URL
            URL jarUrl = new URL("file:///" + jarPath.replace("\\", "/"));
            
            // 2️⃣ Setup Loader (Warning fixed)
            try (URLClassLoader loader = new URLClassLoader(new URL[]{jarUrl}, ClassLoader.getSystemClassLoader())) {
                
                // 3️⃣ Find Driver rules
                Driver driver = (Driver) loader.loadClass("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
                
                // 4️⃣ Open Secure Connection bridge
                Connection conn = driver.connect(dbUrl, new Properties() {{ setProperty("user", "root"); setProperty("password", ""); }});

                System.out.println("🛡️ [ACTION]: Initializing Secure Member Portal...");

                // 5️⃣ Command: SQL with '?' placeholders (The Security Shields)
                String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
                
                // 6️⃣ Prepare the statement (The Shield is activated here)
                PreparedStatement ps = conn.prepareStatement(sql);
                
                // 7️⃣ Fill Locker 1 (Index 1) with the Username
                ps.setString(1, "Secure_User_01");
                
                // 8️⃣ Fill Locker 2 (Index 2) with the Password
                ps.setString(2, "Pass@9988");

                // 9️⃣ Execute the secure command
                ps.executeUpdate();
                
                System.out.println("✅ [RESULT]: User registered safely using PreparedStatement (No Hacker can touch this!).");
                
                // 🔚 Close bridge
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}