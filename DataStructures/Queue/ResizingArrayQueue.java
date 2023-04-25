package DataStructures.Queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * <p>
 * This implementation of {@code QueueAPI} uses a resizing array,
 * which doubles the underlying array when it is full
 * and halves the underlying array when it is one quarter full.
 * </p>
 * The <em>enqueue</em> and <em>dequeue</em> operations take constant amortized time.
 * The <em>size</em>, <em>peek</em>, and <em>isEmpty</em> operations take constant time.
 * Iteration takes time proportional to the number of items.
 */
public class ResizingArrayQueue<Item> implements QueueAPI<Item>, Iterable<Item> {

    // initial capacity of underlying resizing array
    public static final int INIT_CAPACITY = 8;

    private Item[] q;       // queue elements
    private int n;          // number of elements in queue
    private int first;      // index of first element in the queue
    private int last;       // index of the next available slot

    /**
     * Initializes an empty queue.
     */
    public ResizingArrayQueue() {
        q = (Item[]) new Object[INIT_CAPACITY];
        n = 0;
        first = 0;
        last = 0;
    }

    public void enqueue(Item item) {
        if (n == q.length) resize(q.length * 2);    // double the size of the array if necessary
        q[last++] = item;                                   // add item
        if (last == q.length) last = 0;                     // wrap-around
        n++;
    }

    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = q[first];                                           // save the item to return
        q[first] = null;                                                // to avoid loitering
        first++;
        n--;
        if (first == q.length) first = 0;                               // wrap-around
        if (n > 0 && n == q.length / 4) resize(q.length / 2);   // shrink the size of the array if necessary
        return item;                                                    // return the saved item
    }

    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return q[first];
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    // resize the underlying array holding the elements
    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++)
            copy[i] = q[(first + i) % q.length];
        q = copy;
        first = 0;
        last = n;
    }

    /**
     * Returns an iterator that iterates through the items in this queue FIFO order.
     *
     * @return an iterator that iterates through the items in this queue in FIFO order
     */
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    // an array iterator, from first to last-1
    private class ArrayIterator implements Iterator<Item> {
        private int i = 0;

        public boolean hasNext() {
            return i < n;
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = q[(i + first) % q.length];
            i++;
            return item;
        }
    }

}
