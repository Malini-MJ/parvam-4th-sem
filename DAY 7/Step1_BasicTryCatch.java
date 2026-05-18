/**
 * 🛒 TOPIC 1 - STEP 1: THE BASICS OF SURVIVAL
 * 🚀 RUN ORDER: [TOPIC 1 - A] - RUN THIS FIRST IN TOPIC 1.
 * 🎯 GOAL: Learn the fundamental try-catch block structure.
 */
public class Step1_BasicTryCatch {
    public static void main(String[] args) {
        
        System.out.println("⚡ [CRITICAL]: Attempting division...");
        
        // 🛡️ The 'try' block wraps dangerous code that might explode at runtime.
        try {
            // Division by zero is a mathematical impossibility. 
            // We use variables to bypass the compiler's pre-check!
            // Java will generate an 'ArithmeticException' at runtime here.
            int a = 10;
            int b = 0;
            int result = a / b; 
            
            // This line will NEVER be reached because the explosion happens above.
            System.out.println("Result is: " + result); 
            
        } 
        // 🧯 The 'catch' block acts like a fire extinguisher. 
        // It catches the specific explosion (ArithmeticException 'e') and handles it safely.
        catch (ArithmeticException e) {
            System.out.println("🛡️ [CATCH]: Math error captured! Cannot divide by zero.");
            // We can ask the exception for details:
            System.out.println("   -> Exception detail: " + e.getMessage());
        }
        
        // Because we caught the exception, the program did NOT crash!
        System.out.println("✅ [SYSTEM]: System recovered. Program continues smoothly!");
    }
}