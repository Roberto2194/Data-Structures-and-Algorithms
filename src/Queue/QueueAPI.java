package Queue;

/**
 * The {@code QueueAPI} represents a first-in-first-out (FIFO) queue of generic items.
 * It supports the usual <em>enqueue</em> and <em>dequeue</em> operations,
 * along with methods for peeking the first item, testing if the queue is empty, and iterating through the items in FIFO order.
 */
public interface QueueAPI<Item> {

    /**
     * Adds an item to this queue.
     *
     * @param item the item to add
     */
    void enqueue(Item item);

    /**
     * Removes and returns the item most recently added to this queue.
     *
     * @return the item most recently added
     * @throws java.util.NoSuchElementException if this queue is empty
     */
    Item dequeue();

    /**
     * Returns (but does not remove) the item least recently added to this queue.
     *
     * @return the item least recently added to this queue
     * @throws java.util.NoSuchElementException if this queue is empty
     */
    Item peek();

    /**
     * Returns the number of items in this queue.
     *
     * @return the number of items in this queue
     */
    int size();

    /**
     * Is this queue empty?
     *
     * @return true if this queue is empty; false otherwise
     */
    boolean isEmpty();

}
