package entities;

import enums.Gender;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

/**
 * Class entities.Person
 * @author Ekaterina Selivanova
 **/
public class Person {
    /** Field uid generating id for objects**/
    private static int uid = 0;

    /** Field id related to object**/
    private final int id;
    /** Field firstName means first name of person**/
    private String firstName;
    /** Field midName means middle name of person**/
    private String midName;
    /** Field lastName means last name of person**/
    private String lastName;
    /** Field birthday means birthday of person**/
    private LocalDate birthday;
    /** Field gender means gender of person**/
    private Gender gender;
    /** Field passportSeries means series of passport**/
    private int passportSeries;
    /** Field passportNumber means number of passport**/
    private int passportNumber;
    /** Field age means age of person**/
    private int age;

    /**
     * Constructor - creation new object with values
     * @param firstName - first name of person
     * @param midName - middle name of person
     * @param lastName - last name of person
     * @param birthday - birthday of person
     * @param gender - gender of person
     * @param passportSeries - series of passport
     * @param passportNumber - number of passport
     **/
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

    /**
     * Function getting id
     * @return return id
     **/
    public int getId() {
        return id;
    }

    /**
     * Function getting first name
     * @return return first name
     **/
    public String getFirstName() {
        return firstName;
    }

    /**
     * Function setting first name
     **/
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Function getting middle name
     * @return return middle name
     **/
    public String getMidName() {
        return midName;
    }

    /**
     * Function setting middle name
     **/
    public void setMidName(String midName) {
        this.midName = midName;
    }

    /**
     * Function getting last name
     * @return return last name
     **/
    public String getLastName() {
        return lastName;
    }

    /**
     * Function setting last name
     **/
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Function getting birthday
     * @return return birthday
     **/
    public LocalDate getBirthday() {
        return birthday;
    }

    /**
     * Function setting birthday
     **/
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
        this.age = Period.between(birthday, LocalDate.now()).getYears();
    }

    /**
     * Function getting gender
     * @return return gender
     **/
    public Gender getGender() {
        return gender;
    }

    /**
     * Function setting gender
     **/
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     * Function getting series of passport
     * @return return series of passport
     **/
    public int getPassportSeries() {
        return passportSeries;
    }

    /**
     * Function setting series of passport
     **/
    public void setPassportSeries(int passportSeries) {
        this.passportSeries = passportSeries;
    }

    /**
     * Function getting number of passport
     * @return return number of passport
     **/
    public int getPassportNumber() {
        return passportNumber;
    }

    /**
     * Function setting number of passport
     **/
    public void setPassportNumber(int passportNumber) {
        this.passportNumber = passportNumber;
    }

    /**
     * Function getting age
     * @return return age
     **/
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
        return "entities.Person { " +
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
