package arraylist;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class QuickSortTest {

    private final NewArrayList<Integer> emptyList = new NewArrayList<>();
    private final NewArrayList<Integer> sortedList = new NewArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 10, 100, 101));
    private final NewArrayList<Integer> unsortedList = new NewArrayList<>(Arrays.asList(100,5, 3, 50, 4, 1, 2, 0));
    private final NewArrayList<Integer> duplicateList = new NewArrayList<>(Arrays.asList(3, 3, 2, 1, 2, 1000, 1000, -2, -2));

    private final NewArrayList<String> emptyStringList = new NewArrayList<>();
    private final NewArrayList<String> unsortedStringList = new NewArrayList<>(Arrays.asList("B", "C", "A"));
    private final NewArrayList<String> sortedStringList = new NewArrayList<>(Arrays.asList("A", "B", "C"));
    private final NewArrayList<String> duplicateStringList = new NewArrayList<>(Arrays.asList("A", "B", "C","A"));

    private final NewArrayList<String> sortedStringNamesList = new NewArrayList<>(Arrays.asList("andy", "april", "john","sara"));
    private final NewArrayList<String> unsortedStringNamesList = new NewArrayList<>(Arrays.asList("john", "andy", "sara","april"));
    private final NewArrayList<String> duplicateStringNamesList = new NewArrayList<>(Arrays.asList("john", "andy", "sara","april", "andy"));

    @Test
    void testEmptyList() {
        QuickSort.quickSort(emptyList);
        assertEquals(0, emptyList.size());
    }

    @Test
    void testSortedList() {
        QuickSort.quickSort(sortedList);
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 10, 100, 101}, sortedList.toArray());
    }

    @Test
    void testUnsortedList() {
        QuickSort.quickSort(unsortedList);
        assertArrayEquals(new Integer[]{0, 1, 2, 3, 4, 5, 50, 100}, unsortedList.toArray());
    }

    @Test
    void testDuplicateList() {
        QuickSort.quickSort(duplicateList);
        assertArrayEquals(new Integer[]{-2, -2, 1, 2, 2, 3, 3, 1000, 1000}, duplicateList.toArray());
    }

    @Test
    void testEmptyStringList() {
        QuickSort.quickSort(emptyStringList);
        assertEquals(0, emptyStringList.size());
    }

    @Test
    void testUnsortedStringList() {
        QuickSort.quickSort(unsortedStringList);
        assertArrayEquals(new String[]{"A", "B", "C"}, unsortedStringList.toArray());
    }

    @Test
    void testSortedStringList() {
        QuickSort.quickSort(sortedStringList);
        assertArrayEquals(new String[]{"A", "B", "C"}, sortedStringList.toArray());
    }

    @Test
    void testDuplicateStringList() {
        QuickSort.quickSort(duplicateStringList);
        assertArrayEquals(new String[]{"A", "A", "B", "C"}, duplicateStringList.toArray());
    }

    @Test
    void testSortedStringNamesList() {
        QuickSort.quickSort(sortedStringNamesList);
        assertArrayEquals(new String[]{"andy", "april", "john","sara"}, sortedStringNamesList.toArray());
    }

    @Test
    void testUnsortedStringNamesList() {
        QuickSort.quickSort(unsortedStringNamesList);
        assertArrayEquals(new String[]{"andy", "april", "john","sara"}, unsortedStringNamesList.toArray());
    }

    @Test
    void testDuplicateStringNamesList() {
        QuickSort.quickSort(duplicateStringNamesList);
        assertArrayEquals(new String[]{"andy","andy", "april", "john","sara"}, duplicateStringNamesList.toArray());
    }
}
