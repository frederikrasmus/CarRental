import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class RentalUI {

    private static RentalService rentalService = new RentalService(new RentalDAO(new Database()));
    private static CarService carService = new CarService(new CarDAO(new Database()));
    private static CustomerService customerService = new CustomerService(new CustomerDAO(new Database()));

    public static void manageRentals(Scanner scanner) {
        boolean running = true;

        while (running) {
            System.out.println("Manage Rental");
            System.out.println("1. Add Rental");
            System.out.println("2. View Rental");
            System.out.println("3. Update Rental");
            System.out.println("4. Delete Rental");
            System.out.println("5. Back to Main Menu");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addRental(scanner);
                    break;
                case 2:
                    viewRental(scanner);
                    break;
                case 3:
                    updateRental(scanner);
                    break;
                case 4:
                    deleteRental(scanner);
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void addRental(Scanner scanner) {

        LocalDateTime fromDate;
        LocalDateTime toDate;

        System.out.println("Enter start Date (YYYY-MM-DD): ");
        String startDate = scanner.nextLine();
        try {
            fromDate = LocalDateTime.parse(startDate + "T12:00:00");
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date. Please enter valid");
            return;
        }

        System.out.println("Enter end Date (YYYY-MM-DD): ");
        String endDate = scanner.nextLine();
        try {
            toDate = LocalDateTime.parse(endDate + "T12:00:00");
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date. Please enter valid");
            return;
        }

        System.out.println("Enter Max Km: ");
        int maxKm = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter Registration Number: ");
        String regNr = scanner.nextLine();

        Car car = carService.getCar(regNr);
        if(car == null) {
            System.out.println("Car not found");
            return;
        }

        int startOdometer = car.getOdometer();

        System.out.println("Enter Driver License Number: ");
        String driverLicenseNumber = scanner.nextLine();

        Rental rental = new Rental(fromDate,toDate,maxKm,startOdometer,regNr,driverLicenseNumber);
        rentalService.addRental(rental);
    }

    private static void viewRental(Scanner scanner) {
        System.out.print("Enter Rental Id to find Rental: ");
        int rentalID = scanner.nextInt();
        scanner.nextLine();

        Rental rental = rentalService.getRentalById(rentalID);
        if (rental != null) {
            System.out.println(rental);
        } else {
            System.out.println("Car not found.");
        }
    }

    private static void updateRental(Scanner scanner) {
        System.out.println("Enter Rental ID to Update: ");
        int rentalID = scanner.nextInt();
        scanner.nextLine();

        Rental rental = rentalService.getRentalById(rentalID);
        if(rental == null) {
            System.out.println("Rental not found");
            return;
        }

        System.out.println("Current Start Date:" + rental.getFromDateTime().toLocalDate());
        System.out.println("Enter new Start Date (YYYY-MM-DD) or Press 0 to Skip");
        String startDate = scanner.nextLine();
        LocalDateTime fromDate = rental.getFromDateTime();

        if(!startDate.equals("0")) {
            try {
                fromDate = LocalDateTime.parse(startDate + "T12:00:00");
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date. Please enter valid");
                return;
            }
        }

        System.out.println("Current End Date:" + rental.getToDateTime().toLocalDate());
        System.out.println("Enter new End Date (YYYY-MM-DD) or Press 0 to Skip");
        String endDate = scanner.nextLine();
        LocalDateTime toDate = rental.getToDateTime();
        if(!endDate.equals("0")) {
            try {
            toDate = LocalDateTime.parse(endDate + "T12:00:00");
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date. Please enter valid");
                return;
            }
        }

        System.out.println("Current Max Km: " + rental.getMaxKm());
        System.out.println("Enter new Max Km or Press 0 to Skip");
        String maxKmInput = scanner.nextLine();
        int maxKm = rental.getMaxKm();
        if(!maxKmInput.equals("0")) {
            maxKm = Integer.parseInt(maxKmInput);
        }

        System.out.println("Current Registration Number: " + rental.getRegistrationNumber());
        System.out.print("Enter new Registration Number or Press 0 to Skip: ");
        String regNr = scanner.nextLine();
        if (regNr.equals("0")) {
            regNr = rental.getRegistrationNumber();
        }

        Car car = carService.getCar(regNr);
        if(car == null) {
            System.out.println("Car not found");
            return;
        }

        int startOdometer = car.getOdometer();

        System.out.println("Current Driver License Number: " + rental.getDriverlicenseNumber());
        System.out.print("Enter new Driver License Number or Press 0 to Skip: ");
        String driverLicenseNumber = scanner.nextLine();
        if (driverLicenseNumber.equals("0")) {
            driverLicenseNumber = rental.getDriverlicenseNumber();
        }

        Rental updatedRental = new Rental(rentalID,fromDate,toDate,maxKm,startOdometer,regNr,driverLicenseNumber);
        rentalService.updateCarType(updatedRental);
    }

    private static void deleteRental(Scanner scanner) {
        System.out.println("Enter Rental ID to delete Rental");
        int rID = scanner.nextInt();
        scanner.nextLine();
        rentalService.deleteRental(rID);
    }

}
