package Algorithms.Sorting;

import static Algorithms.Sorting.Sortable.swap;
import static Algorithms.Sorting.Sortable.less;

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
public class Shell extends AbstractSort {

    // this class should not be instantiated
    private Shell() { }

    /**
     * Rearranges the array in ascending order, using the natural order.
     *
     * @param a the array to be sorted
     */
    public static <Key extends Comparable<Key>> void sort(Key[] a) {
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

    /**
     * Unit test the {@code Shell} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        Integer[] a = {2, 23, 12, 17, 11, 9, 77, 45, 62, 22};
        Shell.sort(a);
        if (Shell.isSorted(a)) Shell.show(a);
        else System.out.println("The values are not sorted!");
    }

}
