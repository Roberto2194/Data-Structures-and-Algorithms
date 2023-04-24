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
    private int N;          // number of elements in queue
    private int first;      // index of first element in the queue
    private int last;       // index of the next available slot

    /**
     * Initializes an empty queue.
     */
    public ResizingArrayQueue() {
        q = (Item[]) new Object[INIT_CAPACITY];
        N = 0;
        first = 0;
        last = 0;
    }

    public void enqueue(Item item) {
        if (N == q.length) resize(q.length * 2);    // double the size of the array if necessary
        q[last++] = item;                                   // add item
        if (last == q.length) last = 0;                     // wrap-around
        N++;
    }

    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("DataStructures.Queue underflow");
        Item item = q[first];                                           // save the item to return
        q[first] = null;                                                // to avoid loitering
        first++;
        N--;
        if (first == q.length) first = 0;                               // wrap-around
        if (N > 0 && N == q.length / 4) resize(q.length / 2);   // shrink the size of the array if necessary
        return item;                                                    // return the saved item
    }

    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("DataStructures.Queue underflow");
        return q[first];
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    // resize the underlying array holding the elements
    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < N; i++)
            copy[i] = q[(first + i) % q.length];
        q = copy;
        first = 0;
        last = N;
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
            return i < N;
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = q[(i + first) % q.length];
            i++;
            return item;
        }
    }

    /**
     * Unit test the {@code ResizingArrayQueue} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        ResizingArrayQueue<Integer> queue = new ResizingArrayQueue<>();
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(5);
        queue.enqueue(7);
        queue.enqueue(11);

        System.out.println("dequeuing the first element of the queue = " + queue.dequeue());
        System.out.println("peeking the first element of the queue = " + queue.peek());
        System.out.println("size of queue = " + queue.size());

        if (queue.isEmpty()) return;
        for (int i : queue) {
            System.out.println(i);
        }
    }

}
