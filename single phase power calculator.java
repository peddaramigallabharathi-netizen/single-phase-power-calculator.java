import java.util.Scanner;

public class SinglePhasePowerCalculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("==========================================");
        System.out.println("      SINGLE PHASE POWER CALCULATOR");
        System.out.println("==========================================");

        try {
            System.out.print("Enter voltage (V): ");
            double voltage = scanner.nextDouble();

            System.out.print("Enter current (A): ");
            double current = scanner.nextDouble();

            System.out.print("Enter power factor (0 to 1): ");
            double powerFactor = scanner.nextDouble();

            if (voltage <= 0 || current <= 0) {
                System.out.println("Error: Voltage and current must be greater than zero.");
                return;
            }

            if (powerFactor <= 0 || powerFactor > 1) {
                System.out.println("Error: Power factor must be between 0 and 1.");
                return;
            }

            // Apparent Power
            double apparentPowerVA = voltage * current;

            // Real Power
            double realPowerW = voltage * current * powerFactor;

            // Reactive Power
            double reactivePowerVAR =
                    Math.sqrt(
                            Math.pow(apparentPowerVA, 2)
                            - Math.pow(realPowerW, 2)
                    );

            // Convert units
            double apparentPowerKVA = apparentPowerVA / 1000;
            double realPowerKW = realPowerW / 1000;
            double reactivePowerKVAR = reactivePowerVAR / 1000;

            System.out.println("\n------------- RESULTS -------------");

            System.out.printf(
                    "Voltage          : %.2f V%n",
                    voltage
            );

            System.out.printf(
                    "Current          : %.2f A%n",
                    current
            );

            System.out.printf(
                    "Power Factor     : %.2f%n",
                    powerFactor
            );

            System.out.printf(
                    "Real Power       : %.2f W (%.2f kW)%n",
                    realPowerW,
                    realPowerKW
            );

            System.out.printf(
                    "Apparent Power   : %.2f VA (%.2f kVA)%n",
                    apparentPowerVA,
                    apparentPowerKVA
            );

            System.out.printf(
                    "Reactive Power   : %.2f VAR (%.2f kVAR)%n",
                    reactivePowerVAR,
                    reactivePowerKVAR
            );

            System.out.println("-----------------------------------");

        } catch (Exception e) {
            System.out.println(
                    "Error: Please enter valid numerical values."
            );
        } finally {
            scanner.close();
        }
    }
}
