import java.util.ArrayList;
import java.util.List;

public class CarTypeService {
    private CarTypeDAO carTypeDAO;

    public CarTypeService(CarTypeDAO carTypeDAO) {
        this.carTypeDAO = carTypeDAO;
    }

    public void addCarType(CarType carType) {
        if (isValidCarType(carType)) {
            carTypeDAO.insertCarType(carType);
            System.out.println("Car type added successfully");
        } else {
            System.out.println("Invalid car type data");
        }
    }

    public CarType getCarTypeById(int carTypeId) {
        return carTypeDAO.getCarTypeById(carTypeId);
    }

    public void updateCarType(CarType carType) {
        if (isValidCarType(carType)) {
            carTypeDAO.updateCarType(carType);
            System.out.println("Car type updated successfully");
        } else {
            System.out.println("Invalid car type data");
        }
    }

    public void deleteCarType(int carTypeId) {
        carTypeDAO.deleteCarType(carTypeId);
        System.out.println("Car type deleted successfully");
    }

    public ArrayList<CarType> getAllCarTypes() {
        return carTypeDAO.getAllCarTypes();
    }

    private boolean isValidCarType(CarType carType) {
        return !carType.getTypeName().isEmpty();
    }
}