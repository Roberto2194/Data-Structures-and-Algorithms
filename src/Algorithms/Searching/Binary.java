package Algorithms.Searching;

/**
 * The {@code Binary} class provides a static method for binary
 * searching for an integer in a sorted array of integers.
 * <p>
 * The <em>indexOf</em> operation takes logarithmic time in the worst case.
 * <p>
 */
public class Binary {

    // this class should not be instantiated
    private Binary() { }

    /**
     * Returns the index of the specified key in the specified array.
     *
     * @param a   the array of integers, must be sorted in ascending order
     * @param key the search key
     * @return index of the key in array {@code a} if present; {@code -1} otherwise
     */
    public static int search(Comparable[] a, Comparable key) {
        int lo = 0;
        int hi = a.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if      (less(key, a[mid])) hi = mid - 1;   // lower the hi below the mid-point
            else if (less(a[mid], key)) lo = mid + 1;   // raise the lo above the mid-point
            else return mid;
        }

        return -1;
    }

    // is the first element v less than the second w?
    static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

}
