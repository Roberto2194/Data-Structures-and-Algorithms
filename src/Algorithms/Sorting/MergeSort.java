package Algorithms.Sorting;

/**
 * The {@code MergeSort} class provides static methods for sorting an
 * array using a top-down, recursive version of <em>mergesort</em>.
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
public class MergeSort {

    /**
     * This class should not be instantiated.
     */
    private MergeSort() { }

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
     * Unit test the {@code MergeSort} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        Integer[] a = {2, 23, 12, 17, 11, 9, 77, 45, 62, 22};
        MergeSort.sort(a);
        if (MergeSort.isSorted(a)) MergeSort.show(a);
        else System.out.println("The values are not sorted!");
    }

}
