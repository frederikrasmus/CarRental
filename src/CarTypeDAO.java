import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CarTypeDAO {

    private Database database;

    public CarTypeDAO(Database database) {
        this.database = database;
    }

    public void insertCarType(CarType carType) {
        String query = "INSERT INTO car_type " +
                "(typeName, automaticGear, airCondition, cruiseControl, leatherSeats, engineSize, horsePower, seats) " +
                "VALUES (?,?,?,?,?,?,?,?)";
        try (PreparedStatement ps = database.getConnection().prepareStatement(query)) {
            ps.setString(1, carType.getTypeName());
            ps.setBoolean(2, carType.isAutomaticGear());
            ps.setBoolean(3, carType.isAirCondition());
            ps.setBoolean(4, carType.isCruiseControl());
            ps.setBoolean(5, carType.isLeatherSeats());
            ps.setInt(6, carType.getEngineSize());
            ps.setInt(7, carType.getHorsePower());
            ps.setInt(8, carType.getSeats());
            ps.executeUpdate();
            System.out.println("Car type added to database");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public CarType getCarTypeById(int carTypeId) {
        String query = "SELECT * FROM car_type WHERE carType_id = ?";
        try (PreparedStatement ps = database.getConnection().prepareStatement(query)) {
            ps.setInt(1, carTypeId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new CarType(
                        rs.getInt("carType_id"),
                        rs.getString("typeName"),
                        rs.getBoolean("automaticGear"),
                        rs.getBoolean("airCondition"),
                        rs.getBoolean("cruiseControl"),
                        rs.getBoolean("leatherSeats"),
                        rs.getInt("engineSize"),
                        rs.getInt("horsePower"),
                        rs.getInt("seats")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void updateCarType(CarType carType) {
        String query = "UPDATE car_type " +
                "SET typeName = ?, automaticGear = ?, airCondition = ?, cruiseControl = ?, leatherSeats = ?, engineSize = ?, horsePower = ?, seats = ? " +
                "WHERE carType_id = ?";
        try (PreparedStatement ps = database.getConnection().prepareStatement(query)) {
            ps.setString(1, carType.getTypeName());
            ps.setBoolean(2, carType.isAutomaticGear());
            ps.setBoolean(3, carType.isAirCondition());
            ps.setBoolean(4, carType.isCruiseControl());
            ps.setBoolean(5, carType.isLeatherSeats());
            ps.setInt(6, carType.getEngineSize());
            ps.setInt(7, carType.getHorsePower());
            ps.setInt(8, carType.getSeats());
            ps.setInt(9, carType.getCarTypeId());
            ps.executeUpdate();
            System.out.println("Car type updated successfully");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void deleteCarType(int carTypeId) {
        String query = "DELETE FROM car_type WHERE carType_id = ?";
        try (PreparedStatement ps = database.getConnection().prepareStatement(query)) {
            ps.setInt(1, carTypeId);
            ps.executeUpdate();
            System.out.println("Car type deleted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}