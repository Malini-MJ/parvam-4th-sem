// Type Casting = converting a value from one data type to another
// Two kinds: Widening (automatic) and Narrowing (manual)

public class TypeCastingDemo {

    public static void main(String[] args) {

        // ---- STRING CONCATENATION ----
        String firstName = "malini";
        String lastName  = "mj";
        String city      = "bangalore";

        // + joins Strings — called CONCATENATION
        String fullName = firstName + " " + lastName;
        System.out.println("Full Name: " + fullName);
        System.out.println("City: " + city);

        // ---- WIDENING CAST (Automatic) ----
        // int has less precision than doubl
        // e
        // Java automatically "widens" int into double — no cast needed
        int marks = 85;
        double marksDouble = marks; // automatic, no error
        System.out.println("Marks as double: " + marksDouble); // prints 85.0

        // ---- NARROWING CAST (Manual — Programmer must ask for it) ----
        // double has more precision than int
        // We MUST explicitly cast using (int) — we take responsibility
        double cgpa = 8.75;
        int cgpaInt = (int) cgpa; // decimal part is CUT OFF, NOT rounded
        System.out.println("CGPA as int: " + cgpaInt); // prints 8, NOT 9!

        // TRAINER TIP: Ask students "what will print?" before running.
        // Most will say 9. When 8 appears — that's the aha moment!
        // Teach: (int) TRUNCATES (chops off), it does NOT round.

    }
}
