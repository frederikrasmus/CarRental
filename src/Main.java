import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        LoadingScreen.loadingScreen();
        Database database = new Database();

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("---Kailua CarRental---");
            System.out.println("1. Customer");
            System.out.println("2. Rental");
            System.out.println("3. Cars");
            System.out.println("4. Car Types");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            switch(choice) {
                case 1:
                    CustomerUI.manageCustomers(scanner);
                    break;
                case 2:
                    break;
                case 3:
                    CarUI.manageCars(scanner);
                    break;
                case 4:
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Please try again");
            }
        }
    scanner.close();
    }
}
/*
        City city = new City("2300", "Amager");
        LocalDate driverSinceDate = LocalDate.of(2020, 3, 12);
        Customer customer = new Customer("dk43093", "Thomas", "Sandø", "Lyongade 11", city, "54342211", "thomas@sando.dk", driverSinceDate);
        CustomerDAO cDAO = new CustomerDAO(db);


        LocalDate frd = LocalDate.of(2004, 5, 20);
        Car car = new Car("LK84293", "Skoda", "Fabia", "Benzin", frd, 123948, 2);
        CarDAO carDAO = new CarDAO(db);

        LocalDateTime from = LocalDateTime.of(2025, 2, 18, 11, 17);
        LocalDateTime to = LocalDateTime.of(2025, 2, 20, 12, 00);
        Rental r = new Rental(from, to, 1000, 15000, "CD67890", "69008366");
        RentalDAO rentalDAO = new RentalDAO(db);

        rentalDAO.insertRental(r);

*/



