import entities.Contract;
import entities.DigitalTelevisionContract;
import entities.MobileContract;
import enums.Gender;
import entities.Person;
import org.junit.*;
import repositories.Repository;

import java.time.LocalDate;
import java.util.Comparator;
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
        Contract expectedContract = repository.getContractById(contract1.getId());

        System.out.println("Expected: " + expectedContract);
        System.out.println("Actual: " + contract1);

        assert expectedContract != null;
        boolean expected = expectedContract.equals(contract1);
        Assert.assertTrue(expected);
    }

    @Test
    public void addContract() {
        repository.addContract(contract2);

        Contract expectedContract = repository.getContractById(contract2.getId());
        System.out.println("Expected: " + expectedContract);
        System.out.println("Actual: " + contract2);

        assert expectedContract != null;
        boolean expected = expectedContract.equals(contract2);
        Assert.assertTrue(expected);
    }

    @Test
    public void deleteContract() {
        repository.deleteContract(contract1.getId());

        Contract expectedContract = repository.getContractById(contract1.getId());
        System.out.println("Expected: " + expectedContract);
        System.out.println("Actual: " + null);

        boolean expected = expectedContract == null;
        Assert.assertTrue(expected);
    }

    @Test
    public void searchContracts() {
        repository.addContract(contract3);

        Predicate<Contract> condition = a -> (a.getContractNumber() >= 1000);
        Repository actualRepository = repository.search(condition);

        int n = 1;
        for (int i = 0; i < actualRepository.getNumberOfContracts(); i++) {
            boolean condition2 = actualRepository.getContractById(i).getContractNumber() < 1000;
            if (condition2) {
                n = 0;
            }
        }

        Assert.assertEquals(1, n);
    }

    @Test
    public void sortContracts() {
        repository.addContract(contract2);
        repository.addContract(contract3);

        Repository actualRepository = repository.sort(Comparator.nullsLast(Comparator.comparingInt(Contract::getContractNumber)));

        int n = 1;
        for (int i = 0; i < actualRepository.getNumberOfContracts() - 1; i++) {
            int condition = actualRepository.getContractByIndex(i).getContractNumber()
                    - actualRepository.getContractByIndex(i + 1).getContractNumber();
            if (condition > 0) {
                n = 0;
            }
        }

        Assert.assertEquals(1, n);
    }

    @After
    public void print() {
        System.out.println();
        repository.printContracts();
        System.out.println();
    }
}
