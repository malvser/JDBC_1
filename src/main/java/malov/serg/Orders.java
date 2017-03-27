package malov.serg;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Admin on 27.03.2017.
 */
public class Orders {
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_CONNECTION = "jdbc:mysql://127.0.0.1:3306/mydb";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "26s_volam";

    private static Connection getDBConnection() {
        Connection dbConnection = null;
        try {
            Class.forName(DB_DRIVER);
        } catch(ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
        }catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }

    public static void showAllClients() throws SQLException {
        ArrayList<Client> clients = new ArrayList<Client>();

        Connection dbConnection = null;
        Statement statement = null;
        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * from client");

            while(rs.next()) {
                Client client = new Client();
                client.ClientId = rs.getString("ClientId");
                client.Name = rs.getString("Name");
                client.Surname = rs.getString("Surname");
                client.Phone = rs.getString("Phone");
                clients.add(client);
            }

            System.out.println(clients.toString());

        } catch(SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null)
                statement.close();
            if (dbConnection != null)
                dbConnection.close();
        }
    }

    public static void showAllProducts() throws SQLException {
        ArrayList<Product> products = new ArrayList<Product>();

        Connection dbConnection = null;
        Statement statement = null;
        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * from product");

            while(rs.next()) {
                Product product = new Product();
                product.ProductId = rs.getString("ProductId");
                product.Name = rs.getString("Name");
                product.Price = rs.getString("Price");
                products.add(product);
            }

            System.out.println(products.toString());

        } catch(SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null)
                statement.close();
            if (dbConnection != null)
                dbConnection.close();
        }
    }

    public static String takeProductNameById(String id) throws SQLException  {
        String name = "";

        ArrayList<Product> products = new ArrayList<Product>();

        Connection dbConnection = null;
        Statement statement = null;
        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * from product");

            while(rs.next()) {
                Product product = new Product();
                product.ProductId = rs.getString("ProductId");
                product.Name = rs.getString("Name");
                product.Price = rs.getString("Price");
                products.add(product);
            }

            for(Product p : products) {
                if(p.ProductId.equals(id)) {
                    name = p.Name;
                } else {
                    ;
                }
            }

        } catch(SQLException e) {
            name = "failName";
            System.out.println(e.getMessage());
        } finally {
            if (statement != null)
                statement.close();
            if (dbConnection != null)
                dbConnection.close();
        }

        return name;
    }

    public static String takeClientNameById(String id) throws SQLException  {
        String name = "";

        ArrayList<Client> clients = new ArrayList<Client>();

        Connection dbConnection = null;
        Statement statement = null;
        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * from client");

            while(rs.next()) {
                Client client = new Client();
                client.ClientId = rs.getString("ClientId");
                client.Name = rs.getString("Name");
                client.Surname= rs.getString("Surname");
                client.Phone = rs.getString("Phone");
                clients.add(client);
            }

            for(Client c : clients) {
                if(c.ClientId.equals(id)) {
                    name = c.Name;
                } else {
                    ;
                }
            }

        } catch(SQLException e) {
            name = "failName";
            System.out.println(e.getMessage());
        } finally {
            if (statement != null)
                statement.close();
            if (dbConnection != null)
                dbConnection.close();
        }

        return name;
    }

    public static void showAllOrders() throws SQLException {
        ArrayList<Order> orders = new ArrayList<Order>();

        Connection dbConnection = null;
        Statement statement = null;
        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * from orders");

            while(rs.next()) {
                Order order = new Order();
                order.OrderId = rs.getString("OrderId");
                order.PrId = rs.getString("PrId");
                order.ProductName = takeProductNameById(order.PrId);
                order.ClId = rs.getString("ClId");
                order.ClientName = takeClientNameById(order.ClId);
                order.Info = rs.getString("Info");
                orders.add(order);
            }

            System.out.println(orders.toString());

        } catch(SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null)
                statement.close();
            if (dbConnection != null)
                dbConnection.close();
        }
    }

    public static boolean clientNameCheck(String clientName) throws SQLException {
        boolean result = false;

        ArrayList<Client> clients = new ArrayList<Client>();

        Connection dbConnection = null;
        Statement statement = null;
        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * from client");

            while(rs.next()) {
                Client client = new Client();
                client.ClientId = rs.getString("ClientId");
                client.Name = rs.getString("Name");
                client.Surname = rs.getString("Surname");
                client.Phone = rs.getString("Phone");
                clients.add(client);
            }

            for(Client c : clients) {
                if(c.Name.equals(clientName)) {
                    result = true;
                } else {
                    ;
                }
            }

        } catch(SQLException e) {
            result = false;
            System.out.println(e.getMessage());
        } finally {
            if (statement != null)
                statement.close();
            if (dbConnection != null)
                dbConnection.close();
        }
        return result;
    }

    public static boolean productNameCheck(String clientName) throws SQLException {
        boolean result = false;

        ArrayList<Product> products = new ArrayList<Product>();

        Connection dbConnection = null;
        Statement statement = null;
        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * from product");

            while(rs.next()) {
                Product product = new Product();
                product.ProductId = rs.getString("ProductId");
                product.Name = rs.getString("Name");
                product.Price = rs.getString("Price");
                products.add(product);
            }

            for(Product p : products) {
                if(p.Name.equals(clientName)) {
                    result = true;
                } else {
                    ;
                }
            }

        } catch(SQLException e) {
            result = false;
            System.out.println(e.getMessage());
        } finally {
            if (statement != null)
                statement.close();
            if (dbConnection != null)
                dbConnection.close();
        }
        return result;
    }

    public static int getClientIdByName(String clientName) throws SQLException {
        int result = 0;

        ArrayList<Client> clients = new ArrayList<Client>();

        Connection dbConnection = null;
        Statement statement = null;
        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * from client");

            while(rs.next()) {
                Client client = new Client();
                client.ClientId = rs.getString("ClientId");
                client.Name = rs.getString("Name");
                client.Surname = rs.getString("Surname");
                client.Phone = rs.getString("Phone");
                clients.add(client);
            }

            for(Client c : clients) {
                if(c.Name.equals(clientName)) {
                    result = Integer.parseInt(c.ClientId);
                } else {
                    ;
                }
            }

        } catch(SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null)
                statement.close();
            if (dbConnection != null)
                dbConnection.close();
        }

        return result;
    }

    public static int getProductIdByName(String productName) throws SQLException {
        int result = 0;

        ArrayList<Product> products = new ArrayList<Product>();

        Connection dbConnection = null;
        Statement statement = null;
        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * from product");

            while(rs.next()) {
                Product product = new Product();
                product.ProductId = rs.getString("ProductId");
                product.Name = rs.getString("Name");
                product.Price = rs.getString("Price");
                products.add(product);
            }

            for(Product p : products) {
                if(p.Name.equals(productName)) {
                    result = Integer.parseInt(p.ProductId);
                } else {
                    ;
                }
            }

        } catch(SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null)
                statement.close();
            if (dbConnection != null)
                dbConnection.close();
        }

        return result;
    }

    public static void addOrder(String ClientName, String ProductName) throws SQLException {

        if(clientNameCheck(ClientName) && productNameCheck(ProductName)) {

            int clientId = getClientIdByName(ClientName);
            int productId = getProductIdByName(ProductName);
            String info = "";

            String request = "INSERT INTO orders(productName, clientName, prId, clId) VALUES (ProductName, ClientName, + " +  productId + " ," + clientId + ")";

            Connection dbConnection = null;
            Statement statement = null;

            try {
                dbConnection = getDBConnection();
                statement = dbConnection.createStatement();

                statement.execute(request);
            }catch(SQLException e) {
                System.out.println(e.getMessage());
            } finally {
                if (statement != null)
                    statement.close();
                if (dbConnection != null)
                    dbConnection.close();
            }
        } else {
            System.out.println("Fail Product Name or Client");
        }
    }

    //============================================================
    public static void main(String[] args) {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            showAllClients();
            showAllProducts();
            addOrder("Vanya", "Orange");
            showAllOrders();

        }catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}