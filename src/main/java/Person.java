import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Person {
    private static int uid = 0;

    private final int id;
    private String firstName;
    private String midName;
    private String lastName;
    private LocalDate birthday;
    private Gender gender;
    private int passportSeries;
    private int passportNumber;
    private int age;

    public Person(String firstName, String midName, String lastName, LocalDate birthday, Gender gender, int passportSeries, int passportNumber) {
        this.id = uid++;
        this.firstName = firstName;
        this.midName = midName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.gender = gender;
        this.passportSeries = passportSeries;
        this.passportNumber = passportNumber;
        this.age = Period.between(birthday, LocalDate.now()).getYears();
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMidName() {
        return midName;
    }

    public void setMidName(String midName) {
        this.midName = midName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
        this.age = Period.between(birthday, LocalDate.now()).getYears();
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getPassportSeries() {
        return passportSeries;
    }

    public void setPassportSeries(int passportSeries) {
        this.passportSeries = passportSeries;
    }

    public int getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(int passportNumber) {
        this.passportNumber = passportNumber;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && gender == person.gender && passportSeries == person.passportSeries && passportNumber == person.passportNumber && age == person.age && firstName.equals(person.firstName) && midName.equals(person.midName) && lastName.equals(person.lastName) && birthday.equals(person.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, midName, lastName, birthday, gender, passportSeries, passportNumber, age);
    }

    @Override
    public String toString() {
        return "Person { " +
                "id = " + id +
                ", firstName = '" + firstName + '\'' +
                ", midName = '" + midName + '\'' +
                ", lastName = '" + lastName + '\'' +
                ", gender = " + gender +
                ", passportSeries = " + passportSeries +
                ", passportNumber = " + passportNumber +
                ", age = " + age +
                " } ";
    }
}
