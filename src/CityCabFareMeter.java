
import java.util.Scanner;

interface NightService {
    default double applyNightCharge(double fare) {
        return fare * 1.20;
    }
}

abstract class Cab {
    static final double MIN_FARE = 100.0;

    abstract double getRate();

    double calculateDayFare(double km) {
        return Math.max(MIN_FARE, km * getRate());
    }

    abstract double calculateFare(double km, String time);
}

class Mini extends Cab {
    @Override
    double getRate() {
        return 10.0;
    }

    @Override
    double calculateFare(double km, String time) {
        if (time.equalsIgnoreCase("NIGHT")) {
            return -1;
        }
        return calculateDayFare(km);
    }
}

class Sedan extends Cab implements NightService {
    @Override
    double getRate() {
        return 14.0;
    }

    @Override
    double calculateFare(double km, String time) {
        double fare = calculateDayFare(km);

        if (time.equalsIgnoreCase("NIGHT")) {
            fare = applyNightCharge(fare);
        }

        return fare;
    }
}

class SUV extends Cab implements NightService {
    @Override
    double getRate() {
        return 18.0;
    }

    @Override
    double calculateFare(double km, String time) {
        double fare = calculateDayFare(km);

        if (time.equalsIgnoreCase("NIGHT")) {
            fare = applyNightCharge(fare);
        }

        return fare;
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double km = sc.nextDouble();
            String time = sc.next().toUpperCase();

            Cab cab;

            switch (type) {
                case "MINI":
                    cab = new Mini();
                    break;
                case "SEDAN":
                    cab = new Sedan();
                    break;
                default:
                    cab = new SUV();
            }

            double fare = cab.calculateFare(km, time);

            if (fare < 0) {
                System.out.printf(
                    "%s: night service not available%n", type
                );
            } else {
                System.out.printf("%s: %.2f%n", type, fare);
                total += fare;
            }
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
