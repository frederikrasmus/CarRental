public class CustomerService {
    private CustomerDAO customerDAO;

    //Klasse som validerer en customer før de tilføjes til min database eller slettes eller opdaterers.

    public CustomerService(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public void addCustomer(Customer customer) {
        // Validerer customer data
        if (isValidCustomer(customer)) {
            customerDAO.insertCustomer(customer);
        } else {
            System.out.println("Invalid customer data");
        }
    }

    public Customer getCustomer(String driverLicenseNumber) {
        return customerDAO.getCustomerById(driverLicenseNumber);
    }

    public void updateCustomer(Customer customer) {
        // Validate customer data
        if (isValidCustomer(customer)) {
            customerDAO.updateCustomer(customer);
        } else {
            System.out.println("Invalid customer data");
        }
    }

    public void deleteCustomer(String driverLicenseNumber) {
        customerDAO.deleteCustomer(driverLicenseNumber);
    }

    public boolean isZipValid(String zip) {
        return customerDAO.zipIsValid(zip);
    }

    // Valideringsmetode som sikrer at customer har en valid mail og et navn og efternavn.
    private boolean isValidCustomer(Customer customer) {
        return customer.getEmail().contains("@") &&
                !customer.getFName().isEmpty() && !customer.getLName().isEmpty();
    }
}