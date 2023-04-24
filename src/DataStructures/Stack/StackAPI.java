package DataStructures.Stack;

/**
 * The {@code StackAPI} represents a last-in-first-out (LIFO) stack of generic items.
 * It supports the usual <em>push</em> and <em>pop</em> operations,
 * along with methods for peeking the item at the top, testing if the stack is empty, and iterating through the items in LIFO order.
 */
public interface StackAPI<Item> {

    /**
     * Adds an item to this stack.
     *
     * @param item the item to add
     */
    void push(Item item);

    /**
     * Removes and returns the item most recently added to this stack.
     *
     * @return the item most recently added
     * @throws java.util.NoSuchElementException if this stack is empty
     */
    Item pop();

    /**
     * Returns (but does not remove) the item most recently added to this stack.
     *
     * @return the item most recently added to this stack
     * @throws java.util.NoSuchElementException if this stack is empty
     */
    Item peek();

    /**
     * Returns the number of items in the stack.
     *
     * @return the number of items in the stack
     */
    int size();

    /**
     * Is this stack empty?
     *
     * @return true if this stack is empty; false otherwise
     */
    boolean isEmpty();

}
