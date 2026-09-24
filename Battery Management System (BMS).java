# Battery-Management-System-BMS-
Monitors battery voltage, current, temperature, charging, and protection.
```java
import java.util.Scanner;

public class BMS {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== BATTERY MANAGEMENT SYSTEM =====");

        System.out.print("Enter Battery Voltage (V): ");
        double voltage = sc.nextDouble();

        System.out.print("Enter Battery Current (A): ");
        double current = sc.nextDouble();

        System.out.print("Enter Temperature (C): ");
        double temperature = sc.nextDouble();

        System.out.print("Enter Battery SOC (%): ");
        double soc = sc.nextDouble();

        boolean safe = true;

        // Voltage protection
        if (voltage > 4.2) {
            System.out.println("FAULT: Over Voltage!");
            safe = false;
        }

        if (voltage < 3.0) {
            System.out.println("FAULT: Under Voltage!");
            safe = false;
        }

        // Temperature protection
        if (temperature > 45) {
            System.out.println("FAULT: High Temperature!");
            safe = false;
        }

        // SOC protection
        if (soc > 100 || soc < 0) {
            System.out.println("FAULT: Invalid SOC!");
            safe = false;
        }

        System.out.println("\n===== BMS RESULT =====");

        System.out.println("Voltage     : " + voltage + " V");
        System.out.println("Current     : " + current + " A");
        System.out.println("Temperature : " + temperature + " C");
        System.out.println("SOC         : " + soc + " %");

        if (safe) {
            System.out.println("BMS Status  : SAFE");
            System.out.println("Battery     : NORMAL");
        } else {
            System.out.println("BMS Status  : FAULT");
            System.out.println("Battery     : PROTECTION ACTIVE");
        }

        sc.close();
    }
}
```
