public class Customers extends Person {

    public Customers(int id, String name, String address, int phoneNumber) {

        super(id, name, address, phoneNumber);
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

    public String setPhoneNumber(int phoneNumber) { super.phoneNumber = phoneNumber;
        return null;
    }

    @Override
    public String toString() {
        return "CUSTOMERS {" +
                "PHONE NUMBER = " + phoneNumber + '\'' +
                ", ID = " + id +
                ", NAME = " + name + '\'' +
                ", ADDRESS = " + address + '\'' +
                '}';
    }


}
