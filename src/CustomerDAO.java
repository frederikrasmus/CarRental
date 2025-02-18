import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAO {

    private Database database;

    public CustomerDAO(Database database) {
        this.database = database;
    }

    public void insertCustomer(Customer customer) {
        String query = "insert into customer " +
                "(driverLicenseNumber, fName,lName, address, zip, mobilePhone, email, driverSinceDate) " +
                "values (?,?,?,?,?,?,?,?)";
        try(PreparedStatement ps = database.getConnection().prepareStatement(query)) {
            ps.setString(1, customer.getDriverLicenseNumber());
            ps.setString(2, customer.getFName());
            ps.setString(3, customer.getLName());
            ps.setString(4, customer.getAddress());
            ps.setString(5, customer.getCity().getZip());
            ps.setString(6, customer.getPhoneNumber());
            ps.setString(7, customer.getEmail());
            ps.setDate(8, Date.valueOf(customer.getDriverSinceDate()));
            ps.executeUpdate();
            System.out.println("Tilføjet til database");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

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

    public void deleteCustomer(String driverLicenseNumber) {
        String query = "delete from customer where driverLicenseNumber = ?";
        try(PreparedStatement ps = database.getConnection().prepareStatement(query)) {
            ps.setString(1, driverLicenseNumber);
            ps.executeUpdate();
            System.out.println("Customer deleted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
