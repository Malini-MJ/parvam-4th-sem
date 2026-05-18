/**
 * 🧬 TOPIC: INHERITANCE (The "IS-A" Relationship)
 * 
 * Analogy: Think of a Family. 
 * A Grandfather has a 'House' and a 'Name'.
 * The Father inherits the 'House' and 'Name' automatically, but adds a 'Car'.
 * The Son inherits everything and adds a 'Laptop'.
 * 
 * This is 'BasicPhone' - our PARENT (Base) class.
 */

public class BasicPhone {
    // 🔒 We make fields PRIVATE to protect them
    private String brand;
    private String model;

    // 🏗️ Constructor to initialize
    public BasicPhone(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    // 🟢 GETTERS to read the data
    public String getBrand() { return brand; }
    public String getModel() { return model; }

    // ☎️ Methods
    public void makeCall(String number) {
        System.out.println("☎️ Calling " + number + " using " + brand + " phone...");
    }

    public void sendMessage(String number, String text) {
        System.out.println("✉️ Sending SMS to " + number + ": " + text);
        
    }
}