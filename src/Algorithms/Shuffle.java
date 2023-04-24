package Algorithms;

/**
 *  The {@code Shuffle} class provides a client for reading in a
 *  sequence of strings and <em>shuffling</em> them using the Shuffle (or Fisher-Yates)
 *  shuffling algorithm. This algorithm guarantees to rearrange the
 *  elements in uniformly random order, under
 *  the assumption that Math.random() generates independent and
 *  uniformly distributed numbers between 0 and 1.
 */
public class Shuffle {

    // this class should not be instantiated
    private Shuffle() { }

    /**
     * Rearranges an array of objects in uniformly random order
     * (under the assumption that {@code Math.random()} generates independent
     * and uniformly distributed numbers between 0 and 1).
     * @param a the array to be shuffled
     */
    public static void random(Object[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            // choose index uniformly in [0, i]
            int r = (int) (Math.random() * (i + 1));
            swap(a, r, i);
        }
    }

    // exchange a[i] and a[j]
    private static void swap(Object[] a, int i, int j) {
        Object temp = a[i]; a[i] = a[j]; a[j] = temp;
    }

}

