package Stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedStack<Item> implements Iterable<Item>, StackAPI<Item> {

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
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = first.item;     // save the item to return
        first = first.next;         // delete the first node
        n--;
        return item;                // return the saved item
    }

    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
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
        private Node current;

        public ReverseLinkedIterator() {
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
     * Unit test the {@code LinkedStack} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        LinkedStack<Integer> stack = new LinkedStack<>();

        // pushes: 10, 20, 30... 100 into the stack
        for (int i = 10; i <= 100; i += 10) {
            stack.push(i);
        }

        System.out.println("peeking the element on top of the stack = " + stack.peek());
        System.out.println("popping out the element on top of the stack = " + stack.pop());
        System.out.println("size of stack = " + stack.size());

        if (stack.isEmpty()) return;
        for (int i : stack) {
            System.out.println(i);
        }
    }

}
