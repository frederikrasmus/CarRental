public class City {


    private String zip;
    private String city;


    public City(String zip, String city) {
        this.zip = zip;
        this.city = city;
    }


    public String getZip() {
        return zip;
    }


    public String getCityName() {
        return city;
    }


    public void setZip(String zip) {
        this.zip = zip;
    }


    public void setCityName(String cityName) {
        this.city = cityName;
    }


    @Override
    public String toString() {
        return zip + " " + city;
    }
}
