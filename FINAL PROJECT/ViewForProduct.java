import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class ViewForProduct {

    // static Scanner in;
    static Controller count;

    public ViewForProduct() {

    }

    public void start() throws FileNotFoundException {
        while (true) {

            Scanner in = new Scanner(System.in);
            System.out.print("\nCHOOSE FROM THE LIST:\n");
            System.out.println("1_ADD NEW PRODUCT");
            System.out.println("2_VIEW ALL PRODUCTS");
            System.out.println("3_SEARCH FOR A PRODUCT");
            System.out.println("4_MODIFY A PRODUCT");
            System.out.println("5_DELETE A PRODUCT");
            System.out.println("0_EXIT");

            int choice = in.nextInt();
            switch (choice) {
                case 0:
                    count.writeProductFile();
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

        try {
            Scanner in = new Scanner(System.in);
            System.out.println("|      NEW PRODUCT         |");

            System.out.println("ID    NAME    PRICE    DATE");
            int id = in.nextInt();
            String name = in.next();
            double price = Double.parseDouble(in.next());
            String date = in.next();
            boolean duplicated = count.checkForDuplicate(new Products(id, name, price, date));
            if (duplicated) {
                System.out.println("THERE IS ALREADY A PRODUCT WITH THIS DATA");
            } else {
                boolean success = count.addNewProduct(id, name, price, date);
                if (success) {
                    System.out.println(" ADDED SUCCESSFULLY");
                } else {
                    System.out.println(" INCOMPLETE ADDITION PROCESS");
                }
            }

        } catch (Exception e) {
            System.out.println("INVALID SELECTION !");
        }
    }

    public void view() {

        System.out.println("|       ALL PRODUCTS   | ");
        System.out.println("ID    NAME    PRICE    DATE");
        Products[] all = count.viewAllProducts();
        for (int i = 0; i < all.length; ++i) {
            if (all[i] != null) {
                System.out.println(all[i].print());
            }
        }

        System.out.println(" ________________________________________");
    }

    public void find() {

        Scanner in = new Scanner(System.in);
        System.out.print("INPUT PRODUCT ID TO SEARCH : ");
        int searchedID = in.nextInt();
        Products p = count.searchForProduct(searchedID);
        if (p != null) {
            System.out.println("|      NEW PRODUCT         |");
            System.out.println("ID    NAME    PRICE    DATE");
            PrintStream var10000 = System.out;
            int var10001 = p.getId();
            var10000.println("" + var10001 + "\t" + p.getName() + "\t" + p.getPrice() + "\t" + p.getDate());

        } else {
            System.out.println("SORRY, THERE IS NO PRODUCT WITH THIS ID " + searchedID + " ID");
        }

    }

    public void edit() {

        Scanner in = new Scanner(System.in);
        int editedID = in.nextInt();
        System.out.print("INPUT PRODUCT ID TO EDIT : ");
        int id = in.nextInt();
        System.out.print("ENTER NEW NAME OF PRODUCT: ");
        String name = in.next();
        System.out.print("ENTER NEW PRICE OF PRODUCT: ");
        double price = Double.parseDouble(in.next());
        System.out.print("ENTER NEW DATE OF PRODUCT: ");
        String date = in.next();

        boolean edited = count.editProductData(editedID, id, name, price, date);
        if (edited) {
            System.out.println("PRODUCT " + editedID + "UPDATED SUCCESSFULLY");
        } else {
            System.out.println("SORRY, THERE IS NO PRODUCT WITH " + editedID + " ID");
        }

    }

    public void delete() {
        Scanner in = new Scanner(System.in);
        System.out.print("INPUT PRODUCT ID TO DELETE:");
        int deletedID = in.nextInt();
        boolean deleted = count.DeleteProduct(deletedID);
        if (deleted) {
            System.out.println("PRODUCT " + deletedID + " DELETED SUCCESSFULLY");
        } else {
            System.out.println("SORRY, THERE IS NO PRODUCT WITH " + deletedID + " ID");
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