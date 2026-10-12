
import java.util.Scanner;

interface SaverMode {
    double getPowerRating();

    default double calculateSaverUnits(double hours) {
        return getPowerRating() * hours / 1000.0 * 0.75;
    }
}

abstract class Appliance {
    double power;

    Appliance(double power) {
        this.power = power;
    }

    double calculateUnits(double hours) {
        return power * hours / 1000.0;
    }

    double calculateCost(double units) {
        return units * 8.0;
    }
}

class Fridge extends Appliance {
    Fridge() {
        super(150);
    }
}

class AirConditioner extends Appliance implements SaverMode {
    AirConditioner() {
        super(1500);
    }

    @Override
    public double getPowerRating() {
        return power;
    }
}

class TV extends Appliance {
    TV() {
        super(100);
    }
}

class Washer extends Appliance implements SaverMode {
    Washer() {
        super(500);
    }

    @Override
    public double getPowerRating() {
        return power;
    }
}

public class HomeApplianceEnergy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim());
        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().trim().split("\\s+");

            String type = input[0].toUpperCase();
            double hours = Double.parseDouble(input[1]);
            boolean saver = input.length > 2
                    && input[2].equalsIgnoreCase("SAVER");

            Appliance appliance;

            switch (type) {
                case "FRIDGE":
                    appliance = new Fridge();
                    break;
                case "AC":
                    appliance = new AirConditioner();
                    break;
                case "TV":
                    appliance = new TV();
                    break;
                default:
                    appliance = new Washer();
            }

            double units;

            if (saver) {
                if (!(appliance instanceof SaverMode)) {
                    System.out.printf(
                        "%s: saver mode not supported%n", type
                    );
                    continue;
                }

                SaverMode saverAppliance = (SaverMode) appliance;
                units = saverAppliance.calculateSaverUnits(hours);
            } else {
                units = appliance.calculateUnits(hours);
            }

            double cost = appliance.calculateCost(units);

            System.out.printf(
                "%s: Units=%.2f Cost=%.2f%n",
                type, units, cost
            );

            totalCost += cost;
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
        sc.close();
    }
}
