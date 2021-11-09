import contracts.Contract;
import contracts.DigitalTelevisionContract;
import contracts.MobileContract;
import enums.Gender;
import models.Person;
import org.junit.*;
import repositories.Repository;

import java.time.LocalDate;

public class RepositoryTest {
    private static final Person owner = new Person("Ivan", "Ivanovich", "Ivanov",
            LocalDate.of(1990, 3, 3), Gender.MAN, 2010, 877740);
    private static final Contract contract1 = new MobileContract(
            LocalDate.of(2002, 10, 5), LocalDate.of(2004, 9, 15),
            3456, owner, 300, 50, 5);
    private static final Contract contract2 = new DigitalTelevisionContract(
            LocalDate.of(2020, 7, 25), LocalDate.of(2021, 8, 3),
            3457, owner, 300);

    @BeforeClass
    public static void initialization() {
        System.out.println(owner);
        Repository.addContract(contract1);
        Repository.printContracts();
        System.out.println();
    }

    @Test
    public void getContractById() {
        Contract expectedContract = Repository.getContract(contract1.getId());

        System.out.println("Expected: " + expectedContract);
        System.out.println("Actual: " + contract1);

        assert expectedContract != null;
        boolean expected = expectedContract.equals(contract1);
        Assert.assertTrue(expected);
    }

    @Test
    public void addContract() {
        Repository.addContract(contract2);

        Contract expectedContract = Repository.getContract(contract2.getId());
        System.out.println("Expected: " + expectedContract);
        System.out.println("Actual: " + contract2);

        assert expectedContract != null;
        boolean expected = expectedContract.equals(contract2);
        Assert.assertTrue(expected);
    }

    @Test
    public void deleteContract(){
        Repository.deleteContract(contract1.getId());

        Contract expectedContract = Repository.getContract(contract1.getId());
        System.out.println("Expected: " + expectedContract);
        System.out.println("Actual: " + null);

        boolean expected = expectedContract == null;
        Assert.assertTrue(expected);
    }

    @After
    public void print(){
        System.out.println();
        Repository.printContracts();
        System.out.println();
    }
}
