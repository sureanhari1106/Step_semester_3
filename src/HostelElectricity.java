
import java.util.Scanner;

abstract class Room {
    int units;

    Room(int units) {
        this.units = units;
    }

    abstract double calculateBill();
}

class SingleRoom extends Room {
    SingleRoom(int units) {
        super(units);
    }

    @Override
    double calculateBill() {
        return units * 8.0;
    }
}

class SharedRoom extends Room {
    int occupants;

    SharedRoom(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    @Override
    double calculateBill() {
        return (units * 6.0) / occupants;
    }
}

class ACRoom extends Room {
    ACRoom(int units) {
        super(units);
    }

    @Override
    double calculateBill() {
        return units * 10.0 + 200;
    }
}

public class HostelElectricity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            int units = sc.nextInt();

            Room room;

            switch (type) {
                case "SINGLE":
                    room = new SingleRoom(units);
                    break;

                case "SHARED":
                    int occupants = sc.nextInt();
                    room = new SharedRoom(units, occupants);
                    break;

                default:
                    room = new ACRoom(units);
            }

            double bill = room.calculateBill();
            System.out.printf("%s: %.2f%n", type, bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
