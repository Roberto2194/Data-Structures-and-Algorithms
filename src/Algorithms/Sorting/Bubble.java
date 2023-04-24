package Algorithms.Sorting;

import static Algorithms.Sorting.Sortable.swap;
import static Algorithms.Sorting.Sortable.less;

/**
 * The {@code Bubble} class provides static methods for sorting an
 * array using bubble sort.
 * <p>
 * This implementation makes ~ 1/2 n^2 compares and exchanges in
 * the worst case, so it is not suitable for sorting large arbitrary arrays.
 * Bubble sort is seldom useful because it is substantially slower than
 * insertion sort on most inputs. The one class of inputs where bubble sort
 * might be faster than insertion sort is arrays for which only
 * a few passes of bubble sort are needed. This includes sorted arrays,
 * but it does not include most partially-sorted arrays; for example,
 * bubble sort takes quadratic time to sort arrays of the form
 * [n, 1, 2, 3, 4, ..., n-1], whereas insertion sort takes linear time on
 * such inputs.
 * <p>
 * The sorting algorithm is stable and uses O(1) extra memory.
 * <p>
 * <b>Best case</b>: &Omega;(<em>n</em>)<br>
 * <b>Average case</b>: &Theta;(<em>n</em><sup>2</sup>)<br>
 * <b>Worst case</b>: &Omicron;(<em>n</em><sup>2</sup>)
 */
public class Bubble extends AbstractSort {

    // this class should not be instantiated
    private Bubble() {}

    /**
     * Rearranges the array in ascending order, using the natural order.
     *
     * @param a the array to be sorted
     */
    public static <Key extends Comparable<Key>> void sort(Key[] a) {
        int n = a.length;

        for (int i = 1; i < n; i++) {
            int exchanges = 0;
            for (int j = n - 1; j > i; j--) {
                if (less(a[j], a[j - 1])) {
                    swap(a, j, j - 1);
                    exchanges++;
                }
            }
            if (exchanges == 0) break;
        }
    }

    /**
     * Unit test the {@code Bubble} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        Integer[] a = {2, 23, 12, 17, 11, 9, 77, 45, 62, 22};
        Bubble.sort(a);
        if (Bubble.isSorted(a)) Bubble.show(a);
        else System.out.println("The values are not sorted!");
    }

}
