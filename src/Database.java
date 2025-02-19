import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {


    private static Database instance;
    private Statement statement;
    private Connection connection;

    //Database information
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/carRental";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Gde45daq!";


    public Database() {
        createConnection();
        System.out.println("Connection to database succeeded");
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    // Denne metode opretter forbindelse til database
    public void createConnection() {

        try {
            connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to establish connection", e);
        }
    }

    // Denne metode lukker forbindelse til database
    public void closeConnection() {
        try {
            if(statement != null) {
                statement.close();
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
