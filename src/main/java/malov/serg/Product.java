package malov.serg;

/**
 * Created by Admin on 27.03.2017.
 */
public class Product {

    public String ProductId;
    public String Name;
    public String Price;

    @Override
    public String toString() {
    return "Product Id: " + ProductId + ", \t" + "Product Name: " + Name + ", \t" + "Price: " + Price + " \n";
    }
}

