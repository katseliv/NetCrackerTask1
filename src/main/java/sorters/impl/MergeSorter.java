package sorters.impl;

import entities.Contract;
import sorters.Sorter;

import java.util.Comparator;

/**
 * Class sorters.MergeSorter
 *
 * @author Ekaterina Selivanova
 **/
public class MergeSorter implements Sorter {

    @Override
    public void sort(Contract[] contracts, Comparator<Contract> comparator) {
        mergeSort(contracts, contracts.length, comparator);
    }

    private void mergeSort(Contract[] contracts, int length, Comparator<Contract> comparator) {
        if (length < 2) {
            return;
        }
        int middle = length / 2;
        Contract[] leftArray = new Contract[middle];
        Contract[] rightArray = new Contract[length - middle];

        System.arraycopy(contracts, 0, leftArray, 0, middle);
        if (length - middle >= 0) System.arraycopy(contracts, middle, rightArray, 0, length - middle);

        mergeSort(leftArray, middle, comparator);
        mergeSort(rightArray, length - middle, comparator);

        merge(contracts, leftArray, rightArray, middle, length - middle, comparator);
    }

    private void merge(Contract[] contracts, Contract[] leftArray, Contract[] rightArray, int left, int right, Comparator<Contract> comparator) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (comparator.compare(leftArray[i], rightArray[j]) <= 0) {
                contracts[k++] = leftArray[i++];
            }
            else {
                contracts[k++] = rightArray[j++];
            }
        }
        while (i < left) {
            contracts[k++] = leftArray[i++];
        }
        while (j < right) {
            contracts[k++] = rightArray[j++];
        }
    }

}
