package sorters.impl;

import entities.Contract;
import sorters.Sorter;

import java.util.Comparator;

/**
 * Class sorters.BubbleSorter
 *
 * @author Ekaterina Selivanova
 **/
public class BubbleSorter implements Sorter {

    @Override
    public void sort(Contract[] contracts, Comparator<Contract> comparator) {
        int n = contracts.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (comparator.compare(contracts[j], contracts[j + 1]) >= 0) {
                    Contract temp = contracts[j];
                    contracts[j] = contracts[j + 1];
                    contracts[j + 1] = temp;
                }
            }
        }
    }

}
