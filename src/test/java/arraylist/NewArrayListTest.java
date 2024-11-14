package arraylist;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class NewArrayListTest {

    List<Integer> listStr = new NewArrayList<>();
    List<Integer> list2 = new NewArrayList<>(10);
    List<Integer> list3 = new NewArrayList<>();
    List<Integer> list4 = new NewArrayList<>(Arrays.asList(3, 3, 2, 1, 2, 1000, 1000, -2, -2));


    @Test
    void testSize() {
        assertEquals(0, listStr.size());
        listStr.add(1);
        assertEquals(1, listStr.size());
    }

    @Test
    void testAddAndGet() {
        listStr.add(1);
        listStr.add(2);
        listStr.add(3);
        assertEquals(1, listStr.get(0));
        assertEquals(2, listStr.get(1));
        assertEquals(3, listStr.get(2));
    }

    @Test
    void testRemove() {
        listStr.add(1);
        listStr.add(2);
        listStr.remove(0);
        assertEquals(2, listStr.get(0));
    }

    @Test
    void testOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> listStr.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> listStr.remove(0));
    }

    @Test
    void testAddAllConst() {
        List<String> list = new NewArrayList<>(Arrays.asList("a", "b", "c"));
        assertArrayEquals(new String[]{"a", "b", "c"}, list.toArray());
    }

    @Test
    void testCap() {
        assertEquals(0, list2.size());
        list2.add(1);
        assertEquals(1, list2.size());
    }

    @Test
    void testAddByIndex() {
        list3.add(0,5);
        list3.add(0,6);
        list3.add(0,7);
        assertEquals(3, list3.size());
        assertArrayEquals(new Integer[]{7,6,5}, list3.toArray());

    }

    @Test
    void testClear() {
        list4.clear();
        assertTrue(list4.isEmpty());
        assertEquals( 0, list4.size());
    }

    @Test
    void testSetMethod() {
        ArrayList<String> listStr = new ArrayList<>();
        listStr.add("First");
        listStr.add("Second");
        listStr.set(1, "Updated");
        assertEquals("Updated", listStr.get(1));
        assertEquals(2, listStr.size());
    }

















}
