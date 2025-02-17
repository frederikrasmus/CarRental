import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CarDAO {

    private Database database;

    public CarDAO(Database database) {
        this.database = database;
    }

    public void insertCar(Car car) {
        String query = "insert into car " +
                "(registrationNumber, brand, model, fuelType, firstRegistrationDate, odometer, carType_id) " +
                "values (?,?,?,?,?,?,?)";
        try(PreparedStatement ps = database.getConnection().prepareStatement(query)) {
            ps.setString(1, car.getRegistrationNumber());
            ps.setString(2, car.getBrand());
            ps.setString(3, car.getModel());
            ps.setString(4, car.getFuelType());
            ps.setDate(5, Date.valueOf(car.getFirstRegistrationDate()));
            ps.setInt(6, car.getOdometer());
            ps.setInt(7, car.getCarTypeId());
            ps.executeUpdate();
            System.out.println("Tilføjet til database");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
/*
    public Customer getCustomerById(String driverLicenseNumber) {
        String query = "select * from customer where driverLicenseNumber = ?";
        try(PreparedStatement ps = database.getConnection().prepareStatement(query)) {
            ps.setString(1, driverLicenseNumber);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                return new Customer(
                        rs.getString("driverLicenseNumber"),
                        rs.getString("fName"),
                        rs.getString("lName"),
                        rs.getString("address"),
                        new City(rs.getString("zip"),"city"),
                        rs.getString("mobilePhone"),
                        rs.getString("email"),
                        rs.getDate("driverSinceDate").toLocalDate()
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void updateCustomer(Customer customer) {
        String query = "update customer " +
                "set fName = ?,lName = ?,address = ?,zip = ?,mobilePhone = ?,email = ?, driverSinceDate = ? " +
                "where driverLicenseNumber = ?";
        try(PreparedStatement ps = database.getConnection().prepareStatement(query)) {
            ps.setString(1, customer.getFName());
            ps.setString(2, customer.getlName());
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

    public void deleteCustomer(Customer customer) {
        String query = "delete from customer where driverLicenseNumber = ?";
        try(PreparedStatement ps = database.getConnection().prepareStatement(query)) {
            ps.setString(1, customer.getDriverLicenseNumber());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

 */
}
