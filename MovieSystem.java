import java.util.Scanner;

// FILE: MovieSystem.java
// TASK: Build a Movie booking system with interactive terminal input
// GOAL: Practice real-world input/output and logic using objects

public class MovieSystem {

    String movieName;
    String showTime;
    int availableSeats;

    void bookTicket(int seats) {
        if (seats <= 0) {
            System.out.println("[ERROR] Invalid seat number!");
        } else if (seats > availableSeats) {
            System.out.println("[ERROR] Not enough seats available! Remaining: " + availableSeats);
        } else {
            availableSeats -= seats;
            System.out.println("[SUCCESS] Booked " + seats + " seat(s) for " + movieName + " at " + showTime);
        }
    }

    void cancelTicket(int seats) {
        if (seats <= 0) {
            System.out.println("[ERROR] Invalid cancellation number!");
        } else {
            availableSeats += seats;
            System.out.println("[SUCCESS] Cancelled " + seats + " seat(s). Seats now available: " + availableSeats);
        }
    }

    void printDetails() {
        System.out.println("\n----------------------------");
        System.out.println("      MOVIE DETAILS         ");
        System.out.println("----------------------------");
        System.out.println("Movie: " + movieName);
        System.out.println("Showtime: " + showTime);
        System.out.println("Available Seats: " + availableSeats);
        System.out.println("----------------------------\n");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MovieSystem movie = new MovieSystem();

        System.out.println("=== WELCOME TO PARVAM CINEMAS ===");
        System.out.print("Enter Movie Name: ");
        movie.movieName = sc.nextLine();

        System.out.print("Enter Show Time: ");
        movie.showTime = sc.nextLine();

        System.out.print("Enter Total Seats: ");
        movie.availableSeats = sc.nextInt();

        boolean running = true;
        while (running) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Book Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. Show Movie Details");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Number of seats to book: ");
                    int book = sc.nextInt();
                    movie.bookTicket(book);
                    break;
                case 2:
                    System.out.print("Number of seats to cancel: ");
                    int cancel = sc.nextInt();
                    movie.cancelTicket(cancel);
                    break;
                case 3:
                    movie.printDetails();
                    break;
                case 4:
                    running = false;
                    System.out.println("Thank you for booking with us!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
        sc.close();
    }
}

