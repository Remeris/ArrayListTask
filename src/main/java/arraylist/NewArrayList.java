package arraylist;


import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Resizable-array realization of the {@code AbstractList} interface. Implements
 * all optional AbstractList operations, and permits all elements, including
 * this class provides methods to manipulate the size of the array that is
 * used internally to store the list.
 *
 * <p>The {@code size}, {@code get}, {@code set},operations run in constant
 * time.The {@code add} operation runs in <i>amortized constant time</i>,
 * that is, adding n elements requires O(n) time. All the other operations
 * run in linear time.
 *
 *
 * @param <E> the type of elements in this list
 *
 * @author Nick Stepanov
 */


public class NewArrayList<E> extends AbstractList<E>{

    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] EMPTY_ELEMENTDATA = {};
    Object[] elements;
    private int size;


    /**
     * Constructs an empty list with an initial capacity.
     */
    public NewArrayList() {
        this.elements = EMPTY_ELEMENTDATA;
    }

    /**
     * Constructs a list containing the elements of the specified collection,
     * in the order they are returned by the collection's iterator.
     *
     * @param c the collection whose elements are to be placed into this list
     */
    public NewArrayList(Collection<? extends E> c) {
        Object[] a = c.toArray();
        size = a.length;
        if (size != 0) {
            elements = Arrays.copyOf(a, size, Object[].class);
        } else {
            elements = EMPTY_ELEMENTDATA;
        }
    }


    /**
     * Constructs a list with the specified initial capacity.
     *
     * @param  initialCapacity  the initial capacity of the list
     * @throws IllegalArgumentException if the specified initial capacity
     *         is negative
     */
    public NewArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elements = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elements = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: "+
                    initialCapacity);
        }
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index the index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @SuppressWarnings("unchecked")
    @Override
    public E get(int index) {
        checkIndex(index);
        return (E) elements[index];
    }

    /**
     * Adds the specified element to the end of this list.
     *
     * @param e element to be appended to this list
     * @return {@code true} (as specified by {@link Collection#add}).
     */
    @Override
    public boolean add(E e) {
        if (size == elements.length)
            elements = ensureCapacity();
        elements[size] = e;
        size++;
        return true;
    }


    /**
     * Inserts the specified element at the specified position in this
     * list. Shifts the element currently at that position (if any) and
     * any subsequent elements to the right (adds one to their indices).
     *
     * @param index index at which the specified element is to be inserted
     * @param e element to be inserted
     * @throws IndexOutOfBoundsException if the index is out if range {@code index < 0 || index > size()}
     */
    @Override
    public void add(int index, E e) {
        checkIndex(index);
        final int s = size ;
        Object[] elData;
        elData = this.elements;
        if (s == elData.length)
            elData = ensureCapacity();
        System.arraycopy(elData, index, elData, index + 1, s - index);
        elData[index] = e;
        size = s + 1;
    }

    //метод увеличения размера коллекции
    private Object[] ensureCapacity() {
        return grow(size + 1);
    }

    //вспомогательный метод для увеличения размера коллеции
    private Object[] grow(int minCapacity) {
        int oldCapacity = elements.length;
        if (oldCapacity > 0 || elements != EMPTY_ELEMENTDATA) {
            int newCapacity = oldCapacity + (oldCapacity /2);
            return elements = Arrays.copyOf(elements, newCapacity);
        }else {
            return elements = new Object[Math.max(DEFAULT_CAPACITY, minCapacity)];
        }
    }

    /**
     * Removes the element at the specified position in this list.
     * Shifts any subsequent elements to the left (subtracts one from their
     * indices).
     *
     * @param index the index of the element to be removed
     * @return the element that was removed from the list
     * @throws IndexOutOfBoundsException if the index is out if range {@code index < 0 || index > size()}
     */
    @Override
    public E remove(int index) {
        checkIndex(index);
        E oldValue = get(index);
        final int removeNum = size - 1;
        if (removeNum > index)
            System.arraycopy(elements, index + 1, elements, index, removeNum - index);
        elements[--size] = null;
        return oldValue;
    }
    /**
     * Removes all the elements from this list.  The list will
     * be empty after this call returns.
     */
    @Override
    public void clear() {
        final Object[] es = elements;
        for (int to = size, i = size = 0; i < to; i++)
            es[i] = null;
    }


    /**
     * Replaces the element at the specified position in this list with
     * the specified element.
     *
     * @param index index of the element to replace
     * @param e element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException if the index is out if range {@code index < 0 || index > size()}
     */
    @Override
    public E set(int index, E e) {
        checkIndex(index);
        elements[index] = e;
        return e;
    }


    /**
     *
     * @param  index index of the element to comparison
     *
     @throws IndexOutOfBoundsException if the index is out if range {@code index < 0 || index > size()}
     */
    //метод checkIndex принимает индекс элемента и выбрасывает исключение в случаях если:
    // индекс меньше нуля или индекс превышает размер коллекции
    private void checkIndex(int index) {
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("Индекс обращения: " + index + ", Размер коллекции " + size);
        }
    }

}
