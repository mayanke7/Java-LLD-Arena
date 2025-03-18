
import java.sql.Timestamp;

public class DriverDetails{
    private Timestamp currentTime;
    private Driver driver;
    private DriverStatus driverStatus;
    private Long currentFare;
    private Long lattitude;
    private Long longitude;

    public DriverDetails(){
        
    }

    public DriverDetails(Timestamp currentTime, Driver driver, DriverStatus driverStatus, Long currentFare, Long lattitude, Long longitude) {
        this.currentTime = currentTime;
        this.driver = driver;
        this.driverStatus = driverStatus;
        this.currentFare = currentFare;
        this.lattitude = lattitude;
        this.longitude = longitude;
    }

    public Timestamp getCurrentTime() {
        return this.currentTime;
    }

    public void setCurrentTime(Timestamp currentTime) {
        this.currentTime = currentTime;
    }

    public Driver getDriver() {
        return this.driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public DriverStatus getDriverStatus() {
        return this.driverStatus;
    }

    public void setDriverStatus(DriverStatus driverStatus) {
        this.driverStatus = driverStatus;
    }

    public Long getCurrentFare() {
        return this.currentFare;
    }

    public void setCurrentFare(Long currentFare) {
        this.currentFare = currentFare;
    }

    public Long getLattitude() {
        return this.lattitude;
    }

    public void setLattitude(Long lattitude) {
        this.lattitude = lattitude;
    }

    public Long getLongitude() {
        return this.longitude;
    }

    public void setLongitude(Long longitude) {
        this.longitude = longitude;
    }
    
    
}