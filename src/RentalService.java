import java.util.ArrayList;

public class RentalService {

    private RentalDAO rentalDAO;

    public RentalService(RentalDAO rentalDAO) {
        this.rentalDAO = rentalDAO;
    }

    public void addRental(Rental rental) {
        if (isValidRental(rental)) {
            rentalDAO.insertRental(rental);
        } else {
            System.out.println("Invalid rental data");
        }
    }

    public Rental getRentalById(int rentalId) {
        return rentalDAO.getRentalById(rentalId);
    }

    public void updateCarType(Rental rental) {
        if (isValidRental(rental)) {
            rentalDAO.updateRental(rental);
        } else {
            System.out.println("Invalid rental data");
        }
    }

    public void deleteRental(int rentalID) {
        rentalDAO.deleteRental(rentalID);
    }

    private boolean isValidRental(Rental rental) {
        return !rental.getRegistrationNumber().isEmpty() && !rental.getDriverlicenseNumber().isEmpty();
    }
}
