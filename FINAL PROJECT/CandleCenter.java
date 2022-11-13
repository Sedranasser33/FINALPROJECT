import java.io.FileNotFoundException;
import java.util.Scanner;

public class CandleCenter {

    public static void main(String[] args) throws FileNotFoundException {
        ViewForProduct v = new ViewForProduct();
        ViewForCus c = new ViewForCus();
        ViewForStaff s = new ViewForStaff();
        Scanner in = new Scanner(System.in);
        System.out.println("\n|    CANDLE DISTRIBUTION CENTER     |\n\n");

        System.out.println("1_CUSTOMERS SERVICES\t2_STAFFS DATA \n3_EXIT");
        try {
            int choice = in.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("1_BUY \t 2_RESERVATION");
                    int selection = in.nextInt();
                    switch (selection) {
                        case 1:

                            v.start();
                            break;
                        case 2:
                            c.startForCus();
                            break;
                    }
                case 2:
                    s.startForStaff();
                case 3:
                    System.exit(0);
            }
        } catch (Exception e) {
            System.out.println("NOT A VALID SELECTION");
        }
    }
}