package entities;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Class contracts.WiredInternetContract
 * @autor Ekaterina Selivanova
 */
public class WiredInternetContract extends Contract {

    /** Field connectionSpeed means connection speed**/
    private int connectionSpeed;

    /**
     * Constructor - creation new object with values
     * @param startDate - start date of the contract
     * @param endDate - end date of the contract
     * @param contractNumber - number of the contract
     * @param owner - owner of the contract
     * @param connectionSpeed - connection speed
     **/
    public WiredInternetContract(LocalDate startDate, LocalDate endDate, int contractNumber, Person owner, int connectionSpeed) {
        super(startDate, endDate, contractNumber, owner);
        this.connectionSpeed = connectionSpeed;
    }

    /**
     * Function getting connection speed
     * @return return connection speed
     **/
    public int getConnectionSpeed() {
        return connectionSpeed;
    }

    /**
     * Function setting connection speed
     **/
    public void setConnectionSpeed(int connectionSpeed) {
        this.connectionSpeed = connectionSpeed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WiredInternetContract)) return false;
        if (!super.equals(o)) return false;
        WiredInternetContract that = (WiredInternetContract) o;
        return getConnectionSpeed() == that.getConnectionSpeed();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getConnectionSpeed());
    }

    @Override
    public String toString() {
        return  super.toString() + ";" +
                this.getClass().getName() + ";" +
                connectionSpeed + ";";
    }

}
