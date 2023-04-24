package Algorithms.Sorting;

import static Algorithms.Sorting.Sortable.swap;
import static Algorithms.Sorting.Sortable.less;

/**
 * The {@code Selection} class provides static methods for sorting an
 * array using <em>selection sort</em>.<br>
 * This implementation makes ~ &frac12; <em>n</em><sup>2</sup> compares to sort
 * any array of length <em>n</em>, so it is not suitable for sorting large arrays.
 * It performs exactly <em>n</em> exchanges.
 * <p>
 * This sorting algorithm is not stable. It uses &Theta;(1) extra memory
 * (not including the input array).
 * <p>
 * <b>Best case</b>: &Omega;(<em>n</em><sup>2</sup>)<br>
 * <b>Average case</b>: &Theta;(<em>n</em><sup>2</sup>)<br>
 * <b>Worst case</b>: &Omicron;(<em>n</em><sup>2</sup>)
 */
public class Selection extends AbstractSort {

    // this class should not be instantiated
    private Selection() { }

    /**
     * Rearranges the array in ascending order, using the natural order.
     *
     * @param a the array to be sorted
     */
    public static <Key extends Comparable<Key>> void sort(Key[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (less(a[j], a[min])) min = j;
            }
            swap(a, i, min);
        }
    }

    /**
     * Unit test the {@code Selection} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        Integer[] a = {2, 23, 12, 17, 11, 9, 77, 45, 62, 22};
        Selection.sort(a);
        if (Selection.isSorted(a)) Selection.show(a);
        else System.out.println("The values are not sorted!");
    }

}
