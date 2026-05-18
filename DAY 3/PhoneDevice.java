/**
 * 🧬 TOPIC: INHERITANCE (The "IS-A" Relationship)
 * 
 * Analogy: Think of a Family. 
 * A Grandfather has a 'House' and a 'Name'.
 * The Father inherits the 'House' and 'Name' automatically, but adds a 'Car'.
 * The Son inherits everything and adds a 'Laptop'.
 * 
 * This is 'PhoneDevice' - our PARENT (Base) class.
 */

public class PhoneDevice {
    // 🔒 We make fields PRIVATE to protect them
    private String brand;
    private String model;

    // 🏗️ Constructor to initialize
    public PhoneDevice(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    // 🟢 GETTERS to read the data
    public String getBrand() { 
        return brand; 
    }

    public String getModel() { 
        return model; 
    }

    // ☎️ Methods
    public void makeCall(String number) {
        System.out.println("☎️ Calling " + number + " using " + brand + " phone...");
    }

    public void sendMessage(String number, String text) {
        System.out.println("✉️ Sending SMS to " + number + ": " + text);
    }

    // 🏁 Main method to test the class
    public static void main(String[] args) {
        PhoneDevice phone = new PhoneDevice("Nokia", "1100");

        phone.makeCall("9876543210");
        phone.sendMessage("9876543210", "Hello from my PhoneDevice!");

        System.out.println("Brand: " + phone.getBrand());
        System.out.println("Model: " + phone.getModel());
    }
}
