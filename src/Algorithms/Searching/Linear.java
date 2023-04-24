package Algorithms.Searching;

/**
 * The {@code Linear} class provides a static method for binary
 * searching for an integer in a sorted array of integers.
 * <p>
 * The <em>indexOf</em> operations takes linear time in the worst case.
 * <p>
 */
public class Linear {

    // this class should not be instantiated
    private Linear() { }

    /**
     * Returns the index of the specified key in the specified array.
     *
     * @param a   the array of integers, must be sorted in ascending order
     * @param key the search key
     * @return index of the key in array {@code a} if present; {@code -1} otherwise
     */
    public static int search(Comparable[] a, Comparable key) {
        int n = a.length;

        for (int i = 0; i < n; i++) {
            if (a[i] == key) return i;
        }

        return -1;
    }

}
