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

    public Car getCarByRegNr(String registrationNumber) {
        String query = "select * from car where registrationNumber = ?";
        try(PreparedStatement ps = database.getConnection().prepareStatement(query)) {
            ps.setString(1, registrationNumber);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                return new Car(
                        rs.getString("registrationNumber"),
                        rs.getString("brand"),
                        rs.getString("model"),
                        rs.getString("fuelType"),
                        rs.getDate("firstRegistrationDate").toLocalDate(),
                        rs.getInt("odometer"),
                        rs.getInt("carType_Id")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void updateCar(Car car) {
        String query = "update car " +
                "set odometer = ? " +
                "where registrationNumber = ?";
        try (PreparedStatement ps = database.getConnection().prepareStatement(query)) {
            ps.setInt(1, car.getOdometer());
            ps.setString(2, car.getRegistrationNumber());
            ps.executeUpdate();
            System.out.println("Car updated successfully");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void deleteCar(String registrationNumber) {
        String query = "delete from car where registrationNumber = ?";
        try(PreparedStatement ps = database.getConnection().prepareStatement(query)) {
            ps.setString(1, registrationNumber);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


}
