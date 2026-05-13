/**
 * 🧬 TOPIC: INHERITANCE (The 'extends' keyword)
 * 
 * This is 'SmartPhone' - our CHILD (Derived) class.
 * It "extends" BasicPhone, which means it gets everything from BasicPhone for FREE!
 */

public class SmartPhone extends BasicPhone {
    
    private boolean has5G;
    private int cameraMP;

    // 🏗️ Constructor
    public SmartPhone(String brand, String model, int cameraMP) {
        // 🧙‍♂️ 'super' calls the Parent's constructor
        super(brand, model);
        this.cameraMP = cameraMP;
    }
                                                                                               
    // 🌐 Child specific methods
    public void browseInternet() {
        // We use getModel() because 'model' is private in Parent
        System.out.println("🌐 Browsing the web on " + getModel() + "...");
    }

    public void takePhoto() {
        System.out.println("📸 Taking a photo with " + cameraMP + "MP camera!");
    }

    // 🏁 Main method to test SmartPhone
    public static void main(String[] args) {
        SmartPhone myPhone = new SmartPhone("Apple", "iPhone 15", 48);
        
        // 1. Use actions from the PARENT (BasicPhone)
        myPhone.makeCall("9999912345");
        myPhone.sendMessage("9999912345", "Hello from SmartPhone!");

        // 2. Use NEW features only in the CHILD (SmartPhone)
        myPhone.takePhoto();
        myPhone.browseInternet();
        
        System.out.println("\n💡 CONCLUSION: Inheritance + Encapsulation = Clean, Secure Code!");
    }
}
