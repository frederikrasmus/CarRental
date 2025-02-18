import java.sql.*;
import java.time.LocalDateTime;



public class RentalDAO {

    private Database database;

    public RentalDAO(Database database) {
        this.database = database;
    }

    public void insertRental(Rental rental) {
        String query = "INSERT INTO rental " +
                "(fromDateTime, toDateTime, maxKm, startOdometer, registrationNumber, driverLicenseNumber) " +
                "VALUES (?,?,?,?,?,?)";
        try (PreparedStatement ps = database.getConnection().prepareStatement(query)) {
            ps.setTimestamp(1, Timestamp.valueOf(rental.getFromDateTime()));
            ps.setTimestamp(2, Timestamp.valueOf(rental.getToDateTime()));
            ps.setInt(3, rental.getMaxKm());
            ps.setInt(4, rental.getStartOdometer());
            ps.setString(5, rental.getRegistrationNumber());
            ps.setString(6, rental.getDriverlicenseNumber());
            ps.executeUpdate();
            System.out.println("Rental added to database");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Rental getRentalById(int rentalId) {
        String query = "SELECT * FROM rental WHERE rental_id = ?";
        try (PreparedStatement ps = database.getConnection().prepareStatement(query)) {
            ps.setInt(1, rentalId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Rental(
                        rs.getInt("rental_id"),
                        rs.getTimestamp("fromDateTime").toLocalDateTime(),
                        rs.getTimestamp("toDateTime").toLocalDateTime(),
                        rs.getInt("maxKm"),
                        rs.getInt("startOdometer"),
                        rs.getString("registrationNumber"),
                        rs.getString("driverLicenseNumber")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void updateRental(Rental rental) {
        String query = "UPDATE rental " +
                "SET fromDateTime = ?, toDateTime = ?, maxKm = ?, startOdometer = ?, registrationNumber = ?, driverLicenseNumber = ? " +
                "WHERE rental_id = ?";
        try (PreparedStatement ps = database.getConnection().prepareStatement(query)) {
            ps.setTimestamp(1, Timestamp.valueOf(rental.getFromDateTime()));
            ps.setTimestamp(2, Timestamp.valueOf(rental.getToDateTime()));
            ps.setInt(3, rental.getMaxKm());
            ps.setInt(4, rental.getStartOdometer());
            ps.setString(5, rental.getRegistrationNumber());
            ps.setString(6, rental.getDriverlicenseNumber());
            ps.setInt(7, rental.getRentalId());
            ps.executeUpdate();
            System.out.println("Rental updated successfully");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void deleteRental(int rentalId) {
        String query = "DELETE FROM rental WHERE rental_id = ?";
        try (PreparedStatement ps = database.getConnection().prepareStatement(query)) {
            ps.setInt(1, rentalId);
            ps.executeUpdate();
            System.out.println("Rental deleted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}