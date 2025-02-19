import java.time.LocalDate;
import java.util.Date;

public class Customer {


    private String driverLicenseNumber;
    private String fName;
    private String lName;
    private String address;
    private City city;
    private String mobilePhone;
    private String email;
    private LocalDate driverSinceDate;


    public Customer(String driverLicenseNumber, String fName, String lName, String address, City city, String mobilePhone, String email, LocalDate driverSinceDate) {
        this.driverLicenseNumber = driverLicenseNumber;
        this.fName = fName;
        this.lName = lName;
        this.address = address;
        this.city = city;
        this.mobilePhone = mobilePhone;
        this.email = email;
        this.driverSinceDate = driverSinceDate;
    }


    public String getDriverLicenseNumber() {
        return driverLicenseNumber;
    }


    public String getFName() {
        return fName;
    }

    public String getLName() {
        return lName;
    }


    public String getAddress() {
        return address;
    }


    public City getCity() {
        return city;
    }


    public String getPhoneNumber() {
        return mobilePhone;
    }


    public String getEmail() {
        return email;
    }


    public LocalDate getDriverSinceDate() {
        return driverSinceDate;
    }


    public void setDriverLicenseNumber(String driverLicenseNumber) {
        this.driverLicenseNumber = driverLicenseNumber;
    }


    public void setFName(String fName) {
        this.fName = fName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }


    public void setAddress(String address) {
        this.address = address;
    }


    public void setCity(City city) {
        this.city = city;
    }


    public void setPhoneNumber(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public void setDriverSinceDate(LocalDate driverSinceDate) {
        this.driverSinceDate = driverSinceDate;
    }


    @Override
    public String toString() {
        return
                "DriverLicenseNumber: " + driverLicenseNumber + '\n' +
                        "Name: " + fName + " " + lName + '\n' +
                        "Address: " + address + '\n' +
                        "City: " + city + '\n' +
                        "PhoneNumber: " + mobilePhone + '\n' +
                        "Email: " + email + '\n' +
                        "DriverSinceDate: " + driverSinceDate + '\n';
    }
}
