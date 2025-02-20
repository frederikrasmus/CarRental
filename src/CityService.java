public class CityService {

    private CityDAO cityDAO;

    public CityService(CityDAO cityDAO) {
        this.cityDAO = cityDAO;
    }

    public void addCity(City city) {
        if (isValidCity(city)) {
            cityDAO.insertCity(city);
            System.out.println("City added successfully");
        } else {
            System.out.println("Invalid city data");
        }
    }

    public boolean isValidCity(City city) {
        return !city.getZip().isEmpty() && !city.getCityName().isEmpty();
    }
}
