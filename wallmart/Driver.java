
public class Driver{
    Long DriverId;
    DriverStatus driverStatus;
    Long currentFare;
    Long lattitude;
    Long longitude;
    Long ridesCompleted;

// driver - waiting, driving, booked, completedRide, inactive
//  driverId, currentFare, status, lat, long

    public Long getDriverId() {
        return DriverId;
    }

    public DriverStatus getDriverStatus() {
        return driverStatus;
    }

    public Long getCurrentFare() {
        return currentFare;
    }

    public Long getLattitude() {
        return lattitude;
    }

    public Long getLongitude() {
        return longitude;
    }

    public Long getRidesCompleted() {
        return ridesCompleted;
    }
}