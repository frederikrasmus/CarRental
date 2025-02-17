public class CarType {

    private int carTypeId;
    private String typeName;
    private boolean automaticGear;
    private boolean aircondition;
    private boolean cruisecontrol;
    private boolean leatherseats;
    private int engineSize;
    private int horsepower;
    private int seats;

    public CarType(int carTypeId, String typeName, boolean automaticGear, boolean aircondition, boolean cruisecontrol, boolean leatherseats, int engineSize, int horsepower, int seats) {
        this.carTypeId = carTypeId;
        this.typeName = typeName;
        this.automaticGear = automaticGear;
        this.aircondition = aircondition;
        this.cruisecontrol = cruisecontrol;
        this.leatherseats = leatherseats;
        this.engineSize = engineSize;
        this.horsepower = horsepower;
        this.seats = seats;
    }

    public int getCarTypeId() {
        return carTypeId;
    }

    public String gettypeName() {
        return typeName;
    }

    public boolean isAutomaticGear() {
        return automaticGear;
    }

    public boolean isAircondition() {
        return aircondition;
    }

    public boolean isCruisecontrol() {
        return cruisecontrol;
    }

    public boolean isLeatherseats() {
        return leatherseats;
    }

    public int getEngineSize() {
        return engineSize;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public int getSeats() {
        return seats;
    }

    public void setCarTypeId(int carTypeId) {
        this.carTypeId = carTypeId;
    }

    public void setVarChar(String typeName) {
        this.typeName = typeName;
    }

    public void setAutomaticGear(boolean automaticGear) {
        this.automaticGear = automaticGear;
    }

    public void setAircondition(boolean aircondition) {
        this.aircondition = aircondition;
    }

    public void setCruisecontrol(boolean cruisecontrol) {
        this.cruisecontrol = cruisecontrol;
    }

    public void setLeatherseats(boolean leatherseats) {
        this.leatherseats = leatherseats;
    }

    public void setEngineSize(int engineSize) {
        this.engineSize = engineSize;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "CarType{" +
                "carTypeId=" + carTypeId +
                ", varChar='" + typeName + '\'' +
                ", automaticGear=" + automaticGear +
                ", aircondition=" + aircondition +
                ", cruisecontrol=" + cruisecontrol +
                ", leatherseats=" + leatherseats +
                ", engineSize=" + engineSize +
                ", horsepower=" + horsepower +
                ", seats=" + seats +
                '}';
    }
}
