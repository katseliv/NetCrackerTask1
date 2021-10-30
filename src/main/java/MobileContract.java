import java.time.LocalDate;

public class MobileContract extends Contract{
    private int numberOfMinutes;
    private int numberOfSMS;
    private int numberOfGB;

    public MobileContract(LocalDate startDate, LocalDate endDate, int contractNumber, Person owner, int numberOfMinutes, int numberOfSMS, int numberOfGB) {
        super(startDate, endDate, contractNumber, owner);
        this.numberOfMinutes = numberOfMinutes;
        this.numberOfSMS = numberOfSMS;
        this.numberOfGB = numberOfGB;
    }

    public int getNumberOfMinutes() {
        return numberOfMinutes;
    }

    public void setNumberOfMinutes(int numberOfMinutes) {
        this.numberOfMinutes = numberOfMinutes;
    }

    public int getNumberOfSMS() {
        return numberOfSMS;
    }

    public void setNumberOfSMS(int numberOfSMS) {
        this.numberOfSMS = numberOfSMS;
    }

    public int getNumberOfGB() {
        return numberOfGB;
    }

    public void setNumberOfGB(int numberOfGB) {
        this.numberOfGB = numberOfGB;
    }
}
