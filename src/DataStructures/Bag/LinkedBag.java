package DataStructures.Bag;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * <p>
 * This implementation of {@code BagAPI} uses a singly linked list
 * with a non-static nested class Node.
 * </p>
 * The <em>add</em>, <em>isEmpty</em>, and <em>size</em> operations take constant time.
 * Iteration takes time proportional to the number of items.
 */
public class LinkedBag<Item> implements BagAPI<Item>, Iterable<Item> {

    private Node first;     // beginning of bag
    private int n;          // size of the bag

    // helper linked list class
    private class Node {
        private Item item;
        private Node next;
    }

    /**
     * Initializes an empty bag.
     */
    public LinkedBag() {
        first = null;
        n = 0;
    }

    public void add(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        n++;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Returns an iterator that iterates over the items in the bag.
     *
     * @return an iterator that iterates over the items in the bag
     */
    public Iterator<Item> iterator() {
        return new LinkedIterator();
    }

    // an iterator over a linked list
    private class LinkedIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

}
