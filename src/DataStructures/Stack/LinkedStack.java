package DataStructures.Stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * <p>
 * This implementation of {@code StackAPI} uses a singly linked list with a non-static nested class Node.
 * </p>
 * The <em>push</em>, <em>pop</em>, <em>peek</em>, <em>size</em>, and <em>isEmpty</em> operations take constant time.
 * Iteration takes time proportional to the number of items.
 */
public class LinkedStack<Item> implements StackAPI<Item>, Iterable<Item> {

    private Node first;     // top of stack
    private int n;          // size of the stack

    // helper linked list class
    private class Node {
        private Item item;
        private Node next;
    }

    /**
     * Initializes an empty stack.
     */
    public LinkedStack() {
        first = null;
        n = 0;
    }

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        n++;
    }

    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("DataStructures.Stack underflow");
        Item item = first.item;     // save the item to return
        first = first.next;         // delete the first node
        n--;
        return item;                // return the saved item
    }

    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("DataStructures.Stack underflow");
        return first.item;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Returns an iterator to this stack that iterates through the items in LIFO order.
     *
     * @return an iterator to this stack that iterates through the items in LIFO order
     */
    public Iterator<Item> iterator() {
        return new ReverseLinkedIterator();
    }

    // an iterator over a linked list, in reverse order
    private class ReverseLinkedIterator implements Iterator<Item> {
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
