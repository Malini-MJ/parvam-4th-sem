public class ForLoopCheck {
    public static void main(String[] args) {
        String name = "Malini";  // Try changing this to "John" or "Steve"

        boolean found = false;

        // Loop through each character in the string
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) == 'a' || name.charAt(i) == 'A') {
                System.out.println("The string contains 'a' at position: " + i);
                found = true;
                break; // stop loop once 'a' is found
            }
        }

        // If no 'a' was found, terminate with a message
        if (!found) {
            System.out.println("The string does not contain 'a'. Program terminated.");
        }
    }
}
