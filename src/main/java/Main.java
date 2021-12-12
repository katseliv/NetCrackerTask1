import entities.Contract;
import entities.DigitalTelevisionContract;
import entities.Person;
import enums.Gender;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Person owner = new Person("Ivan", "Ivanovich", "Ivanov",
                LocalDate.of(1990, 3, 3), Gender.MAN, 2010, 877740);
        Contract contract3 = new DigitalTelevisionContract(
                LocalDate.of(2020, 7, 25), LocalDate.of(2021, 8, 3),
                400, owner, 300);
        System.out.println(contract3);
    }

}
