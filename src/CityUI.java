import java.util.Scanner;

public class CityUI {

    private static Database db = Database.getInstance();
    private static CityService cityService = new CityService(new CityDAO(db));

    public static void manageCities(Scanner scanner) {
        boolean running = true;

        while(running) {
            System.out.println("Manage cities");
            System.out.println("1. Add City");
            System.out.println("2. Back to Main Menu");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice) {
                case 1:
                    addCity(scanner);
                    break;
                case 2:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again");
            }
        }
    }

    private static void addCity(Scanner scanner) {
        System.out.print("Enter Zip: ");
        String zip = scanner.nextLine();

        System.out.print("Enter City: ");
        String cityName = scanner.nextLine();

        City city = new City(zip,cityName);
        cityService.addCity(city);

    }
}
