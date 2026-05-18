import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
// import java.io.IOException; // Removed unused import

import java.sql.Connection;
import java.sql.Driver;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.Properties;

/**
 * 🗄️ TOPIC 6 - BONUS: FILE TO XAMPP DATABASE MIGRATION (ETL SCRIPT)
 * 🚀 RUN ORDER: [TOPIC 6 - BONUS]
 * 🎯 GOAL: The ultimate integration. Read a CSV file, validate data via exceptions,
 * and push clean rows into a MySQL database via JDBC dynamically!
 */

// 💎 Reusing our Custom Exception for Domain Logic
@SuppressWarnings("serial")
class DatabaseInvalidScoreException extends Exception {
    public DatabaseInvalidScoreException(String message) {
        super(message);
    }
}

public class Step1_CSV_to_Database {

    public static void validateScore(String name, int score) throws DatabaseInvalidScoreException {
        if (score < 0 || score > 100) {
            throw new DatabaseInvalidScoreException(
                "🚨 [ERROR - OUT OF RANGE]: " + name + " has score " + score + " (must be 0-100)"
            );
        }
    }

    public static void main(String[] args) {
        
        System.out.println("============================================");
        System.out.println("     🗄️ STUDENT DB MIGRATION SERVICE      ");
        System.out.println("============================================");

        // 📍 Define Paths (Ensure these match your system!)
        String csvFilePath = "students.csv";
        String jarPath = "C:\\\\Users\\\\Mech\\\\Desktop\\\\malini\\\\DAY 5\\\\mysql-connector-j-9.7.0.jar";
        String serverUrl = "jdbc:mysql://localhost:3306/";
        String dbName = "day7_training_db";

        try {
            // 1️⃣ DYNAMIC JAR LOADING (Just like Day 6)
            URL jarUrl = new URL("file:///" + jarPath.replace("\\", "/"));
            
            // We use nested Try-With-Resources for BOTH the ClassLoader and the FileReader!
            try (
                URLClassLoader loader = new URLClassLoader(new URL[]{jarUrl}, ClassLoader.getSystemClassLoader());
                BufferedReader br = new BufferedReader(new FileReader(csvFilePath))
            ) {
                // 2️⃣ ESTABLISH DATABASE CONNECTION
                Driver driver = (Driver) loader.loadClass("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
                Properties props = new Properties();
                props.setProperty("user", "root");
                props.setProperty("password", "");
                
                // Open the actual connection. We don't put this in Try-With-Resources because 
                // we want explicit control over closing it after our queries.
                Connection conn = driver.connect(serverUrl, props);
                System.out.println("🔗 [SYSTEM]: Connected to MySQL server...");

                // 3️⃣ PREPARE THE DATABASE SCHEMA
                Statement stmt = conn.createStatement();
                stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS " + dbName);
                stmt.executeUpdate("USE " + dbName);
                System.out.println("📂 [SYSTEM]: Database '" + dbName + "' created/verified.");
                
                // Create table. We use UNIQUE on name so we don't insert the same student twice if we run this twice.
                stmt.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS students_table (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "name VARCHAR(100) UNIQUE, " +
                    "score INT, " +
                    "grade VARCHAR(10)" +
                    ")"
                );

                // 4️⃣ PREPARE THE INSERTION QUERY (Using Secure PreparedStatement)
                // INSERT IGNORE tells MySQL: "If this name already exists, skip it instead of crashing!"
                String insertQuery = "INSERT IGNORE INTO students_table (name, score, grade) VALUES (?, ?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(insertQuery);

                // 5️⃣ BEGIN CSV PARSING & DATA MIGRATION
                String line;
                boolean isFirstLine = true;
                int validCount = 0;
                int invalidCount = 0;

                while ((line = br.readLine()) != null) {
                    if (isFirstLine) { isFirstLine = false; continue; } // Skip header

                    String[] parts = line.split(",");
                    if (parts.length != 3) {
                        System.out.println("⚠️ [SKIP]: Malformed line found: " + line);
                        invalidCount++;
                        continue;
                    }

                    String name = parts[0].trim();
                    String scoreStr = parts[1].trim();
                    String grade = parts[2].trim();

                    try {
                        // Data Transformation & Validation
                        int score = Integer.parseInt(scoreStr);
                        validateScore(name, score);

                        // If the data is pristine, we inject it into our PreparedStatement
                        pstmt.setString(1, name);
                        pstmt.setInt(2, score);
                        pstmt.setString(3, grade);
                        
                        // Execute the database write
                        int rowsAffected = pstmt.executeUpdate();
                        
                        if (rowsAffected > 0) {
                            System.out.println("✅ [OK]:  " + name + " | Migrated to DB");
                        } else {
                            System.out.println("ℹ️ [INFO]: " + name + " | Skipped (Already exists in DB)");
                        }
                        
                        validCount++;

                    } catch (NumberFormatException e) {
                        System.out.println("🚨 [ERROR - CORRUPT]: " + name + " has non-numeric score: '" + scoreStr + "'");
                        invalidCount++;
                    } catch (DatabaseInvalidScoreException e) {
                        System.out.println(e.getMessage());
                        invalidCount++;
                    } catch (SQLException e) {
                        System.out.println("🚨 [DB ERROR]: Failed to insert " + name + " into database: " + e.getMessage());
                        invalidCount++;
                    }
                }

                // 6️⃣ CLEANUP DB RESOURCES
                pstmt.close();
                stmt.close();
                conn.close();
                
                System.out.println("============================================");
                System.out.println("✅ Migration complete! Total Migrated: " + validCount + ", Total Failed: " + invalidCount);
                System.out.println("👉 Open XAMPP phpMyAdmin -> " + dbName + " to verify your data!");
                System.out.println("============================================");

            }

        } catch (FileNotFoundException e) {
            System.out.println("🚨 [FATAL ERROR]: File '" + csvFilePath + "' not found! Run Day 7 Setup first.");
        } catch (Exception e) {
            System.out.println("🚨 [SYSTEM ERROR]: A critical system error occurred! " + e.getMessage());
        }
    }
}