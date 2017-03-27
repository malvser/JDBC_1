package malov.serg;

/**
 * Created by Admin on 27.03.2017.
 */
public class Order {
    public String OrderId;
    public String PrId;
    public String ProductName;
    public String ClId;
    public String ClientName;
    public String Info;

    @Override
    public String toString() {
        return "Order Id: " + OrderId + ", \t" + "Product Name: " + ProductName + ", \t" + "Client Name: " + ClientName  + ", \t"
                + "Order Info: " + Info + "\n ";
    }
}
