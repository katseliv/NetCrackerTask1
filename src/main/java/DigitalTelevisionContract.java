import java.time.LocalDate;

public class DigitalTelevisionContract extends Contract{
    private int numberOfChannels;

    public DigitalTelevisionContract(LocalDate startDate, LocalDate endDate, int contractNumber, Person owner, int numberOfChannels) {
        super(startDate, endDate, contractNumber, owner);
        this.numberOfChannels = numberOfChannels;
    }

    public int getNumberOfChannels() {
        return numberOfChannels;
    }

    public void setNumberOfChannels(int numberOfChannels) {
        this.numberOfChannels = numberOfChannels;
    }
}
