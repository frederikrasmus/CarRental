import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class CarUI {

    private static Database db = Database.getInstance();
    private static CarService carService = new CarService(new CarDAO(db));
    private static CarTypeService carTypeService = new CarTypeService(new CarTypeDAO(db));

    public static void manageCars(Scanner scanner) {
        boolean running = true;

        while (running) {
            System.out.println("Manage Cars");
            System.out.println("1. Add Car");
            System.out.println("2. View Car");
            System.out.println("3. Update Car Odometer");
            System.out.println("4. Delete Car");
            System.out.println("5. List all Cars");
            System.out.println("6. Back to Main Menu");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addCar(scanner);
                    break;
                case 2:
                    viewCar(scanner);
                    break;
                case 3:
                    updateCar(scanner);
                    break;
                case 4:
                    deleteCar(scanner);
                    break;
                case 5:
                    listAllCars();
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addCar(Scanner scanner) {
        System.out.print("Enter Registration Number: ");
        String registrationNumber = scanner.nextLine();

        System.out.print("Enter Brand: ");
        String brand = scanner.nextLine();

        System.out.print("Enter Model: ");
        String model = scanner.nextLine();

        System.out.println("Select Fuel Type");
        System.out.println("1. Petrol");
        System.out.println("2. Diesel");
        String fuelType;
        while (true) {
            System.out.println("Choose (1 or 2): ");
            String choice = scanner.nextLine();
            if (choice.equals("1")) {
                fuelType = "Petrol";
                break;
            } else if (choice.equals("2")) {
                fuelType = "Diesel";
                break;
            }
            System.out.println("Invalid choice, try again");
        }

        System.out.print("Enter First Registration Date (YYYY-MM-DD): ");
        String firstRegistrationDate = scanner.nextLine();

        System.out.print("Enter Odometer: ");
        int odometer = scanner.nextInt();
        scanner.nextLine();

        ArrayList<CarType> carTypes = carTypeService.getAllCarTypes();
        System.out.println("Choose a Car Type");
        for(CarType carType : carTypes) {
            System.out.println(carType.getCarTypeId() + ". " + carType.getTypeName());
        }

        int carTypeId = scanner.nextInt();
        scanner.nextLine();

        Car car = new Car(registrationNumber, brand, model, fuelType,
                LocalDate.parse(firstRegistrationDate), odometer, carTypeId);
        carService.addCar(car);
    }

    private static void viewCar(Scanner scanner) {
        System.out.print("Enter Registration Number to find Car: ");
        String registrationNumber = scanner.nextLine();

        Car car = carService.getCar(registrationNumber);
        if (car != null) {
            System.out.println(car);
        } else {
            System.out.println("Car not found.");
        }
    }

    private static void updateCar(Scanner scanner) {
        System.out.print("Enter Registration Number to update Car: ");
        String registrationNumber = scanner.nextLine();

        Car existingCar = carService.getCar(registrationNumber);
        if (existingCar == null) {
            System.out.println("Car not found.");
            return;
        }

        System.out.print("Enter new Odometer value (" + existingCar.getOdometer() + ") or 0 to skip: ");
        String odometerInput = scanner.nextLine();
        int odometer;
        if (odometerInput.equals("0")) {
            odometer = existingCar.getOdometer();
        } else {
            odometer = Integer.parseInt(odometerInput);
            existingCar.setOdometer(odometer);
        }

        carService.updateCar(existingCar);
        System.out.println("Odometer updated successfully.");
    }

    private static void deleteCar(Scanner scanner) {
        System.out.print("Enter Registration Number to delete Car: ");
        String registrationNumber = scanner.nextLine();

        carService.deleteCar(registrationNumber);
    }

    private static void listAllCars() {
        ArrayList<Car> cars = carService.getAllCars();
        for(Car car : cars) {
            System.out.println(car);
        }
    }
}