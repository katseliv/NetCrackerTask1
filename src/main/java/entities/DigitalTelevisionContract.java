package entities;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Class contracts.DigitalTelevisionContract
 * @author Ekaterina Selivanova
 **/
public class DigitalTelevisionContract extends Contract {

    /** Field numberOfChannels means number of channels**/
    private int numberOfChannels;

    /**
     * Constructor - creation new object with values
     * @param startDate - start date of the contract
     * @param endDate - end date of the contract
     * @param contractNumber - number of the contract
     * @param owner - owner of the contract
     * @param numberOfChannels - number of the channels
     **/
    public DigitalTelevisionContract(LocalDate startDate, LocalDate endDate, int contractNumber, Person owner, int numberOfChannels) {
        super(startDate, endDate, contractNumber, owner);
        this.numberOfChannels = numberOfChannels;
    }

    /**
     * Function getting number of channels
     * @return return number of channels
     **/
    public int getNumberOfChannels() {
        return numberOfChannels;
    }

    /**
     * Function setting number of channels
     **/
    public void setNumberOfChannels(int numberOfChannels) {
        this.numberOfChannels = numberOfChannels;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DigitalTelevisionContract)) return false;
        if (!super.equals(o)) return false;
        DigitalTelevisionContract that = (DigitalTelevisionContract) o;
        return getNumberOfChannels() == that.getNumberOfChannels();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getNumberOfChannels());
    }

    @Override
    public String toString() {
        return  super.toString() + ";" +
                this.getClass().getName() + ";" +
                numberOfChannels + ";";
    }

}
