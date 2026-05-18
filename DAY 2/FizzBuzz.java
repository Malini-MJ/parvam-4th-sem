// FILE: FizzBuzz.java
// TOPIC: Loops + if-else combined
// CLASSIC INTERVIEW PROBLEM: Every Java developer must know this

public class FizzBuzz {
    public static void main(String[] args) {

        // Print 1 to 30, but:
        // Divisible by 3  → print Fizz
        // Divisible by 5  → print Buzz
        // Divisible by both → print FizzBuzz
        for (int i = 1; i <= 30; i++) {

            // Check divisible by BOTH first — ORDER MATTERS
            if (i % 15 == 0) {          // % is the modulo (remainder) operator
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);  // just print the number
            }
        }
    }
}