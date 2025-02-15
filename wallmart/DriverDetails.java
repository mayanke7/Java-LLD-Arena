
import java.sql.Timestamp;

public class DriverDetails{
    private Timestamp currentTime;
    private Driver driver;

    public DriverDetails(Timestamp currentTime, Driver driver) {
        this.currentTime = currentTime;
        this.driver = driver;
    }

    public Timestamp getCurrentTime() {
        return currentTime;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setCurrentTime(Timestamp currentTime) {
        this.currentTime = currentTime;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
    
}