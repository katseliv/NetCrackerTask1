import entities.Contract;
import entities.DigitalTelevisionContract;
import entities.MobileContract;
import enums.Gender;
import entities.Person;
import org.junit.*;
import repositories.Repository;

import java.time.LocalDate;
import java.util.function.Predicate;

public class RepositoryTest {
    private static final Repository repository = new Repository();
    private static final Person owner = new Person("Ivan", "Ivanovich", "Ivanov",
            LocalDate.of(1990, 3, 3), Gender.MAN, 2010, 877740);
    private static final Contract contract1 = new MobileContract(
            LocalDate.of(2002, 10, 5), LocalDate.of(2004, 9, 15),
            3456, owner, 300, 50, 5);
    private static final Contract contract2 = new DigitalTelevisionContract(
            LocalDate.of(2020, 7, 25), LocalDate.of(2021, 8, 3),
            3457, owner, 300);
    private static final Contract contract3 = new DigitalTelevisionContract(
            LocalDate.of(2020, 7, 25), LocalDate.of(2021, 8, 3),
            400, owner, 300);

    @BeforeClass
    public static void initialization() {
        System.out.println(owner);
        repository.addContract(contract1);
        repository.printContracts();
        System.out.println();
    }

    @Test
    public void getContractById() {
        Contract expectedContract = repository.getContract(contract1.getId());

        System.out.println("Expected: " + expectedContract);
        System.out.println("Actual: " + contract1);

        assert expectedContract != null;
        boolean expected = expectedContract.equals(contract1);
        Assert.assertTrue(expected);
    }

    @Test
    public void addContract() {
        repository.addContract(contract2);

        Contract expectedContract = repository.getContract(contract2.getId());
        System.out.println("Expected: " + expectedContract);
        System.out.println("Actual: " + contract2);

        assert expectedContract != null;
        boolean expected = expectedContract.equals(contract2);
        Assert.assertTrue(expected);
    }

    @Test
    public void deleteContract(){
        repository.deleteContract(contract1.getId());

        Contract expectedContract = repository.getContract(contract1.getId());
        System.out.println("Expected: " + expectedContract);
        System.out.println("Actual: " + null);

        boolean expected = expectedContract == null;
        Assert.assertTrue(expected);
    }

    @Test
    public void searchContracts(){
        repository.addContract(contract3);

        repository.search(a -> a.getContractNumber() >= 1000);

        for(Contract contract : ){

        }
    }

    @After
    public void print(){
        System.out.println();
        repository.printContracts();
        System.out.println();
    }
}
