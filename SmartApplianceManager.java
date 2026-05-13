import java.util.Scanner;

// FILE: SmartApplianceManager.java
// TOPIC: Day 2 Master Demo (Control Flow + OOP + Terminal Input)
// SCENARIO: Interactive Smart Appliance System with Heater and Washing Machine.

class SmartDevice {
    String deviceName;
    boolean isOn;
    int powerLevel; 

    void turnOn() {
        isOn = true;
        System.out.println(">>> [POWER] " + deviceName + " is now ON.");
    }

    void turnOff() {
        isOn = false;
        System.out.println(">>> [POWER] " + deviceName + " is now OFF.");
    }

    void autoAdjust(int sensorValue) {
        System.out.println("Analyzing sensor feedback (" + sensorValue + " units) for " + deviceName + "...");

        if (sensorValue > 80) {
            powerLevel = 100;
            System.out.println("Decision: MAX Power (100%)");
        } else if (sensorValue > 40) {
            powerLevel = 50;
            System.out.println("Decision: NORMAL Power (50%)");
        } else {
            powerLevel = 10;
            System.out.println("Decision: ECO Power (10%)");
        }
    }

    void statusReport() {
        String state = isOn ? "ACTIVE" : "INACTIVE";
        System.out.println("[" + deviceName + "] State: " + state + " | Intensity: " + powerLevel + "%");
    }
}

public class SmartApplianceManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("====================================");
        System.out.println("   PARVAM SMART APPLIANCE TERMINAL  ");
        System.out.println("====================================\n");

        // 1. Initialize Objects
        SmartDevice heater = new SmartDevice();
        heater.deviceName = "Smart Heater";

        SmartDevice washingMachine = new SmartDevice();
        washingMachine.deviceName = "Smart Washing Machine";

        // 2. Interactive Time Check (Switch-Case)
        System.out.print("Enter current hour (0-23): ");
        int hour = scanner.nextInt();

        switch (hour) {
            case 6: case 7: case 8:
                System.out.println("System: Morning detected. Activating heater for comfort.");
                heater.turnOn();
                heater.powerLevel = 70;
                break;
            case 10: case 11: case 12:
                System.out.println("System: Midday detected. Scheduling washing cycle.");
                washingMachine.turnOn();
                washingMachine.powerLevel = 60;
                break;
            default:
                System.out.println("System: Standard operating mode engaged.");
        }

        // 3. Heater Sensor Simulation
        System.out.println("\n--- HEATER SENSOR CALIBRATION ---");
        System.out.print("How many temperature zones to check? ");
        int zones = scanner.nextInt();

        for (int i = 1; i <= zones; i++) {
            System.out.print("Enter Temperature for Zone " + i + " (0-100): ");
            int reading = scanner.nextInt();
            
            if (reading < 20) {
                System.out.println("Zone " + i + ": Too cold, heater ON.");
                heater.turnOn();
                heater.autoAdjust(reading);
            } else {
                System.out.println("Zone " + i + ": Comfortable temperature.");
            }
        }

        // 4. Washing Machine Simulation
        System.out.println("\n--- WASHING MACHINE LOAD CHECK ---");
        System.out.print("Enter laundry load (0-100): ");
        int load = scanner.nextInt();

        if (load > 70) {
            System.out.println("Heavy load detected. Running full cycle.");
            washingMachine.turnOn();
            washingMachine.autoAdjust(load);
        } else if (load > 30) {
            System.out.println("Medium load detected. Running normal cycle.");
            washingMachine.turnOn();
            washingMachine.autoAdjust(load);
        } else {
            System.out.println("Light load detected. Running quick wash.");
            washingMachine.turnOn();
            washingMachine.autoAdjust(load);
        }

        // 5. Final System Summary
        System.out.println("\n--- FINAL SYSTEM STATUS ---");
        heater.statusReport();
        washingMachine.statusReport();
        
        System.out.println("\nTerminal session closed. Monitoring background processes...");
        scanner.close();
    }
}
