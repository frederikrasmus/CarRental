import java.util.ArrayList;

public class CarService {

    private CarDAO carDAO;

    public CarService(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    // Denne klasse fungerer som bindeled mellem min DAO og min UI.
    public void addCar(Car car) {
        // Validerer car data og tilføjer
        if (isValidCar(car)) {
            carDAO.insertCar(car);
        } else {
            System.out.println("Invalid customer data");
        }
    }

    public Car getCar(String registrationNumber) {
        return carDAO.getCarByRegNr(registrationNumber);
    }

    public void updateCar(Car car) {
        if (isValidCar(car)) {
            carDAO.updateCar(car);
        } else {
            System.out.println("Invalid car data");
        }
    }

    public ArrayList<Car> getAllCars() {
        return carDAO.getAllCars();
    }

    public void deleteCar(String registrationNumber) {
        carDAO.deleteCar(registrationNumber);
        System.out.println("Car deleted successfully");
    }

    // Valideringsmetode som sikrer at car har et registreringsnummer, et brand og en model.
    private boolean isValidCar(Car car) {
        return !car.getRegistrationNumber().isEmpty() &&
                !car.getBrand().isEmpty() && !car.getModel().isEmpty();
    }
}
