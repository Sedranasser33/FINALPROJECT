import java.util.Objects;

public class Products {

    static int counter = 0;
    private int id;
    private String name;
    private double price;
    private String date;

    public Products(int id, String name, double price, String date) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.date = date;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
//    public String toString() {
//        return "PRODUCTS {" +
//                "ID = " + id +
//                ", NAME = " + name + '\'' +
//                ", PRICE = " + price +
//                ", DATE = " + date + '\'' +
//                '}';
//    }

    public String toString() {
        return "\n"+ id +
                "\t" + name +
                "\t" + price +
                "\t" + date + "";
    }

    public String print() {
        return this.id + "\t" + this.name + "\t" + this.price + "\t" + this.date + "\n";
    }

    @Override

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (this.getClass() != o.getClass()) {
            return false;
        } else {
            Products p = (Products)o;
            return p.getId() == this.getId() && p.getName().equals(this.getName())
                    && p.getPrice()==this.getPrice() && p.getDate().equals(this.getDate()) ;
        }
    }

}
