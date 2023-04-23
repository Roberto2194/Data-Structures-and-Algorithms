package Bag;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * <p>
 * This implementation of {@code BagAPI} uses a resizing array,
 * which doubles the underlying array when it is full.
 * </p>
 * The <em>add</em> operation takes constant amortized time.
 * The <em>isEmpty</em>, and <em>size</em> operations take constant time.
 * Iteration takes time proportional to the number of items.
 */
public class ResizingArrayBag<Item> implements BagAPI<Item>, Iterable<Item> {

    // initial capacity of underlying resizing array
    public static final int INIT_CAPACITY = 8;

    private Item[] b;       // bag elements
    private int N;          // number of elements in bag

    /**
     * Initializes an empty bag.
     */
    public ResizingArrayBag() {
        b = (Item[]) new Object[INIT_CAPACITY];
        N = 0;
    }

    public void add(Item item) {
        if (N == b.length) resize(2 * b.length);
        b[N++] = item;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    // resize the underlying array holding the elements
    private void resize(int capacity) {
        assert capacity >= N;
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < N; i++)
            copy[i] = b[i];
        b = copy;
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
            return i < N;
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return b[i++];
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

        if (bag.isEmpty()) return;
        for (String s : bag) {
            System.out.println(s);
        }
    }

}
