package Algorithms.Sorting;

/**
 * The {@code Shell} class provides static methods for sorting an
 * array using <em>Shell</em> with Shuffle's increment sequence</a>
 * (1, 4, 13, 40, ...). In the worst case, this implementation makes
 * &Theta;(<em>n</em><sup>3/2</sup>) compares and exchanges to sort
 * an array of length <em>n</em>.
 * <p>
 * This sorting algorithm is not stable.
 * It uses &Theta;(1) extra memory (not including the input array).
 * <p>
 * <b>Best case</b>: &Omega;(<em>n</em> <em>log</em>(<em>n</em>))<br>
 * <b>Average case</b>: &Theta;(<em>n</em> (<em>log</em>(<em>n</em>))<sup>2</sup>)<br>
 * <b>Worst case</b>: &Omicron;(<em>n</em> (<em>log</em>(<em>n</em>))<sup>2</sup>)
 */
public class Shell {

    // this class should not be instantiated
    private Shell() { }

    /**
     * Rearranges the array in ascending order, using the natural order.
     *
     * @param a the array to be sorted
     */
    public static void sort(Comparable[] a) {
        int n = a.length;

        // 3x+1 increment sequence: 1, 4, 13, 40, 121, 364, 1093, ...
        int h = 1;
        while (h < n / 3) h = 3 * h + 1; // looking for the greatest possible h-value in array
        while (h >= 1) {
            // h-sort the array
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    swap(a, j, j-h);
                }
            }
            h /= 3;
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
