
public class Driver {

    private Long DriverId;
    private DriverStatus driverStatus;
    private Long currentFare;
    private Long lattitude;
    private Long longitude;
    private Long ridesCompleted;

    public Driver(Long DriverId, DriverStatus driverStatus, Long currentFare, Long lattitude, Long longitude, Long ridesCompleted) {
        this.DriverId = DriverId;
        this.driverStatus = driverStatus;
        this.currentFare = currentFare;
        this.lattitude = lattitude;
        this.longitude = longitude;
        this.ridesCompleted = ridesCompleted;
    }
    

    public Long getDriverId() {
        return this.DriverId;
    }

    public void setDriverId(Long DriverId) {
        this.DriverId = DriverId;
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

    public Long getRidesCompleted() {
        return this.ridesCompleted;
    }

    public void setRidesCompleted(Long ridesCompleted) {
        this.ridesCompleted = ridesCompleted;
    }

}
