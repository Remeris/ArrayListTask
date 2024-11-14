package arraylist;

import java.util.Comparator;

/**
 * Provides static methods for sorting instances of {@link NewArrayList} using
 * the QuickSort algorithm.
 *
 * <p>QuickSort is a sorting algorithm that uses a divide-and-conquer strategy
 * to sort an array. It does so by selecting a pivot element and then sorting
 * values larger than it on one side and smaller to the other side, and then
 * it repeats those steps until the array is sorted. It is useful for sorting
 * big data sets.
 *
 *@author Nick Stepanov
 */
class QuickSort {


    /**
     * Sorts the given list using the QuickSort algorithm.
     *
     * @param list the NewArrayList<T> to be sorted
     * @param <T>  the type of elements in the list, which must be comparable
     */
    public static <T extends Comparable<T>> void quickSort(NewArrayList<T> list) {
        sortHelp(list, 0, list.size() - 1, Comparator.naturalOrder());
    }

    /**
     * Helper method that recursively sorts the sublist of the given list
     * between the specified indices using QuickSort.
     *
     * @param list     the NewArrayList<T> to be sorted
     * @param from     the starting index of the sublist
     * @param to       the ending index of the sublist
     * @param comparator the Comparator used for ordering the elements
     * @param <T>      the type of elements in the list
     */
    private static <T> void sortHelp(NewArrayList<T> list, int from, int to, Comparator<? super T> comparator) {
        if (from < to) {
            int pivotIndex = partition(list, from, to, comparator);
            sortHelp(list, from, pivotIndex - 1, comparator);
            sortHelp(list, pivotIndex + 1, to, comparator);
        }
    }

    /**
     * Partitions the sublist of the given list and returns the index
     * of the pivot element after partitioning.
     *
     * @param list     the NewArrayList<T> being partitioned
     * @param low      the starting index of the sublist
     * @param high     the ending index of the sublist
     * @param comparator the Comparator used for comparing elements
     * @param <T>      the type of elements in the list
     * @return the index of the pivot element
     */
    private static <T> int partition(NewArrayList<T> list, int low, int high, Comparator<? super T> comparator) {
        T pivot = list.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (comparator.compare(list.get(j), pivot) <= 0) {
                i++;
                swap(list, i, j);
            }
        }
        swap(list, i + 1, high);
        return i + 1;
    }

    /**
     * Swaps two elements in the given NewArrayList<T> at the specified indices.
     *
     * @param list the NewArrayList<T> in which elements will be swapped
     * @param i    the index of the first element
     * @param j    the index of the second element
     * @param <T>  the type of elements in the list
     */
    private static <T> void swap(NewArrayList<T> list, int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}



