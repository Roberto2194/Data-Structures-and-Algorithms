package Algorithms.Sorting;

/**
 * The {@code Insertion} class provides static methods for sorting an
 * array using insertion sort.
 * <p>
 * In the worst case, this implementation makes ~ &frac12; <em>n</em><sup>2</sup>
 * compares and ~ &frac12; <em>n</em><sup>2</sup> exchanges to sort an array
 * of length <em>n</em>. So, it is not suitable for sorting large arbitrary
 * arrays. More precisely, the number of exchanges is exactly equal to the
 * number of inversions. So, for example, it sorts a partially-sorted array
 * in linear time.
 * <p>
 * This sorting algorithm is stable.
 * It uses &Theta;(1) extra memory (not including the input array).
 * <p>
 * <b>Best case</b>: &Omega;(<em>n</em>)<br>
 * <b>Average case</b>: &Theta;(<em>n</em><sup>2</sup>)<br>
 * <b>Worst case</b>: &Omicron;(<em>n</em><sup>2</sup>)
 */
public class Insertion {

    // this class should not be instantiated
    private Insertion() { }

    /**
     * Rearranges the array in ascending order, using the natural order.
     *
     * @param a the array to be sorted
     */
    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && less(a[j], a[j-1]); j--) {
                swap(a, j, j-1);
            }
        }
    }

    // print the array, on a single line
    public static void show(Object[] a) {
        for (Object key : a) System.out.print(key + " ");
        System.out.println();
    }

    // test whether the array entries are in order
    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) if (less(a[i], a[i - 1])) return false;
        return true;
    }

    // is the first element v less than the second w?
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    // exchange a[i] and a[j]
    private static void swap(Object[] a, int i, int j) {
        Object temp = a[i]; a[i] = a[j]; a[j] = temp;
    }

}
