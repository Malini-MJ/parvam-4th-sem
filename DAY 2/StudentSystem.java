import java.util.Scanner;

// FILE: StudentSystem.java
// TASK: Manage 15 students with update and show options

class Student {
    String name;
    int id;
    int marks;

    void updateMarks(int newMarks) {
        if (newMarks < 0 || newMarks > 100) {
            System.out.println("[ERROR] Invalid marks! Must be between 0 and 100.");
        } else {
            marks = newMarks;
            System.out.println("[SUCCESS] Marks updated for " + name + ": " + marks);
        }
    }

    void printDetails() {
        System.out.println("ID: " + id + " | Name: " + name + " | Marks: " + marks);
    }
}

public class StudentSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Insert 15 students
        Student[] students = new Student[15];
        System.out.println("=== INSERT 15 STUDENTS DATA ===");
        for (int i = 0; i < 5; i++) {
            students[i] = new Student();
            System.out.print("Enter Student " + (i+1) + " Name: ");
            students[i].name = sc.nextLine();
            System.out.print("Enter Student " + (i+1) + " ID: ");
            students[i].id = sc.nextInt();
            System.out.print("Enter Student " + (i+1) + " Marks: ");
            students[i].marks = sc.nextInt();
            sc.nextLine(); // consume newline
        }

        // Step 2: Menu
        boolean running = true;
        while (running) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Update Marks");
            System.out.println("2. Show Student Details");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID to update: ");
                    int updateId = sc.nextInt();
                    boolean foundUpdate = false;
                    for (Student s : students) {
                        if (s.id == updateId) {
                            System.out.print("Enter new marks: ");
                            int newMarks = sc.nextInt();
                            s.updateMarks(newMarks);
                            foundUpdate = true;
                            break;
                        }
                    }
                    if (!foundUpdate) {
                        System.out.println("[ERROR] Student ID not found!");
                    }
                    break;

                case 2:
                    System.out.print("Enter Student ID to show: ");
                    int showId = sc.nextInt();
                    boolean foundShow = false;
                    for (Student s : students) {
                        if (s.id == showId) {
                            s.printDetails();
                            foundShow = true;
                            break;
                        }
                    }
                    if (!foundShow) {
                        System.out.println("[ERROR] Student ID not found!");
                    }
                    break;

                case 3:
                    running = false;
                    System.out.println("Exiting Student System. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }
        sc.close();
    }
}
