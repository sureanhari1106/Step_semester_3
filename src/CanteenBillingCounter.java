
import java.util.Scanner;

abstract class Customer {
    double amount;

    Customer(double amount) {
        this.amount = amount;
    }

    abstract double calculateFinalAmount();
}

class Student extends Customer {
    Student(double amount) {
        super(amount);
    }

    @Override
    double calculateFinalAmount() {
        return amount * 0.90;
    }
}

class Staff extends Customer {
    Staff(double amount) {
        super(amount);
    }

    @Override
    double calculateFinalAmount() {
        return amount * 0.95;
    }
}

class Guest extends Customer {
    Guest(double amount) {
        super(amount);
    }

    @Override
    double calculateFinalAmount() {
        return amount + 10;
    }
}

public class CanteenBillingCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double amount = sc.nextDouble();

            Customer customer;

            switch (type) {
                case "STUDENT":
                    customer = new Student(amount);
                    break;
                case "STAFF":
                    customer = new Staff(amount);
                    break;
                default:
                    customer = new Guest(amount);
            }

            double finalAmount = customer.calculateFinalAmount();
            System.out.printf("%s: %.2f%n", type, finalAmount);
            total += finalAmount;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
