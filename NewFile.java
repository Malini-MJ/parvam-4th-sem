public class NewFile {
    public static void main(String[] args) {
        // ── TRAFFIC SIGNAL EXAMPLE ──────────────────────────
        String signal = "GREEN";

        if (signal.equals("GREEN")) {
            System.out.println("Go, the road is clear");
        } else if (signal.equals("YELLOW")) {
            System.out.println("Slow down, signal is changing");
        } else {
            System.out.println("Stop, signal is red");
        }

        System.out.println("--------------------------------");

        // ── MARKS CHECKER EXAMPLE ──────────────────────────
        int marks = 95;  // Try changing this to 90, 55, 35 and rerun

        if (marks >= 90) {
            System.out.println("Grade: A  — Excellent!");
        } else if (marks >= 75) {
            System.out.println("Grade: B  — Good work!");
        } else if (marks >= 60) {
            System.out.println("Grade: C  — Keep improving.");
        } else {
            System.out.println("Grade: F  — Need to study more.");
        }
    }
}
