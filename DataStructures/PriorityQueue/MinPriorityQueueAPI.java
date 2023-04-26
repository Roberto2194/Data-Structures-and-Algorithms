package DataStructures.PriorityQueue;

import java.util.NoSuchElementException;

/**
 * The {@code MinPriorityQueueAPI} interface represents a priority queue of generic keys.
 * It supports the usual <em>insert</em> and <em>delete-the-minimum</em>
 * operations, along with methods for peeking at the minimum key,
 * testing if the priority queue is empty, and iterating through the keys.
 */
public interface MinPriorityQueueAPI<Key> {
    /**
     * Adds a new key to this priority queue.
     *
     * @param v the key to add to this priority queue
     */
    void insert(Key v);

    /**
     * Removes and returns a smallest key on this priority queue.
     *
     * @return a smallest key on this priority queue
     * @throws NoSuchElementException if this priority queue is empty
     */
    Key delMin();

    /**
     * Returns a smallest key on this priority queue.
     *
     * @return a smallest key on this priority queue
     * @throws NoSuchElementException if this priority queue is empty
     */
    Key min();

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
