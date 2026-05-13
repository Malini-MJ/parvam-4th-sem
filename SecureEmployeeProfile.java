public class SecureEmployeeProfile {
    private String employeeName;
    private String employeeId;
    private double salary;
    private boolean isActive;

    // Constructor to initialize employee profile
    public SecureEmployeeProfile(String name, String id, double salary) {
        this.employeeName = name;
        this.employeeId = id;
        this.salary = salary;
        this.isActive = true; // Employees are active by default
    }

    // Getter methods
    public String getEmployeeName() {
        return employeeName;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public double getSalary() {
        return salary;
    }

    public boolean getStatus() {
        return isActive;
    }

    // Setter with validation
    public void updateSalary(double newSalary) {
        if (newSalary > 0) {
            this.salary = newSalary;
            System.out.println("✅ Salary updated successfully.");
        } else {
            System.out.println("❌ Error: Salary must be positive.");
        }
    }

    public void deactivateEmployee() {
        this.isActive = false;
        System.out.println("⚠️ Employee has been deactivated.");
    }

    // Main method to test
    public static void main(String[] args) {
        SecureEmployeeProfile emp = new SecureEmployeeProfile("Alice", "EMP123", 50000);

        System.out.println("--- 🛡️ SECURE EMPLOYEE SYSTEM ---");
        System.out.println("Name: " + emp.getEmployeeName());
        System.out.println("ID: " + emp.getEmployeeId());
        System.out.println("Salary: Rs." + emp.getSalary());
        System.out.println("Active: " + emp.getStatus());

        // Attempt to update salary
        emp.updateSalary(-1000); // Invalid
        emp.updateSalary(60000); // Valid

        // Deactivate employee
        emp.deactivateEmployee();

        System.out.println("\nFinal Salary: Rs." + emp.getSalary());
        System.out.println("Active Status: " + emp.getStatus());
    }
}