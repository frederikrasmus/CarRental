public class CarType {

    private int carTypeId;
    private String typeName;
    private boolean automaticGear;
    private boolean airCondition;
    private boolean cruiseControl;
    private boolean leatherSeats;
    private int engineSize;
    private int horsePower;
    private int seats;

    // Konstruktør uden CarTypeId, cartypeId er auto_increment i mit table
    public CarType( String typeName, boolean automaticGear, boolean airCondition, boolean cruiseControl, boolean leatherSeats, int engineSize, int horsePower, int seats) {
        this.typeName = typeName;
        this.automaticGear = automaticGear;
        this.airCondition = airCondition;
        this.cruiseControl = cruiseControl;
        this.leatherSeats = leatherSeats;
        this.engineSize = engineSize;
        this.horsePower = horsePower;
        this.seats = seats;
    }

    // Konstruktør med CarTypeId
    public CarType(int carTypeId, String typeName, boolean automaticGear, boolean airCondition, boolean cruiseControl, boolean leatherSeats, int engineSize, int horsePower, int seats) {
        this.carTypeId = carTypeId;
        this.typeName = typeName;
        this.automaticGear = automaticGear;
        this.airCondition = airCondition;
        this.cruiseControl = cruiseControl;
        this.leatherSeats = leatherSeats;
        this.engineSize = engineSize;
        this.horsePower = horsePower;
        this.seats = seats;
    }

    public int getCarTypeId() {
        return carTypeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public boolean isAutomaticGear() {
        return automaticGear;
    }

    public boolean isAirCondition() {
        return airCondition;
    }

    public boolean isCruiseControl() {
        return cruiseControl;
    }

    public boolean isLeatherSeats() {
        return leatherSeats;
    }

    public int getEngineSize() {
        return engineSize;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public int getSeats() {
        return seats;
    }

    public void setCarTypeId(int carTypeId) {
        this.carTypeId = carTypeId;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public void setAutomaticGear(boolean automaticGear) {
        this.automaticGear = automaticGear;
    }

    public void setAirCondition(boolean airCondition) {
        this.airCondition = airCondition;
    }

    public void setCruiseControl(boolean cruiseControl) {
        this.cruiseControl = cruiseControl;
    }

    public void setLeatherSeats(boolean leatherSeats) {
        this.leatherSeats = leatherSeats;
    }

    public void setEngineSize(int engineSize) {
        this.engineSize = engineSize;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "CarType{" +
                "carTypeId=" + carTypeId +
                ", typeName='" + typeName + '\'' +
                ", automaticGear=" + automaticGear +
                ", airCondition=" + airCondition +
                ", cruiseControl=" + cruiseControl +
                ", leatherSeats=" + leatherSeats +
                ", engineSize=" + engineSize +
                ", horsePower=" + horsePower +
                ", seats=" + seats +
                '}';
    }
}