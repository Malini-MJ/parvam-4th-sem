import java.sql.*; // 📦 Import JDBC classes
import java.net.URL; // 📦 Import URL
import java.net.URLClassLoader; // 📦 Import Loader
import java.util.Properties; // 📦 Import Properties

/**
 * 🗑️ TOPIC 1 - STEP 3: SOLD OUT!
 * 🚀 RUN ORDER: [TOPIC 1 - C] - RUN THIS LAST IN TOPIC 1.
 * 🎯 GOAL: Delete the 'AirPods Pro' item from the inventory.
 */
public class Step3_DeleteOne {
    public static void main(String[] args) {
        // 📍 MySQL Driver Location
        String jarPath = "D:\\Xampp\\htdocs\\ParvaM\\CEC\\mysql-connector-j-9.7.0\\mysql-connector-j-9.7.0.jar";
        
        // 📍 Target Database
        String dbUrl = "jdbc:mysql://localhost:3306/day6_training_db";

        try {
            // 1️⃣ Format the JAR path
            URL jarUrl = new URL("file:///" + jarPath.replace("\\", "/"));
            
            // 2️⃣ Setup the Loader (Fixes the leak warning)
            try (URLClassLoader loader = new URLClassLoader(new URL[]{jarUrl}, ClassLoader.getSystemClassLoader())) {
                
                // 3️⃣ Tell Java to find the MySQL Driver rules
                Driver driver = (Driver) loader.loadClass("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
                
                // 4️⃣ Open the Connection bridge
                Connection conn = driver.connect(dbUrl, new Properties() {{ setProperty("user", "root"); setProperty("password", ""); }});
                
                System.out.println("🗑️ [ACTION]: Processing Sale... Removing 'AirPods Pro' from stock.");

                // 5️⃣ Define the SQL command to delete a specific product by its name
                String sql = "DELETE FROM products WHERE pname = 'AirPods Pro'";
                
                // 6️⃣ Send the command and store how many rows were removed
                int rowsAffected = conn.createStatement().executeUpdate(sql);

                // 7️⃣ Check if the deletion actually happened
                if(rowsAffected > 0) {
                    System.out.println("✅ [RESULT]: 'AirPods Pro' sold and removed from inventory database.");
                } else {
                    System.out.println("⚠️ [NOTICE]: Item 'AirPods Pro' was not found in the shop.");
                }

                // 🔚 Close the bridge
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}