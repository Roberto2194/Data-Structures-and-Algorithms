package Sorting;

/**
 * The {@code Selection} class provides static methods for sorting an
 * array using <em>selection sort</em>.<br>
 * This implementation makes ~ &frac12; <em>n</em><sup>2</sup> compares to sort
 * any array of length <em>n</em>, so it is not suitable for sorting large arrays.
 * It performs exactly <em>n</em> exchanges.
 * <p>
 * This sorting algorithm is not stable. It uses &Theta;(1) extra memory
 * (not including the input array).<br>
 * <p>
 * Best case: &Omega;(<em>n</em><sup>2</sup>)<br>
 * Average case: &Theta;(<em>n</em><sup>2</sup>)<br>
 * Worst case: &Omicron;(<em>n</em><sup>2</sup>)
 */
public class SelectionSort {

    /**
     * This class should not be instantiated.
     */
    private SelectionSort() { }

    /**
     * Rearranges the array in ascending order, using the natural order.
     *
     * @param a the array to be sorted
     */
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) min = j;
            }
            exch(a, i, min);
        }
    }

    // is the first element v less than the second w?
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    /**
     * Unit test the {@code LinkedStack} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        Integer[] a = {2, 23, 12, 17, 11, 9, 77, 45, 62, 22};

        SelectionSort.sort(a);

        for (int s : a) {
            System.out.println(s);
        }
    }

}
