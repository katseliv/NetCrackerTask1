package sorters;

import entities.Contract;

import java.util.Comparator;

/**
 * Interface sorters.Sorter
 * @author Ekaterina Selivanova
 **/
public interface Sorter {
    /**
     * Function sorting contracts
     *
     * @param contracts - contracts
     * @param comparator - comparator
     **/
    void sort(Contract[] contracts, Comparator<Contract> comparator);
}
