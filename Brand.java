/**
 * 🔄 TOPIC: METHOD OVERRIDING (BRANDS & DEVICES)
 * 
 * Analogy: A Parent company makes a generic device.
 * The Child brand inherits the device but customizes it.
 * They "Override" the parent's version with their own.
 */

// 1. Parent Class
class Device {
    private String brand = "Generic";

    public String getBrand() { return brand; }

    void start() {
        System.out.println("🔌 Starting a generic " + brand + " device...");
    }
}

// 2. Child 1 (Overrides start method)
class Samsung extends Device {
    @Override
    void start() {
        System.out.println("📱 Samsung device booting with OneUI...");
    }
}

// 3. Child 2 (Overrides start method differently)
class Apple extends Device {
    @Override
    void start() {
        System.out.println("🍎 Apple device booting with iOS...");
    }
}

// 🏁 Main Test Class
public class Brand {
    public static void main(String[] args) {
        System.out.println("--- ⚙️ DEVICE STARTUP SYSTEM ---");

        Device d1 = new Samsung(); // Samsung is a Device
        Device d2 = new Apple();   // Apple is a Device

        d1.start(); // Calls Samsung’s overridden version
        d2.start(); // Calls Apple’s overridden version

        System.out.println("\n💡 LESSON: Overriding lets each brand give its own version of a parent's action.");
    }
}
