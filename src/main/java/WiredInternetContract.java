import java.time.LocalDate;

public class WiredInternetContract extends Contract{
    private int connectionSpeed;

    public WiredInternetContract(LocalDate startDate, LocalDate endDate, int contractNumber, Person owner, int connectionSpeed) {
        super(startDate, endDate, contractNumber, owner);
        this.connectionSpeed = connectionSpeed;
    }

    public int getConnectionSpeed() {
        return connectionSpeed;
    }

    public void setConnectionSpeed(int connectionSpeed) {
        this.connectionSpeed = connectionSpeed;
    }
}
