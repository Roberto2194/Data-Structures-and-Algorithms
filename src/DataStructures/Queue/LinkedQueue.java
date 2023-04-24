package DataStructures.Queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * <p>
 * This implementation of {@code QueueAPI} uses a singly linked list with a non-static nested class Node.
 * </p>
 * The <em>enqueue</em>, <em>dequeue</em>, <em>peek</em>, <em>size</em>, and <em>isEmpty</em> operations take constant time.
 * Iteration takes time proportional to the number of items.
 */
public class LinkedQueue<Item> implements QueueAPI<Item>, Iterable<Item> {

    private Node first;     // beginning of queue
    private Node last;      // end of queue
    private int N;          // size of the queue

    // helper linked list class
    private class Node {
        private Item item;
        private Node next;
    }

    /**
     * Initializes an empty queue.
     */
    public LinkedQueue() {
        first = null;
        last = null;
        N = 0;
    }

    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else           oldLast.next = last;
        N++;
    }

    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("DataStructures.Queue underflow");
        Item item = first.item;     // save the item to return
        first = first.next;         // delete the first node
        N--;
        return item;                // return the saved item
    }

    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("DataStructures.Queue underflow");
        return first.item;
    }

    public int size() {
        return N;
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
        return new LinkedIterator();
    }

    // an iterator over a linked list
    private class LinkedIterator implements Iterator<Item> {
        private Node current;

        public LinkedIterator() {
            current = first;
        }

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

    /**
     * Unit test the {@code LinkedQueue} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        LinkedQueue<Integer> queue = new LinkedQueue<>();
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
