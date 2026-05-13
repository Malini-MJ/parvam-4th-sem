import java.util.Scanner;

// FILE: BankAccount.java
// TASK: Build a BankAccount class with interactive terminal input
// GOAL: Practice real-world input/output and logic using objects

public class BankAccount {

    String accountHolder;
    String accountNumber;
    double balance;

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("[SUCCESS] Deposited Rs. " + amount);
        } else {
            System.out.println("[ERROR] Invalid deposit amount!");
        }
    }

    void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("[ERROR] Invalid withdrawal amount!");
        } else if (amount > balance) {
            System.out.println("[ERROR] Insufficient balance! Available: Rs. " + balance);
        } else {
            balance -= amount;
            System.out.println("[SUCCESS] Withdrawn Rs. " + amount);
        }
    }

    void printStatement() {
        System.out.println("\n----------------------------");
        System.out.println("      ACCOUNT STATEMENT      ");
        System.out.println("----------------------------");
        System.out.println("Holder: " + accountHolder);
        System.out.println("Number: " + accountNumber);
        System.out.println("Balance: Rs. " + balance);
        System.out.println("----------------------------\n");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount userAcc = new BankAccount();

        System.out.println("=== WELCOME TO PARVAM BANK ===");
        System.out.print("Enter Your Name: ");
        userAcc.accountHolder = sc.nextLine();

        System.out.print("Enter Account ID: ");
        userAcc.accountNumber = sc.nextLine();

        System.out.print("Enter Initial Deposit: ");
        userAcc.balance = sc.nextDouble();

        boolean running = true;
        while (running) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Print Statement");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Amount to deposit: ");
                    double dep = sc.nextDouble();
                    userAcc.deposit(dep);
                    break;
                case 2:
                    System.out.print("Amount to withdraw: ");
                    double wth = sc.nextDouble();
                    userAcc.withdraw(wth);
                    break;
                case 3:
                    userAcc.printStatement();
                    break;
                case 4:
                    running = false;
                    System.out.println("Thank you for banking with us!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
        sc.close();
    }
}