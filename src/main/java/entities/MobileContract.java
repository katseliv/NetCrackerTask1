package entities;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Class contracts.MobileContract
 * @autor Ekaterina Selivanova
 */
public class MobileContract extends Contract {
    /** Field numberOfMinutes means number of minutes**/
    private int numberOfMinutes;
    /** Field numberOfSMS means number of SMS**/
    private int numberOfSMS;
    /** Field numberOfGB means number of GB of the traffic**/
    private int numberOfGB;

    /**
     * Constructor - creation new object with values
     * @param startDate - start date of the contract
     * @param endDate - end date of the contract
     * @param contractNumber - number of the contract
     * @param owner - owner of the contract
     * @param numberOfMinutes - number of minutes
     * @param numberOfSMS - number of SMS
     * @param numberOfGB - number of GB of the traffic
     **/
    public MobileContract(LocalDate startDate, LocalDate endDate, int contractNumber, Person owner, int numberOfMinutes, int numberOfSMS, int numberOfGB) {
        super(startDate, endDate, contractNumber, owner);
        this.numberOfMinutes = numberOfMinutes;
        this.numberOfSMS = numberOfSMS;
        this.numberOfGB = numberOfGB;
    }

    /**
     * Function getting number of minutes
     * @return return number of minutes
     **/
    public int getNumberOfMinutes() {
        return numberOfMinutes;
    }

    /**
     * Function setting number of minutes
     **/
    public void setNumberOfMinutes(int numberOfMinutes) {
        this.numberOfMinutes = numberOfMinutes;
    }

    /**
     * Function getting number of SMS
     * @return return number of SMS
     **/
    public int getNumberOfSMS() {
        return numberOfSMS;
    }

    /**
     * Function setting number of SMS
     **/
    public void setNumberOfSMS(int numberOfSMS) {
        this.numberOfSMS = numberOfSMS;
    }

    /**
     * Function getting number of GB of the traffic
     * @return return number of GB of the traffic
     **/
    public int getNumberOfGB() {
        return numberOfGB;
    }

    /**
     * Function setting number of GB of the traffic
     **/
    public void setNumberOfGB(int numberOfGB) {
        this.numberOfGB = numberOfGB;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MobileContract)) return false;
        if (!super.equals(o)) return false;
        MobileContract that = (MobileContract) o;
        return getNumberOfMinutes() == that.getNumberOfMinutes() && getNumberOfSMS() == that.getNumberOfSMS() && getNumberOfGB() == that.getNumberOfGB();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getNumberOfMinutes(), getNumberOfSMS(), getNumberOfGB());
    }

    @Override
    public String toString() {
        return  super.toString() + ";" +
                this.getClass().getName() + ";" +
                numberOfMinutes + "|" +
                numberOfSMS + "|" +
                numberOfGB + ";";
    }
}
