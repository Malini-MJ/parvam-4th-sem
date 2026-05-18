import java.sql.*; // 📦 Import JDBC tools
import java.net.URL; // 📦 Import URL
import java.net.URLClassLoader; // 📦 Import Loader
import java.util.Properties; // 📦 Import Properties

/**
 * 🛡️ TOPIC 2 - STEP 3: SECURE PASSWORD RESET
 * 🚀 RUN ORDER: [TOPIC 2 - C] - RUN THIS LAST IN TOPIC 2.
 * 🎯 GOAL: Update a user password securely.
 */
public class Step3_SecureUpdate {
    public static void main(String[] args) {
        // 📍 MySQL JAR Location
        String jarPath = "C:\\\\Users\\\\Mech\\\\Desktop\\\\malini\\\\DAY 5\\\\mysql-connector-j-9.7.0.jar";
      String var2 = "jdbc:mysql://localhost:3306/day6_training_db";
        
        // 📍 Database URL
        String dbUrl = "jdbc:mysql://localhost:3306/day6_training_db";

        try {
            // 1️⃣ Format URL
            URL jarUrl = new URL("file:///" + jarPath.replace("\\", "/"));
            
            // 2️⃣ Setup Loader (Warning fixed)
            try (URLClassLoader loader = new URLClassLoader(new URL[]{jarUrl}, ClassLoader.getSystemClassLoader())) {
                
                // 3️⃣ Find the MySQL Driver
                Driver driver = (Driver) loader.loadClass("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
                
                // 4️⃣ Connect to Database
                Connection conn = driver.connect(dbUrl, new Properties() {{ setProperty("user", "root"); setProperty("password", ""); }});

                System.out.println("🛡️ [ACTION]: Processing Password Reset Request...");

                // 5️⃣ SQL with 2 placeholders (1 for password, 1 for username)
                String sql = "UPDATE users SET password = ? WHERE username = ?";
                
                // 6️⃣ Prepare the secure statement
                PreparedStatement ps = conn.prepareStatement(sql);
                
                // 7️⃣ Fill the first '?' (The new password)
                ps.setString(1, "New_Strong_Pass_2024");
                
                // 8️⃣ Fill the second '?' (The target user)
                ps.setString(2, "Secure_User_01");

                // 9️⃣ Execute the update command
                int rowsAffected = ps.executeUpdate();
                
                // 🔟 Show result
                if(rowsAffected > 0) {
                    System.out.println("✅ [RESULT]: Password updated securely for 'Secure_User_01'!");
                } else {
                    System.out.println("❌ [RESULT]: User not found. Password reset failed.");
                }

                // 🔚 Close bridge
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}