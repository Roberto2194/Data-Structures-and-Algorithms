package Algorithms.Sorting;

/**
 * The {@code BubbleSort} class provides static methods for sorting an
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
public class BubbleSort {

    /**
     * This class should not be instantiated.
     */
    private BubbleSort() { }

    /**
     * Rearranges the array in ascending order, using the natural order.
     *
     * @param a the array to be sorted
     */
    public static void sort(Comparable[] a) {

    }

    // is the first element v less than the second w?
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    // exchange a[i] and a[j]
    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // print the array, on a single line
    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    // test whether the array entries are in order
    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }

    /**
     * Unit test the {@code BubbleSort} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        Integer[] a = {2, 23, 12, 17, 11, 9, 77, 45, 62, 22};
        BubbleSort.sort(a);
        if (BubbleSort.isSorted(a)) BubbleSort.show(a);
        else System.out.println("The values are not sorted!");
    }

}
