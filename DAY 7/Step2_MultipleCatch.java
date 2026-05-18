/**
 * 🛒 TOPIC 1 - STEP 2: MULTIPLE CATCH BLOCKS (THE SHIELD WALL)
 * 🚀 RUN ORDER: [TOPIC 1 - B] - RUN THIS AFTER STEP 1.
 * 🎯 GOAL: Learn how to handle multiple different types of exceptions safely.
 */
public class Step2_MultipleCatch {
    public static void main(String[] args) {
        
        // Let's create an array of names
        @SuppressWarnings("unused")
        String[] names = {"Alice", "Bob"};
        @SuppressWarnings("unused")
        String emptyName = null; // A null variable has no object attached to it
        
        System.out.println("🛡️ [SYSTEM]: Entering the danger zone...");
        
        try {
            // Uncomment ONE of these danger lines at a time to see which catch block catches it!
            
            // 🧨 DANGER 1: Trying to access an index that doesn't exist
            // System.out.println(names[5]); // This will throw ArrayIndexOutOfBoundsException
            
            // 🧨 DANGER 2: Trying to check the length of a 'null' string
            // System.out.println(emptyName.length()); // This will throw NullPointerException
            
            // 🧨 DANGER 3: Trying to convert letters into a number
            int testScore = Integer.parseInt("abc"); // This will throw NumberFormatException
            System.out.println("Score is: " + testScore);
            
        } 
        // 🧯 Catch Block 1: The Array Shield
        // Rule: Most specific exceptions MUST come first!
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("🚨 [ERROR]: Array Index issue! You tried to access a slot that doesn't exist.");
        } 
        // 🧯 Catch Block 2: The Null Shield
        catch (NullPointerException e) {
            System.out.println("🚨 [ERROR]: Null Pointer! You tried to use an object that hasn't been initialized.");
        } 
        // 🧯 Catch Block 3: The Format Shield
        catch (NumberFormatException e) {
            System.out.println("🚨 [ERROR]: Number Format! You tried to convert text into a number.");
        } 
        // 🧯 Catch Block 4: The Ultimate Catch-All Shield
        // The general 'Exception' superclass catches ANYTHING not caught above. It MUST go last!
        catch (Exception e) {
            System.out.println("🚨 [GENERAL ERROR]: Something else went wrong: " + e.getMessage());
        }
          
        System.out.println("✅ [SYSTEM]: Danger zone passed securely.");
    }
}
