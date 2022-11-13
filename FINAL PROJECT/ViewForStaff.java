import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class ViewForStaff {

    static Controller count;
    static Scanner in ;
    public ViewForStaff() throws FileNotFoundException {
        count=new Controller();
        in=new Scanner(System.in);
    }

    public void startForStaff() {
        while (true) {

            Scanner in = new Scanner(System.in);
            System.out.print("CHOOSE FROM THE LIST:\n");
            System.out.println("1_ADD NEW STAFF");
            System.out.println("2_VIEW ALL STAFF");
            System.out.println("3_SEARCH FOR A STAFF");
            System.out.println("4_MODIFY A STAFF");
            System.out.println("5_DELETE A STAFF");
            System.out.println("0_EXIT");

            int choice = in.nextInt();
            switch (choice) {
                case 0:
                    //   count1.writeCustomersFile();
                    System.out.println("GOOD BYE ");
                    System.exit(0);


                    break;
                case 1:
                    this.addStaff();
                    break;
                case 2:
                    this.viewStaff();
                    break;
                case 3:
                    this.findStaff();
                    break;
                case 4:
                    this.editStaff();
                    break;
                case 5:
                    this.deleteStaff();
            }
        }}

    public void addStaff() {


        Scanner in = new Scanner(System.in);
        System.out.println("|      NEW STAFF       |");
        System.out.print("ENTER ID OF STAFF : ");
        int id = in.nextInt();
        System.out.print("ENTER NAME OF STAFF  : ");
        String name = in.next();
        System.out.print("ENTER ADDRESS OF STAFF  : ");
        String address = in.next();
        System.out.print("ENTER PHONE NUMBER OF STAFF : ");
        int phoneNumber = in.nextInt();
        System.out.print("ENTER SALARY OF STAFF  : ");
        double salary=in.nextDouble();
        boolean duplicated = count.checkForDuplicate(new Staff(id, name, address, phoneNumber, salary));
        if (duplicated) {
            System.out.println("THERE IS ALREADY A STAFF  WITH THIS DATA");
        } else {
            boolean success = count.addNewStaff(id, name,salary, address, phoneNumber);
            if (success) {
                System.out.println(" ADDED SUCCESSFULLY");
            } else {
                System.out.println(" INCOMPLETE ADDITION STAFF  ");
            }
        }

    }


    public void viewStaff() {

        System.out.println("|       ALL STAFF    | ");
        System.out.println("ID    NAME    ADDRESS    PHONE NUMBER   SALARY");
        Staff[] all = count.viewAllStaff();
        for (int i = 0; i < all.length; ++i) {
            if (all[i] != null) {
                System.out.println(all[i].getID()+""+all[i].getName()+""+all[i].getAddress()+""+all[i].getPhoneNumber()+""+all[i].getSalary());
            }
        }

        System.out.println(" ________________________________________");
    }

    public void findStaff() {

        Scanner in = new Scanner(System.in);
        System.out.print("INPUT STAFF  ID TO SEARCH : ");
        int searchedID = in.nextInt();
        Staff c = count.searchForStaff(searchedID);
        if (c != null) {
            System.out.println("|      NEW STAFF          |");
            System.out.println("ID    NAME    PRICE    DATE");
            PrintStream var10000 = System.out;
            int var10001 = c.getId();
            var10000.println("" + var10001 + "\t" + c.getName() + "\t" + c.getAddress() + "\t" + c.getPhoneNumber());

        } else {
            System.out.println("SORRY, THERE IS NO STAFF  WITH THIS ID " + searchedID + " ID");
        }

    }

    public void editStaff() {

        Scanner in = new Scanner(System.in);
        int editedID = in.nextInt();
        System.out.print("INPUT STAFF  ID TO EDIT : ");
        int id = in.nextInt();
        System.out.print("ENTER NEW NAME OF STAFF  : ");
        String name = in.next();
        System.out.print("ENTER NEW ADDRESS OF STAFF  : ");
        String address = in.next();
        System.out.print("ENTER NEW PHONE NUMBER OF STAFF : ");
        int phoneNumber = in.nextInt();
        System.out.print("ENTER NEW SALARY OF STAFF  : ");
        double salary=in.nextDouble();

        boolean edited = count.editStaffData(editedID, id, name, address, phoneNumber,salary);
        if (edited) {
            System.out.println("STAFF  " + editedID + "UPDATED SUCCESSFULLY");
        } else {
            System.out.println("SORRY, THERE IS NO STAFF   WITH " + editedID + " ID");
        }

    }

    public void deleteStaff() {
        Scanner in = new Scanner(System.in);
        System.out.print("INPUT STAFF   ID TO DELETE:");
        int deletedID = in.nextInt();
        boolean deleted = count.DeleteStaff(deletedID);
        if (deleted) {
            System.out.println("STAFF  " + deletedID + " DELETED SUCCESSFULLY");
        } else {
            System.out.println("SORRY, THERE IS NO STAFF   WITH " + deletedID + " ID");
        }

    }


}
