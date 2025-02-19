import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class CarTypeUI {

    private static CarTypeService carTypeService = new CarTypeService(new CarTypeDAO(new Database()));

    public static void manageCarTypes(Scanner scanner) {
        boolean running = true;

        while (running) {
            System.out.println("Manage Cars Types");
            System.out.println("1. Add Car Type");
            System.out.println("2. View Car Type");
            System.out.println("3. Update Car Type");
            System.out.println("4. Delete Car Type");
            System.out.println("5. Back to Main Menu");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addCarType(scanner);
                    break;
                case 2:
                    viewCarType(scanner);
                    break;
                case 3:
                    updateCarType(scanner);
                    break;
                case 4:
                    deleteCarType(scanner);
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addCarType(Scanner scanner) {
        System.out.print("Enter Name of Car Type: ");
        String typeName = scanner.nextLine();

        System.out.println("Select Gear Type");
        System.out.println("1. Automatic");
        System.out.println("2. Manual");
        boolean automaticGear;
        while (true) {
            System.out.println("Choose (1 or 2): ");
            String choice = scanner.nextLine();
            if (choice.equals("1")) {
                automaticGear = true;
                break;
            } else if (choice.equals("2")) {
                automaticGear = false;
                break;
            }
            System.out.println("Invalid choice, try again");
        }

        System.out.println("Select Aircondition");
        System.out.println("1. Yes");
        System.out.println("2. No");
        boolean airCondition;
        while (true) {
            System.out.println("Choose (1 or 2): ");
            String choice = scanner.nextLine();
            if (choice.equals("1")) {
                airCondition = true;
                break;
            } else if (choice.equals("2")) {
                airCondition = false;
                break;
            }
            System.out.println("Invalid choice, try again");
        }

        System.out.println("Select Cruise Control");
        System.out.println("1. Yes");
        System.out.println("2. No");
        boolean cruiseControl;
        while (true) {
            System.out.println("Choose (1 or 2): ");
            String choice = scanner.nextLine();
            if (choice.equals("1")) {
                cruiseControl = true;
                break;
            } else if (choice.equals("2")) {
                cruiseControl = false;
                break;
            }
            System.out.println("Invalid choice, try again");
        }

        System.out.println("Select Leather Seats");
        System.out.println("1. Yes");
        System.out.println("2. No");
        boolean leatherSeats;
        while (true) {
            System.out.println("Choose (1 or 2): ");
            String choice = scanner.nextLine();
            if (choice.equals("1")) {
                leatherSeats = true;
                break;
            } else if (choice.equals("2")) {
                leatherSeats = false;
                break;
            }
            System.out.println("Invalid choice, try again");
        }

        System.out.println("Enter Engine Size: ");
        int engineSize = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Horse Power: ");
        int horsePower = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Number of Seats: ");
        int seats = scanner.nextInt();
        scanner.nextLine();


        CarType carType = new CarType(typeName,automaticGear,airCondition,cruiseControl,leatherSeats,engineSize,horsePower,seats);
        carTypeService.addCarType(carType);
    }

    private static void viewCarType(Scanner scanner) {
        System.out.print("Enter Car Type Id to find Car Type: ");
        int carTypeId = scanner.nextInt();
        scanner.nextLine();

        CarType carType = carTypeService.getCarTypeById(carTypeId);
        if (carType != null) {
            System.out.println(carType);
        } else {
            System.out.println("Car not found.");
        }
    }

    private static void updateCarType(Scanner scanner) {
        System.out.print("Enter Car Type ID to update Car Type: ");
        int carTypeId = scanner.nextInt();
        scanner.nextLine();

        CarType existingCarType = carTypeService.getCarTypeById(carTypeId);
        if (existingCarType == null) {
            System.out.println("Car type not found.");
            return;
        }

        System.out.print("Enter Type Name (" + existingCarType.getTypeName() + ") or 0 to skip: ");
        String typeName = scanner.nextLine();
        if (typeName.equals("0")) {
            typeName = existingCarType.getTypeName();
        }

        System.out.println("Select Gear Type (" + (existingCarType.isAutomaticGear() ? "Automatic" : "Manual") + ") or 0 to skip:");
        System.out.println("1. Automatic");
        System.out.println("2. Manual");
        boolean automaticGear = existingCarType.isAutomaticGear();
        while (true) {
            System.out.println("Choose (1 or 2): ");
            String choice = scanner.nextLine();
            if (choice.equals("1")) {
                automaticGear = true;
                break;
            } else if (choice.equals("2")) {
                automaticGear = false;
                break;
            } else if (choice.equals("0")) {
                break;
            }
            System.out.println("Invalid choice, try again");
        }

        System.out.println("Select Air Condition (" + (existingCarType.isAirCondition() ? "Yes" : "No") + ") or 0 to skip:");
        System.out.println("1. Yes");
        System.out.println("2. No");
        boolean airCondition = existingCarType.isAirCondition();
        while (true) {
            System.out.println("Choose (1 or 2): ");
            String choice = scanner.nextLine();
            if (choice.equals("1")) {
                airCondition = true;
                break;
            } else if (choice.equals("2")) {
                airCondition = false;
                break;
            } else if (choice.equals("0")) {
                break;
            }
            System.out.println("Invalid choice, try again");
        }

        System.out.println("Select Cruise Control (" + (existingCarType.isCruiseControl() ? "Yes" : "No") + ") or 0 to skip:");
        System.out.println("1. Yes");
        System.out.println("2. No");
        boolean cruiseControl = existingCarType.isCruiseControl();
        while (true) {
            System.out.println("Choose (1 or 2): ");
            String choice = scanner.nextLine();
            if (choice.equals("1")) {
                cruiseControl = true;
                break;
            } else if (choice.equals("2")) {
                cruiseControl = false;
                break;
            } else if (choice.equals("0")) {
                break;
            }
            System.out.println("Invalid choice, try again");
        }

        System.out.println("Select Leather Seats (" + (existingCarType.isLeatherSeats() ? "Yes" : "No") + ") or 0 to skip:");
        System.out.println("1. Yes");
        System.out.println("2. No");
        boolean leatherSeats = existingCarType.isLeatherSeats();
        while (true) {
            System.out.println("Choose (1 or 2): ");
            String choice = scanner.nextLine();
            if (choice.equals("1")) {
                leatherSeats = true;
                break;
            } else if (choice.equals("2")) {
                leatherSeats = false;
                break;
            } else if (choice.equals("0")) {
                break;
            }
            System.out.println("Invalid choice, try again");
        }

        System.out.print("Enter Engine Size (" + existingCarType.getEngineSize() + ") or 0 to skip: ");
        int engineSize = scanner.nextInt();
        scanner.nextLine();
        if (engineSize == 0) {
            engineSize = existingCarType.getEngineSize();
        }

        System.out.print("Enter Horse Power (" + existingCarType.getHorsePower() + ") or 0 to skip: ");
        int horsePower = scanner.nextInt();
        scanner.nextLine();
        if (horsePower == 0) {
            horsePower = existingCarType.getHorsePower();
        }

        System.out.print("Enter Number of Seats (" + existingCarType.getSeats() + ") or 0 to skip: ");
        int seats = scanner.nextInt();
        scanner.nextLine();
        if (seats == 0) {
            seats = existingCarType.getSeats();
        }

        CarType updatedCarType = new CarType(
                carTypeId,
                typeName,
                automaticGear,
                airCondition,
                cruiseControl,
                leatherSeats,
                engineSize,
                horsePower,
                seats
        );

        carTypeService.updateCarType(updatedCarType);
    }

    private static void deleteCarType(Scanner scanner) {
        System.out.print("Enter Car Type Id to delete Car Type: ");
        int carTypeID = scanner.nextInt();
        scanner.nextLine();

        carTypeService.deleteCarType(carTypeID);
    }
}
