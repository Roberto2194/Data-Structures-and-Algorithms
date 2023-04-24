package Algorithms.Sorting;

/**
 * The {@code ShellSort} class provides static methods for sorting an
 * array using <em>ShellSort</em> with Knuth's increment sequence</a>
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
public class ShellSort {

    /**
     * This class should not be instantiated.
     */
    private ShellSort() { }

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
     * Unit test the {@code ShellSort} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        Integer[] a = {2, 23, 12, 17, 11, 9, 77, 45, 62, 22};
        ShellSort.sort(a);
        if (ShellSort.isSorted(a)) ShellSort.show(a);
        else System.out.println("The values are not sorted!");
    }

}
