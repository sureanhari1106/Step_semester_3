
import java.util.Scanner;
import java.time.LocalDate;

abstract class Subscription {
    String name;
    LocalDate startDate;

    Subscription(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    abstract int getValidityDays();

    LocalDate calculateRenewalDate() {
        return startDate.plusDays(getValidityDays());
    }
}

class BasicPlan extends Subscription {
    BasicPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    int getValidityDays() {
        return 30;
    }
}

class StandardPlan extends Subscription {
    StandardPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    int getValidityDays() {
        return 90;
    }
}

class PremiumPlan extends Subscription {
    PremiumPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    @Override
    int getValidityDays() {
        return 365;
    }
}

public class StreamingRenewal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            String name = sc.next();
            LocalDate date = LocalDate.parse(sc.next());

            Subscription subscription;

            switch (type) {
                case "BASIC":
                    subscription = new BasicPlan(name, date);
                    break;

                case "STANDARD":
                    subscription = new StandardPlan(name, date);
                    break;

                default:
                    subscription = new PremiumPlan(name, date);
            }

            System.out.printf("%s: %s%n",
                    subscription.name,
                    subscription.calculateRenewalDate());
        }

        sc.close();
    }
}
