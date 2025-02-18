import java.time.LocalDate;
import java.util.Scanner;

public class CustomerUI {
    private static CustomerService customerService = new CustomerService(new CustomerDAO(new Database()));

    public static void manageCustomers(Scanner scanner) {
        boolean running = true;

        while (running) {
            System.out.println("Manage Customers");
            System.out.println("1. Add Customer");
            System.out.println("2. View Customer");
            System.out.println("3. Update Customer");
            System.out.println("4. Delete Customer");
            System.out.println("5. Back to Main Menu");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addCustomer(scanner);
                    break;
                case 2:
                    viewCustomer(scanner);
                    break;
                case 3:
                    // Update customer logic
                    break;
                case 4:
                    // Delete customer logic
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addCustomer(Scanner scanner) {
        System.out.print("Enter Driver License Number: ");
        String driverLicenseNumber = scanner.nextLine();

        System.out.print("Enter First Name: ");
        String fName = scanner.nextLine();

        System.out.print("Enter Last Name: ");
        String lName = scanner.nextLine();

        System.out.print("Enter Address: ");
        String address = scanner.nextLine();

        System.out.print("Enter Zip: ");
        String zip = scanner.nextLine();

        System.out.print("Enter Mobile Phone: ");
        String mobilePhone = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter Driver Since Date (YYYY-MM-DD): ");
        String driverSinceDate = scanner.nextLine();

        Customer customer = new Customer(driverLicenseNumber, fName, lName, address, new City(zip, ""), mobilePhone, email, LocalDate.parse(driverSinceDate));
        customerService.addCustomer(customer);
    }

    private static void viewCustomer(Scanner scanner) {
        System.out.println("Enter Driver License Number to find Customer");
        String dln = scanner.nextLine();

        System.out.println(customerService.getCustomer(dln));
    }

    private static void updateCustomer(Scanner scanner) {

    }

}