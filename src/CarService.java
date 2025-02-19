public class CarService {

    private CarDAO carDAO;

    public CarService(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    public void addCar(Car car) {
        // Validerer car data
        if (isValidCar(car)) {
            carDAO.insertCar(car);
            System.out.println("Car added successfully");
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
            System.out.println("Car updated successfully");
        } else {
            System.out.println("Invalid car data");
        }
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
