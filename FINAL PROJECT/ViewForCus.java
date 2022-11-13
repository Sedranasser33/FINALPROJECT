import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class ViewForCus {

    static Scanner in;
    static Controller count;

    public ViewForCus() throws FileNotFoundException {
        count = new Controller();
        in = new Scanner(System.in);
    }

    public void startForCus() throws FileNotFoundException {

        while (true) {

            Scanner in = new Scanner(System.in);
            System.out.print("CHOOSE FROM THE LIST:\n");
            System.out.println("1_ADD NEW CUSTOMER");
            System.out.println("2_VIEW ALL CUSTOMER");
            System.out.println("3_SEARCH FOR A CUSTOMER");
            System.out.println("4_MODIFY A CUSTOMER");
            System.out.println("5_DELETE A CUSTOMER");
            System.out.println("0_EXIT");

            int choice = in.nextInt();
            switch (choice) {
                case 0:
                    count.writeCustomersFile();
                    System.out.println("GOOD BYE ");
                    System.exit(0);
                    break;
                case 1:
                    this.add();
                    break;
                case 2:
                    this.view();
                    break;
                case 3:
                    this.find();
                    break;
                case 4:
                    this.edit();
                    break;
                case 5:
                    this.delete();
            }
        }
    }

    public void add() {


        Scanner in = new Scanner(System.in);
        System.out.println("|      NEW CUSTOMER        |");

        System.out.println("ID    NAME    ADDRESS PHONE NUMBER ORDER NAME");
        int id = in.nextInt();
        String name = in.next();
        String address = in.next();
        int phoneNumber = in.nextInt();

        boolean duplicated = count.checkForDuplicate(new Customers(id, name, address, phoneNumber));
        if (duplicated) {
            System.out.println("THERE IS ALREADY A CUSTOMER  WITH THIS DATA");
        } else {
            boolean success = count.addNewCustomers(id, name, address, phoneNumber);
            if (success) {
                System.out.println(" ADDED SUCCESSFULLY");
            } else {
                System.out.println(" INCOMPLETE ADDITION CUSTOMER ");
            }
        }
    }

    public void view() {

        System.out.println("|       ALL CUSTOMERS   | ");
        System.out.println("ID    NAME    ADDRESS    PHONE NUMBER");
        Customers[] all = count.viewAllCustomers();
        for (int i = 0; i < all.length; ++i) {
            if (all[i] != null) {
                System.out.println(all[i].getID() + "" + all[i].getName() + "" + all[i].getAddress() + "" + all[i].getPhoneNumber());
            }
        }

        System.out.println(" ________________________________________");
    }

    public void find() {

        Scanner in = new Scanner(System.in);
        System.out.print("INPUT CUSTOMER  ID TO SEARCH : ");
        int searchedID = in.nextInt();
        Customers c = count.searchForCustomers(searchedID);
        if (c != null) {
            System.out.println("|      NEW CUSTOMER         |");
            System.out.println("ID    NAME    PRICE    DATE");
            PrintStream var10000 = System.out;
            int var10001 = c.getId();
            var10000.println("" + var10001 + "\t" + c.getName() + "\t" + c.getAddress() + "\t" + c.getPhoneNumber());

        } else {
            System.out.println("SORRY, THERE IS NO CUSTOMER  WITH THIS ID " + searchedID + " ID");
        }

    }

    public void edit() {

        //   Scanner in = new Scanner(System.in);
        int editedID = in.nextInt();
        System.out.print("INPUT CUSTOMER ID TO EDIT : ");
        int id = in.nextInt();
        System.out.print("ENTER NEW NAME OF CUSTOMER : ");
        String name = in.next();
        System.out.print("ENTER NEW ADDRESS OF CUSTOMER : ");
        String address = in.next();
        System.out.print("ENTER NEW PHONE NUMBER CUSTOMER : ");
        int phoneNumber = in.nextInt();

        boolean edited = count.editCustomersData(editedID, id, name, address, phoneNumber);
        if (edited) {
            System.out.println("CUSTOMER  " + editedID + "UPDATED SUCCESSFULLY");
        } else {
            System.out.println("SORRY, THERE IS NO CUSTOMER  WITH " + editedID + " ID");
        }

    }

    public void delete() {
        //    Scanner in = new Scanner(System.in);
        System.out.print("INPUT CUSTOMER  ID TO DELETE:");
        int deletedID = in.nextInt();
        boolean deleted = count.DeleteCustomers(deletedID);
        if (deleted) {
            System.out.println("CUSTOMER  " + deletedID + " DELETED SUCCESSFULLY");
        } else {
            System.out.println("SORRY, THERE IS NO CUSTOMER  WITH " + deletedID + " ID");
        }

    }


    static {
        Scanner in = new Scanner(System.in);

        try {
            count = new Controller();
        } catch (FileNotFoundException var1) {
            throw new RuntimeException(var1);
        }
    }


}