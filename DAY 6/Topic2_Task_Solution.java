import java.sql.*; // 📦 Import JDBC classes
import java.net.URL; // 📦 Import URL
import java.net.URLClassLoader; // 📦 Import Loader
import java.util.Properties; // 📦 Import Properties

public class Topic2_Task_Solution {
    public static void main(String[] args) {
        // 📍 Driver Path
        String jarPath = "C:\\\\Users\\\\Mech\\\\Desktop\\\\malini\\\\DAY 5\\\\mysql-connector-j-9.7.0.jar";
        
        // 📍 Database URL
        String dbUrl = "jdbc:mysql://localhost:3306/day6_training_db";
 
        try {
            // 1️⃣ Format URL
            URL jarUrl = new URL("file:///" + jarPath.replace("\\", "/"));
            
            // 2️⃣ Setup Loader (Warning fixed)
            try (URLClassLoader loader = new URLClassLoader(new URL[]{jarUrl}, ClassLoader.getSystemClassLoader())) {
                
                // 3️⃣ Find Driver rules
                Driver driver = (Driver) loader.loadClass("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
                
                // 4️⃣ Open Connection
                Connection conn = driver.connect(dbUrl, new Properties() {{ setProperty("user", "root"); setProperty("password", ""); }});

                System.out.println("🛡️ [ACTION]: Security Task Engine Active.");

                // --- TASK 1: Secure Login ---
                // Prepare a secure login query with placeholders
                String loginSQL = "SELECT * FROM users WHERE username = ? AND password = ?";
                PreparedStatement ps1 = conn.prepareStatement(loginSQL);
                
                // Provide parameters for admin login
                ps1.setString(1, "admin");
                ps1.setString(2, "admin123");
                
                // Check if user exists
                if(ps1.executeQuery().next()) {
                    System.out.println("✅ [TASK 1]: Secure login successful!");
                }

                // 🔚 Close bridge
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}