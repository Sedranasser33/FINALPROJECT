public class Staff extends Person {

    private double salary;

    public Staff(int id, String name, String address, int phoneNumber, double salary) {
        super(id, name, address, phoneNumber);
        this.salary = salary;
    }

    public void setID(int id) {
        super.id = id;
    }

    public int getID() {
        return super.id;
    }

    public void setName(String name) {
        super.name = name;
    }

    public String getName() {
        return super.name;
    }

    public void setAddress(String address) {
        super.address = address;
    }

    public String getAddress() {
        return super.address;
    }


    public int getPhoneNumber() {
        return phoneNumber;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

//    public String setPhoneNumber(int phoneNumber) {
//        super.phoneNumber = phoneNumber;
//
//        public String print() {
//
//            return super.id + "\t" + super.name + "\t" + super.address + "\t" + super.phoneNumber + "\t" + this.salary +"\n";
//        }}

    @Override
    public String toString() {
        return "STAFFS {" +
                '\'' +
                ", ID = " + id +
                ", NAME = " + name + '\'' +
                "SALARY = " + salary +
                "PHONE NUMBER = " + phoneNumber +
                ", ADDRESS = " + address + '\'' +
                '}';

    }
}