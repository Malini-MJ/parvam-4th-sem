public class Salary {
    public static void main(String[] args) {
        // ── EMPLOYEE SALARY LOOKUP ──────────────────────────
        int salary = 9000;  // Try changing this to 4000, 5000, 7000, 9000

        if (salary == 4000) {
            System.out.println("Employee: Alice");
            System.out.println("Age: 25");
        } else if (salary == 5000) {
            System.out.println("Employee: Bob");
            System.out.println("Age: 30");
        } else if (salary == 7000) {
            System.out.println("Employee: Charlie");
            System.out.println("Age: 28");
        } else if (salary == 9000) {
            System.out.println("Employee: Diana");
            System.out.println("Age: 35");
        } else {
            System.out.println("No employee found with salary: " + salary);
        }
    }
}
