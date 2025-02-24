import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Database {


    private static Database instance;
    private Statement statement;
    private Connection connection;

    //Database information
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/carRental";


    private Database(String username, String password) {
        createConnection(username, password);
    }

    public static Database initialize(String username, String password) {
        if (instance == null) {
            instance = new Database(username, password);
            System.out.println("Connection to database succeeded");
        }
        return instance;
    }


    public static Database getInstance() {
        if (instance == null) {
            System.out.println("Database not initialized. Call initialize() first.");
        }
        return instance;
    }

    // Denne metode opretter forbindelse til database
    public void createConnection(String username, String password) {
        boolean connected = false;

        while(!connected) {
            try {
                connection = DriverManager.getConnection(DATABASE_URL, username, password);
                statement = connection.createStatement();
                connected = true;
            } catch (SQLException e) {
                if (e.getSQLState().equals("28000")) {
                    System.out.println("Invalid Username or Password. Please try again.");
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Welcome to Kailua CarRental!");
                    System.out.print("Enter database username: ");
                    username = scanner.nextLine();
                    System.out.print("Enter database password: ");
                    password = scanner.nextLine();
                } else {
                    throw new RuntimeException("Failed to establish connection", e);
                }
            }
        }
    }

    // Denne metode lukker forbindelse til database
    public void closeConnection() {
        try {
            if(statement != null) {
                statement.close();
                System.out.println("Connection Closed");
            }
            if(connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to close connection", e);
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public Statement getStatement() {
        return statement;
    }
}
