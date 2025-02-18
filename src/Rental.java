import java.time.LocalDateTime;

public class Rental {

    private int rentalId;
    private LocalDateTime fromDateTime;
    private LocalDateTime toDateTime;
    private int maxKm;
    private int startOdometer;
    private String registrationNumber;
    private String driverlicenseNumber;

    // Constructor without rentalId
    public Rental(LocalDateTime fromDateTime, LocalDateTime toDateTime, int maxKm, int startOdometer, String registrationNumber, String driverlicenseNumber) {
        this.fromDateTime = fromDateTime;
        this.toDateTime = toDateTime;
        this.maxKm = maxKm;
        this.startOdometer = startOdometer;
        this.registrationNumber = registrationNumber;
        this.driverlicenseNumber = driverlicenseNumber;
    }

    // Constructor with rentalId
    public Rental(int rentalId, LocalDateTime fromDateTime, LocalDateTime toDateTime, int maxKm, int startOdometer, String registrationNumber, String driverlicenseNumber) {
        this.rentalId = rentalId;
        this.fromDateTime = fromDateTime;
        this.toDateTime = toDateTime;
        this.maxKm = maxKm;
        this.startOdometer = startOdometer;
        this.registrationNumber = registrationNumber;
        this.driverlicenseNumber = driverlicenseNumber;
    }

    public int getRentalId() {
        return rentalId;
    }

    public LocalDateTime getFromDateTime() {
        return fromDateTime;
    }

    public LocalDateTime getToDateTime() {
        return toDateTime;
    }

    public int getMaxKm() {
        return maxKm;
    }

    public int getStartOdometer() {
        return startOdometer;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getDriverlicenseNumber() {
        return driverlicenseNumber;
    }

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }

    public void setFromDateTime(LocalDateTime fromDateTime) {
        this.fromDateTime = fromDateTime;
    }

    public void setToDateTime(LocalDateTime toDateTime) {
        this.toDateTime = toDateTime;
    }

    public void setMaxKm(int maxKm) {
        this.maxKm = maxKm;
    }

    public void setStartOdometer(int startOdometer) {
        this.startOdometer = startOdometer;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public void setDriverlicenseNumber(String driverlicenseNumber) {
        this.driverlicenseNumber = driverlicenseNumber;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "rentalId=" + rentalId +
                ", fromDateTime=" + fromDateTime +
                ", toDateTime=" + toDateTime +
                ", maxKm=" + maxKm +
                ", startOdometer=" + startOdometer +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", driverlicenseNumber='" + driverlicenseNumber + '\'' +
                '}';
    }
}