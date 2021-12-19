package services;

import annotations.AutoInjectable;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import entities.*;
import enums.Gender;
import enums.Status;
import repositories.Repository;
import validators.IValidator;
import validators.impl.ContractNumberValidator;
import validators.impl.DateValidator;
import validators.impl.PersonValidator;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Class services.CSVService
 *
 * @author Ekaterina Selivanova
 **/
public class CSVService {
    /**
     * Field list of validators
     **/
    @AutoInjectable
    private final List<IValidator> validators = new ArrayList<>();

    /**
     * Constructor - creation new object without values
     **/
    public CSVService() {
        validators.add(new DateValidator());
        validators.add(new PersonValidator());
        validators.add(new ContractNumberValidator());
    }

    /**
     * Function reading csv-file and adding contract to repository
     *
     * @param repository - repository
     * @param csvFile - name of csv-file
     **/
    public void readCSVFile(Repository repository, String csvFile) {
        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(csvFile));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            String[] nextLine;
            if (reader != null) {
                while ((nextLine = reader.readNext()) != null) {
                    parseString(repository, nextLine);
                }
            }
        } catch (CsvException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Function parsing one string of csv-file and adding contract to repository
     *
     * @param repository - repository
     * @param nextLine - line of csv-file
     **/
    public void parseString(Repository repository, String[] nextLine) {
        try {
            int contractNumber = Integer.parseInt(nextLine[0]);
            LocalDate startDate = LocalDate.parse(nextLine[1], DateTimeFormatter.ofPattern("yyyy-MM-d"));
            LocalDate endDate = LocalDate.parse(nextLine[2], DateTimeFormatter.ofPattern("yyyy-MM-d"));
            String[] name = nextLine[3].split(" ");
            String lastName = name[0];
            String firstName = name[1];
            String midName = name[2];
            Gender gender;
            if (Objects.equals(nextLine[4], "MAN")) {
                gender = Gender.MAN;
            } else {
                gender = Gender.WOMAN;
            }
            LocalDate birthday = LocalDate.parse(nextLine[5], DateTimeFormatter.ofPattern("yyyy-MM-d"));
            String[] passport = nextLine[6].split(" ");
            int passportSeries = Integer.parseInt(passport[0]);
            int passportNumber = Integer.parseInt(passport[1]);

            Class<?> clazz = Class.forName(nextLine[7]);
            Constructor<?> constructor;
            Contract contract;
            Person owner = new Person(firstName, midName, lastName, birthday, gender, passportSeries, passportNumber);

            String[] parameters = nextLine[8].split("\\|");
            int number = Integer.parseInt(parameters[0]);

            if (clazz == DigitalTelevisionContract.class || clazz == WiredInternetContract.class) {
                constructor = clazz.getConstructor(LocalDate.class, LocalDate.class,
                        int.class, Person.class, int.class);
                contract = (Contract) constructor.newInstance(startDate, endDate, contractNumber,
                        owner, number);
            } else {
                int numberOfSMS = Integer.parseInt(parameters[1]);
                int numberOfGB = Integer.parseInt(parameters[2]);

                constructor = clazz.getConstructor(LocalDate.class, LocalDate.class,
                        int.class, Person.class, int.class, int.class, int.class);
                contract = (Contract) constructor.newInstance(startDate, endDate, contractNumber,
                        owner, number, numberOfSMS, numberOfGB);
            }

            boolean allMatch = validators.stream()
                    .map(v -> v.validate(contract))
                    .allMatch(vm -> vm.getStatus() == Status.OK);

            if (allMatch) {
                repository.addContract(contract);
            }

        } catch (NumberFormatException | DateTimeException | ClassNotFoundException | NoSuchMethodException |
                InvocationTargetException | InstantiationException | IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Function writing contract from repository into csv-file
     *
     * @param repository - repository
     * @param csvFile - name of csv-file
     **/
    public void writeToCSV(Repository repository, String csvFile) {
        try {
            CSVWriter writer = new CSVWriter(new FileWriter(csvFile));
            for (int i = 0; i < repository.getNumberOfContracts(); i++) {
                Contract contract = repository.getContractByIndex(i);
                if (contract != null) {
                    String[] record = contract.toString().split(";");
                    writer.writeNext(record);
                }
            }
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
