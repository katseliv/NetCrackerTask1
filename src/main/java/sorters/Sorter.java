package sorters;

import entities.Contract;

import java.util.Comparator;

public interface Sorter {

    public void sort(Contract[] contracts, Comparator<Contract> comparator);

}
