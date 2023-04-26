package DataStructures.PriorityQueue;

import java.util.NoSuchElementException;

/**
 * The {@code MaxPriorityQueueAPI} interface represents a priority queue of generic keys.
 * It supports the usual <em>insert</em> and <em>delete-the-maximum</em>
 * operations, along with methods for peeking at the maximum key,
 * testing if the priority queue is empty, and iterating through the keys.
 */
public interface MaxPriorityQueueAPI<Key> {
    /**
     * Adds a new key to this priority queue.
     *
     * @param v the key to add to this priority queue
     */
    void insert(Key v);

    /**
     * Returns (but does not remove) the largest key on this priority queue.
     *
     * @return the largest key on this priority queue
     * @throws NoSuchElementException if this priority queue is empty
     */
    Key delMax();

    /**
     * Removes and returns a largest key on this priority queue.
     *
     * @return a largest key on this priority queue
     * @throws NoSuchElementException if this priority queue is empty
     */
    Key max();

    /**
     * Returns the number of keys on this priority queue.
     *
     * @return the number of keys on this priority queue
     */
    int size();

    /**
     * Returns true if this priority queue is empty.
     *
     * @return {@code true} if this priority queue is empty;
     * {@code false} otherwise
     */
    boolean isEmpty();
}
