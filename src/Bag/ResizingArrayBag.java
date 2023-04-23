package Bag;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayBag<Item> implements Iterable<Item>, BagAPI<Item> {
    // initial capacity of underlying resizing array
    public static final int INIT_CAPACITY = 8;

    private Item[] a;       // array of items
    private int n;          // number of elements in bag

    /**
     * Initializes an empty bag.
     */
    public ResizingArrayBag() {
        a = (Item[]) new Object[INIT_CAPACITY];
        n = 0;
    }

    public void add(Item item) {
        if (n == a.length) resize(2 * a.length);
        a[n++] = item;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    // resize the underlying array holding the elements
    private void resize(int capacity) {
        assert capacity >= n;
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++)
            copy[i] = a[i];
        a = copy;
    }

    /**
     * Returns an iterator that iterates over the items in the bag in arbitrary order.
     *
     * @return an iterator that iterates over the items in the bag in arbitrary order
     */
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    // an array iterator
    private class ArrayIterator implements Iterator<Item> {
        private int i = 0;

        public boolean hasNext() {
            return i < n;
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return a[i++];
        }
    }

    /**
     * Unit test the {@code ResizingArrayBag} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        ResizingArrayBag<String> bag = new ResizingArrayBag<>();
        bag.add("Hello");
        bag.add("World");

        System.out.println("size of bag = " + bag.size());

        for (String s : bag) {
            System.out.println(s);
        }
    }

}
