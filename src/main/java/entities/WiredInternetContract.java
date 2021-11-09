package entities;

import java.time.LocalDate;

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
}
