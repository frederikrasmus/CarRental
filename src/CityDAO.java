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
}
