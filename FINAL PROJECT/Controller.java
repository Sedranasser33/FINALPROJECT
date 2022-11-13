import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {

    public int numOfProducts = 0;
    Products[] allProducts = new Products[1000];
    private ArrayList<Person> all;
    private int numOfStaff ;
    private   Staff[] allStaff;
    private   Customers[] allCustomers;
    private int numOfCustomers ;
    public Controller() throws FileNotFoundException { all=new ArrayList<>();
        numOfCustomers = 0;
        numOfStaff = 0;
        allCustomers = new Customers[100];
        allStaff = new Staff[100];
        readCustomersFile();
        readProductFile();
        readStaffFile();
    }

    public boolean addNewProduct(int id, String name, double price, String date) {
        if (this.numOfProducts < this.allProducts.length) {
            ++Products.counter;
            Products p = new Products(id,name,price,date);
            this.allProducts[this.numOfProducts] = p;
            ++this.numOfProducts;
            return true;
        } else {
            return false;
        }
    }
    public Products[] viewAllProducts() {
        return this.allProducts;
    }


    public Products searchForProduct(int id) {
        int i = 0;
        boolean found = false;

        while(!found && i < this.numOfProducts) {
            if (this.allProducts[i].getId() == id) {
                found = true;
            } else {
                ++i;
            }
        }

        return i < this.numOfProducts ? this.allProducts[i] : null;
    }

    public int searchForProductIndex(int id) {
        int i = 0;
        boolean found = false;

        while(!found && i < this.numOfProducts) {
            if (this.allProducts[i].getId() == id) {
                found = true;
            } else {
                ++i;
            }
        }

        return i < this.numOfProducts ? i : -1;
    }

    public boolean DeleteProduct(int id) {
        int index = this.searchForProductIndex(id);
        if (index == -1) {
            return false;
        } else {
            int i;
            for(i = index; i < this.numOfProducts; ++i) {
                this.allProducts[i] = this.allProducts[i + 1];
            }

            this.allProducts[i] = null;
            --this.numOfProducts;
            return true;
        }
    }
    public boolean checkForDuplicate(Products p) {
        for(int i = 0; i < this.numOfProducts; ++i) {
            if (this.allProducts[i].equals(p)) {
                return true;
            }
        }

        return false;
    }

    public boolean editProductData(int id, int newID, String newName, double newPrice, String newDate) {
        int index = this.searchForProductIndex(id);
        if (index != -1) {
            this.allProducts[index].setId(newID);
            this.allProducts[index].setName(newName);
            this.allProducts[index].setPrice(newPrice);
            this.allProducts[index].setDate(newDate);
            return true;
        } else {
            return false;
        }
    }
    public void readProductFile() throws FileNotFoundException {
        Scanner in = new Scanner(new File("D:\\ProductsFile.txt"));

        while(in.hasNext()) {
            int i = in.nextInt();
            String n = in.next();
            double p = Double.parseDouble(in.next());
            String d = in.next();
            this.addNewProduct(i,n, p, d);
        }

        in.close();
    }

    public void writeProductFile() throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(new File("D:\\ProductsFile.txt"));

        for(int i = 0; i < this.numOfProducts; ++i) {
            int v = this.allProducts[i].getId();
            writer.write("" + v + " " + this.allProducts[i].getName() + " " + this.allProducts[i].getPrice() + " " + this.allProducts[i].getDate() + "\n");
        }

        writer.close();
    }





    public void calculatePrice(){
        int x, r,y,z,total=0;
        System.out.println(" 1-CANDLE 2500 \n 2- CANDLE  3800  \n  3- CANDLE 2900 \n 4- CANDLE  2500 \n 5- CANDLE  3800 \n 6-CANDLE   2000    ");


        System.out.println("  SELECT FROM THE LIST :");
        Scanner in = new Scanner(System.in);
        z=in.nextInt();
        for(int i=0 ; i<z;i++) {
            System.out.print(" INPUT THE NUMBER OF THE PRODUCT :  ");
            y = in.nextInt();
            if (y == 1)
                total += 2500;
            if (y == 2)
                total += 3800;
            if (y == 3)
                total += 2900;
            if (y == 4)
                total += 2500;
            if (y == 5)
                total += 3800;
            if (y == 6)
                total += 2000;
        }
    }

    public boolean addNewCustomers(int id, String name, String address, int phoneNumber) {
        if (this.numOfCustomers < this.allCustomers.length) {
            Customers c = new Customers(id, name, address ,phoneNumber );
            this.allCustomers[this.numOfCustomers] = c;
            this.numOfCustomers++;
            Customers.counter++;

            return true;
        } else {
            return false;
        }
    }
    public Customers[] viewAllCustomers() {
        return this.allCustomers;
    }


    public Customers searchForCustomers(int id) {
        int i = 0;
        boolean found = false;

        while(!found && i < this.numOfCustomers) {
            if (this.allCustomers[i].getId() == id) {
                found = true;
            } else {
                i++;
            }
        }

        return i < this.numOfCustomers? this.allCustomers[i] : null;
    }

    public int searchForCustomerIndex(int id) {
        int i = 0;
        boolean found = false;

        while(!found && i < this.numOfCustomers) {
            if (this.allCustomers[i].getId() == id) {
                found = true;
            } else {
                i++;
            }
        }

        return i < this.numOfCustomers ? i : -1;
    }

    public boolean DeleteCustomers(int id) {
        int index = this.searchForCustomerIndex(id);
        if (index == -1) {
            return false;
        } else {
            int i;
            for(i = index; i < this.numOfCustomers;i ++) {
                this.allCustomers[i] = this.allCustomers[i + 1];
            }

            this.allCustomers[i] = null;
            this.numOfCustomers--;
            return true;
        }
    }
    public boolean checkForDuplicate(Customers c) {
        for(int i = 0; i < this.numOfCustomers; i++) {
            if (this.allCustomers[i].equals(c)) {
                return true;
            }
        }

        return false;
    }

    public boolean editCustomersData(int id, int newID, String newName, String newAddress,int newPhoneNumber) {
        int index = this.searchForCustomerIndex(id);
        if (index != -1) {
            this.allCustomers[index].setId(newID);
            this.allCustomers[index].setName(newName);
            this.allCustomers[index].setAddress(newAddress);
            this.allCustomers[index].setPhoneNumber(newPhoneNumber);
            return true;
        } else {
            return false;
        }
    }



    public boolean addNewStaff(int id, String name,double salary, String address, int phoneNumber) {
        if (this.numOfStaff < this.allStaff.length) {
            this.numOfStaff++;
            Staff.counter++;
            Staff s = new Staff(id, name, address, phoneNumber, salary);
            this.allStaff[this.numOfStaff] = s;

            return true;
        } else {
            return false;
        }
    }
    public Staff[] viewAllStaff() {
        return this.allStaff;
    }

    public Staff searchForStaff(int id) {
        int i = 0;
        boolean found = false;

        while(!found && i < this.numOfStaff) {
            if (this.allStaff[i].getId() == id) {
                found = true;
            } else {
                i++;
            }
        }

        return i < this.numOfStaff? this.allStaff[i] : null;
    }

    public int searchForStaffIndex(int id) {
        int i = 0;
        boolean found = false;

        while(!found && i < this.numOfStaff) {
            if (this.allStaff[i].getId() == id) {
                found = true;
            } else {
                i ++;
            }
        }

        return i < this.numOfStaff? i : -1;
    }

    public boolean DeleteStaff(int id) {
        int index = this.searchForStaffIndex(id);
        if (index == -1) {
            return false;
        } else {
            int i;
            for(i = index; i < this.numOfStaff; ++i) {
                this.allStaff[i] = this.allStaff[i + 1];
            }

            this.allStaff[i] = null;
            this.numOfStaff--;
            return true;
        }
    }
    public boolean checkForDuplicate(Staff s) {
        for(int i = 0; i < this.numOfStaff;i ++) {
            if (this.allStaff[i].equals(s)) {
                return true;
            }
        }

        return false;
    }

    public boolean editStaffData(int id, int newID, String newName, String newAddress,int newPhone,double newSalary) {
        int index = this.searchForStaffIndex(id);
        if (index != -1) {
            this.allStaff[index].setId(newID);
            this.allStaff[index].setName(newName);
            this.allStaff[index].setAddress(newAddress);
            this.allStaff[index].setPhoneNumber(newPhone);
            this.allStaff[index].setSalary(newSalary);
            return true;
        } else {
            return false;
        }
    }

    public void readStaffFile() throws FileNotFoundException {
        Scanner in = new Scanner(new File("D:\\StaffFile.txt"));

        while(in.hasNext()) {
            int i = in.nextInt();
            String n = in.next();
            String a= (in.next());
            int p = in.nextInt();
            double s=in.nextDouble();
            this.addNewStaff(i,n,s, a, p);
        }

        in.close();
    }
    //
    public void writeStaffFile() throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(new File("D:\\StaffFile.txt"));

        for(int i = 0; i < this.numOfStaff; ++i) {
            int v = this.allStaff[i].getId();
            writer.write("" + v + " " + this.allStaff[i].getName() + "\n");
        }

        writer.close();
    }
    public void readCustomersFile() throws FileNotFoundException {
        Scanner in = new Scanner(new File("D:\\CusFile.txt"));

        while(in.hasNext()) {
            int i = in.nextInt();
            String n = in.next();
            String a =in.next();
            int  ph= in.nextInt();

            this.addNewCustomers(i,n, a, ph);
        }

        in.close();
    }

    public void writeCustomersFile() throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(new File("D:\\CusFile.txt"));
        int i=0;
        while (i<numOfCustomers) {
            writer.write(allCustomers[i].getId() + " " + this.allCustomers[i].getName() + this.allCustomers[i].getAddress()+" "+ this.allCustomers[i].getPhoneNumber()+"\n");
            i++;
        }

        writer.close();
    }


}



