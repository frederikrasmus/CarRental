import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CityDAO {

    private Database database;

    public CityDAO(Database database) {
        this.database = database;
    }

    public void insertCity(City city) {
        String query = "insert into city(zip, city) values (?,?)";
        try (PreparedStatement ps = database.getConnection().prepareStatement(query)) {
            ps.setString(1, city.getZip());
            ps.setString(2, city.getCityName());
            ps.executeUpdate();
            System.out.println("City added to database");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /*
    public void updateCity(City city) {
        String query = "update city " +
                "set fName = ?,lName = ?,address = ?,zip = ?,mobilePhone = ?,email = ?, driverSinceDate = ? " +
                "where driverLicenseNumber = ?";
        try(PreparedStatement ps = database.getConnection().prepareStatement(query)) {
            ps.setString(1, customer.getFName());
            ps.setString(2, customer.getLName());
            ps.setString(3, customer.getAddress());
            ps.setString(4, customer.getCity().getZip());
            ps.setString(5, customer.getPhoneNumber());
            ps.setString(6, customer.getEmail());
            ps.setDate(7, Date.valueOf(customer.getDriverSinceDate()));
            ps.setString(8, customer.getDriverLicenseNumber());
            ps.executeUpdate();
            System.out.println("Customer updated successfully");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

     */


}
