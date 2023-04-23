package Bag;

/**
 * The {@code BagAPI} represents a bag of generic items.
 * It supports insertion and iterating over the items in arbitrary order.
 */
public interface BagAPI<Item> {

    /**
     * Adds the item to this bag.
     *
     * @param item the item to add to this bag
     */
    void add(Item item);

    /**
     * Returns the number of items in this bag.
     *
     * @return the number of items in this bag
     */
    int size();

    /**
     * is this bag empty?
     *
     * @return true if this bag is empty; false otherwise
     */
    boolean isEmpty();

}
