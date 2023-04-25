package Algorithms.Sorting;

/**
 * The {@code Merge} class provides static methods for sorting an
 * array using a top-down, <em>recursive</em> version of <em>mergesort</em>.
 * <p>
 * This algorithm is one of the best-known examples of the utility of
 * the <em>divide-and-conquer</em> paradigm for efficient algorithm design.
 * <p>
 * This implementation takes &Theta;(<em>n</em> log <em>n</em>) time
 * to sort any array of length <em>n</em> (assuming comparisons
 * take constant time). It makes between
 * ~ &frac12; <em>n</em> log<sub>2</sub> <em>n</em> and
 * ~ 1 <em>n</em> log<sub>2</sub> <em>n</em> compares.
 * <p>
 * This sorting algorithm is stable.
 * It uses &Theta;(<em>n</em>) extra memory (not including the input array).
 * <p>
 * <b>Best case</b>: &Omega;(<em>n</em> <em>log</em>(<em>n</em>))<br>
 * <b>Average case</b>: &Theta;(<em>n</em> <em>log</em>(<em>n</em>))<br>
 * <b>Worst case</b>: &Omicron;(<em>n</em> <em>log</em>(<em>n</em>))
 */
public class Merge {

    // this class should not be instantiated
    private Merge() { }

    /**
     * Rearranges the array in ascending order, using the natural order.
     *
     * @param a the array to be sorted
     */
    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];    // auxiliary array for merges
        sort(a, aux, 0, a.length - 1);
    }

    // mergesort a[lo..hi] using auxiliary array aux[lo..hi]
    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;

        // divide the array to sort in two parts a[lo..mid] and a[mid+1..hi]
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);     // merge the resulting ordered subarrays
    }

    // stably merge a[lo .. mid] with a[mid+1 ..hi] using aux[lo .. hi]
    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {

        // copy to aux[]
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        // merge back to a[]
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)              a[k] = aux[j++];     // left half exhausted (take from right)
            else if (j > hi)               a[k] = aux[i++];     // right half exhausted (take from left)
            else if (less(aux[j], aux[i])) a[k] = aux[j++];     // key on right less than key on left (take from right)
            else                           a[k] = aux[i++];     // key on left less than key on right (take from left)
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

}
