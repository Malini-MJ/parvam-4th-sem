import java.util.Scanner;

// FILE: SmartHomeTrainer.java
// TOPIC: Day 2 Master Demo (Control Flow + OOP + Terminal Input)
// SCENARIO: Interactive Smart Home System.

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

public class SmartHomeTrainer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("====================================");
        System.out.println("   PARVAM SMART HOME TERMINAL v3.0  ");
        System.out.println("====================================\n");

        // 1. Initialize Objects
        SmartDevice ac = new SmartDevice();
        ac.deviceName = "Climate Control AC";

        SmartDevice lights = new SmartDevice();
        lights.deviceName = "Smart Ambient Lights";

        // 2. Interactive Time Check (Switch-Case)
        System.out.print("Enter current hour (0-23): ");
        int hour = scanner.nextInt();

        switch (hour) {
            case 6: case 7: case 8:
                System.out.println("System: Good Morning! Disabling outdoor lights.");
                lights.turnOff();
                break;
            case 18: case 19: case 20: case 21:
                System.out.println("System: Evening detected. Engaging safety lighting.");
                lights.turnOn();
                lights.powerLevel = 80;
                break;
            default:
                System.out.println("System: Standard operating mode engaged.");
        }

        // 3. Interactive Sensor Simulation (Loops + Input)
        System.out.println("\n--- CLIMATE SENSOR CALIBRATION ---");
        System.out.print("How many sensor zones to check? ");
        int zones = scanner.nextInt();

        for (int i = 1; i <= zones; i++) {
            System.out.print("Enter Temperature/Load for Zone " + i + " (0-100): ");
            int reading = scanner.nextInt();
            
            if (reading > 50) {
                System.out.println("Warning: High load in Zone " + i);
                ac.turnOn();
                ac.autoAdjust(reading);
            } else {
                System.out.println("Zone " + i + " is stable.");
            }
        }

        // 4. Final System Summary
        System.out.println("\n--- FINAL SYSTEM STATUS ---");
        ac.statusReport();
        lights.statusReport();
        
        System.out.println("\nTerminal session closed. Monitoring background processes...");
        scanner.close();
    }
}