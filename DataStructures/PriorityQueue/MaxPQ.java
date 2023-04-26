package DataStructures.PriorityQueue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This implementation of {@code MaxPriorityQueueAPI} uses a <em>Binary Heap</em>.
 * The <em>insert</em> and <em>delMax</em> operations take
 * &Theta;(log <em>n</em>) amortized time, where <em>n</em> is the number
 * of elements in the priority queue. This is an amortized bound
 * (and not a worst-case bound) because of array resizing operations.
 * The <em>min</em>, <em>size</em>, and <em>isEmpty</em> operations take
 * &Theta;(1) time in the worst case.
 * Construction takes time proportional to the specified capacity or the
 * number of items used to initialize the data structure.
 * <p>
 */
public class MaxPQ<Key> implements Iterable<Key>, MaxPriorityQueueAPI<Key> {
    private Key[] pq;                    // store items at indices 1 to n
    private int n;                       // number of items on priority queue

    /**
     * Initializes an empty priority queue.
     */
    public MaxPQ() {
        this(1);
    }

    /**
     * Initializes an empty priority queue with the given initial capacity.
     *
     * @param MaxN the initial capacity of this priority queue
     */
    public MaxPQ(int MaxN) {
        pq = (Key[]) new Object[MaxN + 1];
        n = 0;
    }

    /**
     * Initializes a priority queue from the array of keys.
     * Takes time proportional to the number of keys, using sink-based heap construction.
     *
     * @param keys the array of keys
     */
    public MaxPQ(Key[] keys) {
        n = keys.length;
        pq = (Key[]) new Object[keys.length + 1];
        for (int i = 0; i < n; i++)
            pq[i + 1] = keys[i];
        for (int k = n / 2; k >= 1; k--)
            sink(k);
    }

    /**
     * Adds a new key to this priority queue.
     *
     * @param v the new key to add to this priority queue
     */
    public void insert(Key v) {
        // double size of array if necessary
        if (n == pq.length - 1) resize(2 * pq.length);

        // add v, and percolate it up to maintain heap invariant
        pq[++n] = v;
        swim(n);
    }

    /**
     * Removes and returns a largest key on this priority queue.
     *
     * @return a largest key on this priority queue
     * @throws NoSuchElementException if this priority queue is empty
     */
    public Key delMax() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        Key max = pq[1];      // retrieve max key from top
        swap(1, n--);       // exchange with last item
        pq[n + 1] = null;     // to avoid loitering and help with garbage collection
        sink(1);           // restore heap property
        if ((n > 0) && (n == (pq.length - 1) / 4)) resize(pq.length / 2); // halves size of array if necessary
        return max;
    }

    /**
     * Returns (but does not remove) the largest key on this priority queue.
     *
     * @return the largest key on this priority queue
     * @throws NoSuchElementException if this priority queue is empty
     */
    public Key max() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        return pq[1];
    }

    /**
     * Returns true if this priority queue is empty.
     *
     * @return {@code true} if this priority queue is empty;
     * {@code false} otherwise
     */
    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * Returns the number of keys on this priority queue.
     *
     * @return the number of keys on this priority queue
     */
    public int size() {
        return n;
    }

    // resize the underlying array to have the given capacity
    private void resize(int capacity) {
        Key[] temp = (Key[]) new Object[capacity];
        for (int i = 1; i <= n; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }

    /***************************************************************************
     * Helper functions to restore the heap invariant.
     ***************************************************************************/

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            swap(k / 2, k);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(j, j + 1)) j++;
            if (!less(k, j)) break;
            swap(k, j);
            k = j;
        }
    }

    /***************************************************************************
     * Helper functions for compares and swaps.
     ***************************************************************************/

    private boolean less(int i, int j) {
        return ((Comparable<Key>) pq[i]).compareTo(pq[j]) < 0;
    }

    private void swap(int i, int j) {
        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

    /**
     * Returns an iterator that iterates over the keys on this priority queue
     * in descending order.
     *
     * @return an iterator that iterates over the keys in descending order
     */
    public Iterator<Key> iterator() {
        return new HeapIterator();
    }

    private class HeapIterator implements Iterator<Key> {
        // create a new pq
        private MaxPQ<Key> copy;

        // add all items to copy of heap
        // takes linear time since already in heap order so no keys move
        public HeapIterator() {
            copy = new MaxPQ<>(size());
            for (int i = 1; i <= n; i++)
                copy.insert(pq[i]);
        }

        public boolean hasNext() {
            return !copy.isEmpty();
        }

        public Key next() {
            if (!hasNext()) throw new NoSuchElementException();
            return copy.delMax();
        }
    }

}
