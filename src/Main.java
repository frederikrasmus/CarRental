import java.sql.SQLException;
import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Database db = Database.getInstance();
        City city = new City("2300", "Amager");
        LocalDate driverSinceDate = LocalDate.of(2020,3,12);
        Customer customer = new Customer("dk43093", "Thomas", "Sandø", "Lyongade 11", city,"54342211","thomas@sando.dk",driverSinceDate);
        CustomerDAO cDAO = new CustomerDAO(db);

        LocalDate frd = LocalDate.of(2004,5,20);
        Car car = new Car("LK84293","Skoda","Fabia","Benzin",frd,123948,2);

        CarDAO carDAO = new CarDAO(db);
        carDAO.insertCar(car);



        db.closeConnection();
    }
}