import java.time.LocalDate;
import java.util.Scanner;

public class CustomerUI {
    private static Database db = Database.getInstance();
    private static CustomerService customerService = new CustomerService(new CustomerDAO(db));


    public static void manageCustomers(Scanner scanner) {
        boolean running = true;

        while (running) {
            System.out.println("Manage Customers");
            System.out.println("1. Add Customer");
            System.out.println("2. View Customer");
            System.out.println("3. Update Customer");
            System.out.println("4. Delete Customer");
            System.out.println("5. Add City");
            System.out.println("6. Back to Main Menu");
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
                    updateCustomer(scanner);
                    break;
                case 4:
                   deleteCustomer(scanner);
                    break;
                case 5:
                    CityUI.manageCities(scanner);
                    break;
                case 6:
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

        String zip;
        while(true) {
            System.out.print("Enter Zip: ");
            zip = scanner.nextLine();

            if (customerService.isZipValid(zip)) {
                break;
            } else {
                System.out.println("Invalid zip. Please enter valid zip Code");
            }
        }


        System.out.print("Enter Mobile Phone: ");
        String mobilePhone = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter Driver Since Date (YYYY-MM-DD): ");
        String driverSinceDate = scanner.nextLine();

        Customer customer = new Customer(driverLicenseNumber, fName, lName, address, new City(zip, ""),
                mobilePhone, email, LocalDate.parse(driverSinceDate));
        customerService.addCustomer(customer);
    }

    private static void viewCustomer(Scanner scanner) {
        System.out.println("Enter Driver License Number to find Customer");
        String dln = scanner.nextLine();

        System.out.println(customerService.getCustomer(dln));
    }

    private static void updateCustomer(Scanner scanner) {
        System.out.println("Enter Driver License Number to update Customer");
        String dln = scanner.nextLine();

        Customer customer = customerService.getCustomer(dln);
        if(customer == null) {
            System.out.println("Customer not found");
            return;
        }

        System.out.println("Enter First Name (" + customer.getFName() + ") or 0 to skip: ");
        String fName = scanner.nextLine();
        if(fName.equals("0")) {
            fName = customer.getFName();
        }

        System.out.println("Enter Last Name (" + customer.getLName() + ") or 0 to skip:  ");
        String lName = scanner.nextLine();
        if(lName.equals("0")) {
            lName = customer.getLName();
        }

        System.out.println("Enter Address (" + customer.getAddress() + ") or 0 to skip: ");
        String address = scanner.nextLine();
        if(address.equals("0")) {
            address = customer.getAddress();
        }

        System.out.println("Enter Zip (" + customer.getCity().getZip() + ") or 0 to skip: ");
        String zip = scanner.nextLine();
        if(zip.equals("0")) {
            zip = customer.getCity().getZip();
        }

        System.out.println("Enter Phone Number (" + customer.getPhoneNumber() + ") or 0 to skip: ");
        String mobilePhone = scanner.nextLine();
        if(mobilePhone.equals("0")) {
            mobilePhone = customer.getPhoneNumber();
        }

        System.out.println("Enter Email (" + customer.getEmail() + ") or 0 to skip: ");
        String email = scanner.nextLine();
        if(email.equals("0")) {
            email = customer.getEmail();
        }

        System.out.println("Enter Driver Since Date (" + customer.getDriverSinceDate() + ") " +
                "(YYYY-MM-DD) or 0 to skip: ");
        String driverSinceDate = scanner.nextLine();
        LocalDate driverSinceDateParsed;
        if(driverSinceDate.equals("0")) {
            driverSinceDateParsed = customer.getDriverSinceDate();
        } else {
            driverSinceDateParsed = LocalDate.parse(driverSinceDate);
        }

        Customer updatedCustomer = new Customer(dln,fName,lName,address,new City(zip, ""),
                mobilePhone,email,driverSinceDateParsed);

        customerService.updateCustomer(updatedCustomer);
    }

    private static void deleteCustomer(Scanner scanner) {
        System.out.println("Enter Driver License Number to delete Customer");
        String dln = scanner.nextLine();

        customerService.deleteCustomer(dln);
    }

}