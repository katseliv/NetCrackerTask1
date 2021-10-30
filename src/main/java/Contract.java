
import java.time.LocalDate;
import java.util.Objects;

public class Contract {
    private static int cid = 0;

    private final int id;
    private LocalDate startDate;
    private LocalDate endDate;
    private int contractNumber;
    private Person owner;

    public Contract(LocalDate startDate, LocalDate endDate, int contractNumber, Person owner) {
        this.id = cid++;
        this.startDate = startDate;
        this.endDate = endDate;
        this.contractNumber = contractNumber;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(int contractNumber) {
        this.contractNumber = contractNumber;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contract contract = (Contract) o;
        return id == contract.id && contractNumber == contract.contractNumber && startDate.equals(contract.startDate) && endDate.equals(contract.endDate) && owner.equals(contract.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startDate, endDate, contractNumber, owner);
    }

    @Override
    public String toString() {
        return "Contract { " +
                "id = " + id +
                ", startDate = " + startDate +
                ", endDate = " + endDate +
                ", contractNumber = " + contractNumber +
                ", owner = " + owner +
                " } ";
    }
}
