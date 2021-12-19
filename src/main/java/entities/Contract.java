package entities;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Class contracts.Contract
 * @author Ekaterina Selivanova
 **/
public class Contract {
    /** Field cid generating id for objects**/
    private static int cid = 0;

    /** Field id related to object**/
    private final int id;
    /** Field startDate means start date of the contract**/
    private LocalDate startDate;
    /** Field endDate means end date of the contract**/
    private LocalDate endDate;
    /** Field contractNumber means number of the contract**/
    private int contractNumber;
    /** Field owner means owner of the contract**/
    private Person owner;

    /**
     * Constructor - creation new object with values
     * @param startDate - start date of the contract
     * @param endDate - end date of the contract
     * @param contractNumber - number of the contract
     * @param owner - owner of the contract
     **/
    public Contract(LocalDate startDate, LocalDate endDate, int contractNumber, Person owner) {
        this.id = cid++;
        this.startDate = startDate;
        this.endDate = endDate;
        this.contractNumber = contractNumber;
        this.owner = owner;
    }

    /**
     * Function getting id
     * @return return id
     **/
    public int getId() {
        return id;
    }

    /**
     * Function getting start date
     * @return return start date
     **/
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * Function setting start date
     **/
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    /**
     * Function getting end date
     * @return return end date
     **/
    public LocalDate getEndDate() {
        return endDate;
    }

    /**
     * Function setting end date
     **/
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    /**
     * Function getting contract number
     * @return return contract number
     **/
    public int getContractNumber() {
        return contractNumber;
    }

    /**
     * Function setting contract number
     **/
    public void setContractNumber(int contractNumber) {
        this.contractNumber = contractNumber;
    }

    /**
     * Function getting owner
     * @return return owner
     **/
    public Person getOwner() {
        return owner;
    }

    /**
     * Function setting owner
     **/
    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public static boolean nonNull(Contract contract) {
        return contract != null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contract contract = (Contract) o;
        return  contractNumber == contract.contractNumber && startDate.equals(contract.startDate)
                && endDate.equals(contract.endDate) && owner.equals(contract.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startDate, endDate, contractNumber, owner);
    }

    @Override
    public String toString() {
        return  contractNumber + ";" +
                startDate + ";" +
                endDate + ";" +
                owner;
    }
}
