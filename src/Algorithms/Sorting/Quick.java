package Algorithms.Sorting;

import Algorithms.Shuffle;

/**
 * The {@code Quick} class provides static methods for sorting an
 * array and selecting the ith smallest element in an array using quicksort.
 * <p>
 * <b>Best case</b>: &Omega;(<em>n</em> <em>log</em>(<em>n</em>))<br>
 * <b>Average case</b>: &Theta;(<em>n</em> <em>log</em>(<em>n</em>))<br>
 * <b>Worst case</b>: &Omicron;(<em>n</em><sup>2</sup>)
 */
public class Quick {

    // this class should not be instantiated
    private Quick() { }

    /**
     * Rearranges the array in ascending order, using the natural order.
     *
     * @param a the array to be sorted
     */
    public static void sort(Comparable[] a) {
        Shuffle.random(a);
        sort(a, 0, a.length - 1);
    }

    // quicksort the subarray from a[lo] to a[hi]
    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    // partition the subarray a[lo..hi] so that a[lo..j-1] <= a[j] <= a[j+1..hi] // and return the index j.
    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        Comparable v = a[lo];

        while (true) {
            // find item on lo to swap
            while (less(a[++i], v)) {
                if (i == hi) break;
            }

            // find item on hi to swap
            while (less(v, a[--j])) {
                if (j == lo) break;     // redundant since a[lo] acts as sentinel
            }

            // check if pointers cross
            if (i >= j) break;

            swap(a, i, j);
        }

        // put partitioning item v at a[j]
        swap(a, lo, j);

        // now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return j;
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
