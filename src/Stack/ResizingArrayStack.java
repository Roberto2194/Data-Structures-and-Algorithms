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

    private Item[] s;       // stack elements
    private int n;          // number of elements in stack

    /**
     * Initializes an empty stack.
     */
    public ResizingArrayStack() {
        s = (Item[]) new Object[INIT_CAPACITY];
        n = 0;
    }

    public void push(Item item) {
        if (n == s.length) resize(s.length * 2);
        s[n++] = item;
    }

    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = s[n-1];                                              // save the item to return
        s[n-1] = null;                                                   // to avoid loitering
        n--;
        if (n > 0 && n == s.length / 4) resize(s.length / 2);   // shrink the size of the array if necessary
        return item;                                                    // return the saved item
    }

    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return s[n - 1];
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
            copy[i] = s[i];
        s = copy;
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
            return s[i--];
        }
    }

    /**
     * Unit test the {@code ResizingArrayStack} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        ResizingArrayStack<Integer> stack = new ResizingArrayStack<>();
        stack.push(25);
        stack.push(50);
        stack.push(75);
        stack.push(100);
        stack.push(125);

        System.out.println("peeking the element on top of the stack = " + stack.peek());
        System.out.println("popping out the element on top of the stack = " + stack.pop());
        System.out.println("size of stack = " + stack.size());

        if (stack.isEmpty()) return;
        for (int i : stack) {
            System.out.println(i);
        }
    }

}
