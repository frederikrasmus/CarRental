import java.time.LocalDate;
import java.util.Date;

public class Car {
    //Fields i Car klassen
    private String registrationNumber;
    private String brand;
    private String model;
    private String fuelType;
    private LocalDate firstRegistrationDate;
    private int odometer;
    private int carTypeId;

    //Konstruktør til instansering.
    public Car(String registrationNumber, String brand, String model,
               String fuelType, LocalDate firstRegistrationDate, int odometer, int carTypeId) {
        this.registrationNumber = registrationNumber;
        this.brand = brand;
        this.model = model;
        this.fuelType = fuelType;
        this.firstRegistrationDate = firstRegistrationDate;
        this.odometer = odometer;
        this.carTypeId = carTypeId;
    }
    //Getter metoder
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getFuelType() {
        return fuelType;
    }

    public LocalDate getFirstRegistrationDate() {
        return firstRegistrationDate;
    }

    public int getOdometer() {
        return odometer;
    }

    public int getCarTypeId() {
        return carTypeId;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public void setFirstRegistrationDate(LocalDate firstRegistrationDate) {
        this.firstRegistrationDate = firstRegistrationDate;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    public void setCarTypeId(int carTypeId) {
        this.carTypeId = carTypeId;
    }

    //To String metode
    @Override
    public String toString() {
        return
                "RegistrationNumber: " + registrationNumber + '\n' +
                "Brand: " + brand + '\n' +
                "Model: " + model + '\n' +
                "FuelType: " + fuelType + '\n' +
                "First Registration Date: " + firstRegistrationDate + '\n' +
                "Odometer: " + odometer + '\n' +
                "CarTypeId: " + carTypeId + '\n';
    }
}
