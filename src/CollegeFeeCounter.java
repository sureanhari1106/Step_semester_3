
import java.util.Scanner;

interface BusUser {
    double TRANSPORT_FEE = 12000.0;

    default double getTransportFee() {
        return TRANSPORT_FEE;
    }
}

abstract class CollegeStudent {
    String name;

    CollegeStudent(String name) {
        this.name = name;
    }

    abstract double calculateFee();
}

class DayScholar extends CollegeStudent implements BusUser {
    DayScholar(String name) {
        super(name);
    }

    @Override
    double calculateFee() {
        return 40000 + getTransportFee();
    }
}

class Hosteller extends CollegeStudent {
    Hosteller(String name) {
        super(name);
    }

    @Override
    double calculateFee() {
        return 40000 + 60000;
    }
}

class ScholarshipStudent extends CollegeStudent implements BusUser {
    ScholarshipStudent(String name) {
        super(name);
    }

    @Override
    double calculateFee() {
        return 20000 + getTransportFee();
    }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            String name = sc.next();

            CollegeStudent student;

            switch (type) {
                case "DAY_SCHOLAR":
                    student = new DayScholar(name);
                    break;
                case "HOSTELLER":
                    student = new Hosteller(name);
                    break;
                default:
                    student = new ScholarshipStudent(name);
            }

            double fee = student.calculateFee();
            System.out.printf("%s: %.2f%n", name, fee);
            total += fee;
        }

        System.out.printf("Total Collected: %.2f%n", total);
        sc.close();
    }
}
