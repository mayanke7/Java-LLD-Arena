
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DriverManager{
    List<DriverDetails> driverDetailsList= new ArrayList<>();

    public Long calculateTotalRevenue(){
        Timestamp timestamp = Timestamp.valueOf("2024-02-24 00:00:00");

        return driverDetailsList.parallelStream()
        .filter(driver -> driver.getCurrentTime().after(timestamp))
        .filter(driver -> driver.getDriverStatus() == DriverStatus.COMPLETEDRIDE)
        .mapToLong(driver -> driver.getCurrentFare() != null ? driver.getCurrentFare() : 0L)
        .sum();
    }

    public Long totalCompletedRide(){
        Timestamp timestamp = Timestamp.valueOf("2024-02-24 00:00:00");
        return driverDetailsList.parallelStream()
                .filter(driver -> driver.getCurrentTime().after(timestamp))
                .filter(driver -> driver.getDriverStatus() == DriverStatus.COMPLETEDRIDE)
                .count();
    }

   
    public Long countActiveDrivers() {
        Set<Long> countedDrivers = new HashSet<>();
        long activeCount = 0;

        for (int i = driverDetailsList.size() - 1; i >= 0; i--) {
            DriverDetails driver = driverDetailsList.get(i);
            long driverId = driver.getDriver().getDriverId();
            if (countedDrivers.contains(driverId)) {
                continue;
            }

            if (driver.getDriverStatus() == DriverStatus.BOOKED ||
                driver.getDriverStatus() == DriverStatus.WAITING_FOR_MATCH ||
                driver.getDriverStatus() == DriverStatus.DRIVING) 
                {
                    activeCount++;
                    countedDrivers.add(driverId); 
            }
        }

        return activeCount;
    }



    public static void main(String ags[]){ 
        
    }
}