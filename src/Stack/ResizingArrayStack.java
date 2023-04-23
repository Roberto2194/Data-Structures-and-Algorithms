package Stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * <p>
 * This implementation of {@code StackAPI} uses a resizing array,
 * which doubles the underlying array when it is full
 * and halves the underlying array when it is one-quarter full.
 * </p>
 * The <em>push</em> and <em>pop</em> operations take constant amortized time.
 * The <em>size</em>, <em>peek</em>, and <em>isEmpty</em> operations take constant time.
 * Iteration takes time proportional to the number of items.
 */
public class ResizingArrayStack<Item> implements Iterable<Item>, StackAPI<Item> {

    // initial capacity of underlying resizing array
    public static final int INIT_CAPACITY = 8;

    private Item[] a;       // array of items
    private int n;          // number of elements in stack

    /**
     * Initializes an empty stack.
     */
    public ResizingArrayStack() {
        a = (Item[]) new Object[INIT_CAPACITY];
        n = 0;
    }

    public void push(Item item) {
        if (n == a.length) resize(a.length * 2);
        a[n++] = item;
    }

    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = a[n-1];     // save the item to return
        a[n-1] = null;          // to avoid loitering
        n--;
        // shrink the size of the array if necessary
        if (n > 0 && n == a.length / 4) resize(a.length / 2);
        return item;            // return the saved item
    }

    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return a[n - 1];
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    // resize the underlying array holding the elements
    private void resize(int capacity) {
        assert capacity >= n;
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++)
            copy[i] = a[i];
        a = copy;
    }

    /**
     * Returns an iterator to this stack that iterates through the items in LIFO order.
     *
     * @return an iterator to this stack that iterates through the items in LIFO order
     */
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    // an array iterator, in reverse order
    private class ReverseArrayIterator implements Iterator<Item> {
        private int i;

        public ReverseArrayIterator() {
            i = n - 1;
        }

        public boolean hasNext() {
            return i >= 0;
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return a[i--];
        }
    }

    /**
     * Unit test the {@code ResizingArrayStack} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        ResizingArrayStack<Integer> stack = new ResizingArrayStack<>();

        // pushes: 25, 50, 75, 100, 125 into the stack
        for (int i = 25; i < 150; i += 25) {
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
