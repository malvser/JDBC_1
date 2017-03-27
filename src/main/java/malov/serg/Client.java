package malov.serg;

/**
 * Created by Admin on 27.03.2017.
 */
public class Client {

    public String ClientId;
    public String Name;
    public String Surname;
    public String Phone;

    @Override
    public String toString() {
        return "Client{" +
                "ClId='" + ClientId + '\'' +
                ", Name='" + Name + '\'' +
                ", Surname='" + Surname + '\'' +
                ", Phone='" + Phone + '\'' +
                '}';
    }
}
