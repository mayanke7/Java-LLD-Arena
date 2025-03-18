
public class Driver {

    private Long DriverId;
    private String DriverName;
    
    public Driver(Long DriverId, String DriverName) {
        this.DriverId = DriverId;
        this.DriverName = DriverName;
    }

    public Long getDriverId() {
        return this.DriverId;
    }

    public void setDriverId(Long DriverId) {
        this.DriverId = DriverId;
    }

    public String getDriverName() {
        return this.DriverName;
    }

    public void setDriverName(String DriverName) {
        this.DriverName = DriverName;
    }
    

}
