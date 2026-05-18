import java.io.BufferedWriter; // 📦 Import Buffered Writer for fast disk write
import java.io.FileWriter; // 📦 Import FileWriter to connect to physical file
import java.io.IOException; // 📦 Import IOException to handle file errors

/**
 * 🏁 DAY 7 ENVIRONMENT SETUP MASTER
 * 🚀 RUN ORDER: [1st] - RUN THIS FILE FIRST BEFORE CODING EXAMPLES!
 * 🎯 GOAL: Programmatically verify environment and seed the test dataset 'students.csv'.
 */
public class Day7_Setup {
    public static void main(String[] args) {
        // 📍 Define the relative path where students.csv will be saved
        String filePath = "students.csv";

        System.out.println("⚙️ [SYSTEM]: Starting Day 7 Environment Verification...");

        // 🛡️ Try-With-Resources block to automatically manage and close file stream resources
        try (FileWriter fw = new FileWriter(filePath);
             BufferedWriter bw = new BufferedWriter(fw)) {

            System.out.println("📂 [SYSTEM]: Initializing 'students.csv' file creation...");

            // ✍️ Write the CSV database header line
            bw.write("Name,Score,Grade");
            bw.newLine(); // Platform-independent newline (\n or \r\n)

            // ✍️ Row 1: Valid Data
            bw.write("Alice,92,A");
            bw.newLine();

            // ✍️ Row 2: Valid Data
            bw.write("Bob,78,B");
            bw.newLine();

            // ✍️ Row 3: INVALID DATA (Score too high, triggers Custom Exception later)
            bw.write("Charlie,105,INVALID");
            bw.newLine();

            // ✍️ Row 4: Valid Data
            bw.write("Diana,65,C");
            bw.newLine();

            // ✍️ Row 5: INVALID DATA (Negative score, triggers Custom Exception later)
            bw.write("Eve,-10,INVALID");
            bw.newLine();

            // ✍️ Row 6: Valid Data
            bw.write("Frank,88,B");
            bw.newLine();

            System.out.println("✅ [SYSTEM]: 'students.csv' created and seeded successfully with 6 student records!");
            System.out.println("👉 [SYSTEM]: Check your directory to verify the file is present.");

        } catch (IOException e) {
            // 🚨 Triggered if the directory is read-only or file creation fails due to system locks
            System.err.println("❌ [SYSTEM ERROR]: Failed to create 'students.csv'!");
            System.err.println("Details: " + e.getMessage());
        }
    }
}