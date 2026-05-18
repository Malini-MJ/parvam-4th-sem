// 👴 Parent Class
class Device {
    public void powerOn() {
        System.out.println("🔌 Device is powered on!");
    }
}

// 👨 Child Class
class MobileDevice extends Device {
    public void connectWiFi() {
        System.out.println("📶 Mobile device connected to WiFi!");
    }
}

// 👦 Grandchild Class
class iPhone extends MobileDevice {
    public void useFaceID() {
        System.out.println("😎 Face ID unlocked the iPhone!");
    }
}

// 🏁 Main Test Class
public class Task_MultilevelDevices {
    public static void main(String[] args) {
        iPhone myPhone = new iPhone();

        // Parent method
        myPhone.powerOn();

        // Child method
        myPhone.connectWiFi();

        // Grandchild method
        myPhone.useFaceID();

        System.out.println("\n💡 An iPhone can do all three things!");
    }
}
