package repositories;

import entities.Contract;
import sorters.BubbleSorter;
import sorters.Sorter;

import java.util.Comparator;
import java.util.function.Predicate;

/**
 * Class repositories.Repository
 * @author Ekaterina Selivanova
 **/
public class Repository {
    private Predicate<Contract> SEARCH_BY_ID = (a) -> a.getId() == 1;
    private Sorter sorter =  new BubbleSorter();
    /** Field contracts contains contracts**/
    private Contract[] contracts = new Contract[100];
    /** Field numberOfContracts counts number of contracts**/
    private int numberOfContracts = 0;

    /**
     * Function getting contract by id
     * @param id - id of contract
     * @return return contract
     **/
    public Contract getContract(int id) {
        for (Contract contract : contracts) {
            if (contract != null && contract.getId() == id) {
                return contract;
            }
        }
        return null;
    }

    /**
     * Function adding contract
     * @param contract - contract
     **/
    public void addContract(Contract contract) {
        numberOfContracts++;
        if (numberOfContracts > contracts.length) {
            expandArray();
        }
        contracts[numberOfContracts - 1] = contract;
    }

    /**
     * Function deleting contract by id
     * @param id - id of contract
     **/
    public void deleteContract(int id) {
        numberOfContracts--;
        shiftArrayValues(id);
    }

    /**
     * Function expanding array
     **/
    private void expandArray() {
        Contract[] temp = contracts.clone();
        contracts = new Contract[contracts.length * 2];
        System.arraycopy(temp, 0, contracts, 0, contracts.length);
    }

    /**
     * Function shifting array values
     * @param id - show from what place starts shifting
     **/
    private void shiftArrayValues(int id) {
        int start = findContract(id);
        if (start == -1){
            return;
        }

        for (int i = start; i < numberOfContracts + 1; i++) {
            contracts[id] = contracts[id + 1];
        }
    }

    /**
     * Function finding value by id
     * @param id - id of contract
     * @return id of contract if contract was found
     **/
    private int findContract(int id) {
        for (int i = 0; i < contracts.length; i++) {
            if (contracts[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public Repository search(Predicate<Contract> condition){
        return new Repository();
    }

    public Repository sort(Comparator<Contract> comparator){
        sorter.sort(contracts, comparator);
    }

    /**
     * Function printing all contracts
     **/
    public void printContracts(){
        System.out.println("Contracts {");
        for (int i = 0; i < numberOfContracts; i++) {
            System.out.println(contracts[i]);
        }
        System.out.println("}");
    }
}
