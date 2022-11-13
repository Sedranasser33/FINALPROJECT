public class Person {

    static int counter = 0;
    protected int id;
    protected String name;
    protected String address;
    protected int phoneNumber;


    public Person (int id,String name, String address,int phoneNumber ) {
        this.id=id;
        this.name=name;
        this.address=address;
        this.phoneNumber=phoneNumber;
    }

    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
        return null;
    }
}
