import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        LoadingScreen.loadingScreen();
        Database db = Database.getInstance();

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
                    RentalUI.manageRentals(scanner);
                    break;
                case 3:
                    CarUI.manageCars(scanner);
                    break;
                case 4:
                    CarTypeUI.manageCarTypes(scanner);
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Please try again");
            }
        }
        scanner.close();
        db.closeConnection();
    }
}



