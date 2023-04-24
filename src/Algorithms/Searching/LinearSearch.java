package Algorithms.Searching;

import java.util.Arrays;

/**
 * The {@code LinearSearch} class provides a static method for binary
 * searching for an integer in a sorted array of integers.
 * <p>
 * The <em>indexOf</em> operations takes linear time in the worst case.
 * <p>
 */
public class LinearSearch {

    /**
     * This class should not be instantiated.
     */
    private LinearSearch() { }

    /**
     * Returns the index of the specified key in the specified array.
     *
     * @param a   the array of integers, must be sorted in ascending order
     * @param key the search key
     * @return index of the key in array {@code a} if present; {@code -1} otherwise
     */
    public static int indexOf(Comparable[] a, Comparable key) {
        int N = a.length;

        for (int i = 0; i < N; i++) {
            if (a[i] == key) return i;
        }

        return -1;
    }

    /**
     * Unit test the {@code LinkedStack} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        Integer[] a = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
        int key = 17;

        // sort the array
        Arrays.sort(a);

        // perform the binary search
        int result = LinearSearch.indexOf(a, key);
        if (result == -1) System.out.println("Couldn't find the key");
        else System.out.println("The key " + key + " is in the array at index: " + result);
    }

}
