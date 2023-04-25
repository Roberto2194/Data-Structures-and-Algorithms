import Algorithms.Searching.Binary;
import Algorithms.Searching.Linear;
import Algorithms.Sorting.*;
import DataStructures.Bag.LinkedBag;
import DataStructures.Bag.ResizingArrayBag;
import DataStructures.Queue.LinkedQueue;
import DataStructures.Queue.ResizingArrayQueue;
import DataStructures.Stack.LinkedStack;
import DataStructures.Stack.ResizingArrayStack;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        /* *************** ***************  ***************  *************** */
        /*                         Data Structures                           */
        /* *************** ***************  ***************  *************** */

        ResizingArrayBag<String> resizingArrayBag = new ResizingArrayBag<>();
        resizingArrayBag.add("Hello");
        resizingArrayBag.add("World");

        System.out.println("size of resizingArrayBag = " + resizingArrayBag.size());

        if (resizingArrayBag.isEmpty()) return;
        for (String s : resizingArrayBag) {
            System.out.println(s);
        }

        LinkedBag<String> linkedBag = new LinkedBag<>();
        linkedBag.add("Hello");
        linkedBag.add("World");

        System.out.println("size of linkedBag = " + linkedBag.size());

        if (linkedBag.isEmpty()) return;
        for (String s : linkedBag) {
            System.out.println(s);
        }

        ResizingArrayQueue<Integer> resizingArrayQueue = new ResizingArrayQueue<>();
        resizingArrayQueue.enqueue(2);
        resizingArrayQueue.enqueue(3);
        resizingArrayQueue.enqueue(5);
        resizingArrayQueue.enqueue(7);
        resizingArrayQueue.enqueue(11);

        System.out.println("dequeuing the first element of the resizingArrayQueue = " + resizingArrayQueue.dequeue());
        System.out.println("peeking the first element of the resizingArrayQueue = " + resizingArrayQueue.peek());
        System.out.println("size of resizingArrayQueue = " + resizingArrayQueue.size());

        if (resizingArrayQueue.isEmpty()) return;
        for (int i : resizingArrayQueue) {
            System.out.println(i);
        }

        LinkedQueue<Integer> linkedQueue = new LinkedQueue<>();
        linkedQueue.enqueue(2);
        linkedQueue.enqueue(3);
        linkedQueue.enqueue(5);
        linkedQueue.enqueue(7);
        linkedQueue.enqueue(11);

        System.out.println("dequeuing the first element of the linkedQueue = " + linkedQueue.dequeue());
        System.out.println("peeking the first element of the linkedQueue = " + linkedQueue.peek());
        System.out.println("size of linkedQueue = " + linkedQueue.size());

        if (linkedQueue.isEmpty()) return;
        for (int i : linkedQueue) {
            System.out.println(i);
        }

        ResizingArrayStack<Integer> resizingArrayStack = new ResizingArrayStack<>();
        resizingArrayStack.push(25);
        resizingArrayStack.push(50);
        resizingArrayStack.push(75);
        resizingArrayStack.push(100);
        resizingArrayStack.push(125);

        System.out.println("peeking the element on top of the resizingArrayStack = " + resizingArrayStack.peek());
        System.out.println("popping out the element on top of the resizingArrayStack = " + resizingArrayStack.pop());
        System.out.println("size of resizingArrayStack = " + resizingArrayStack.size());

        if (resizingArrayStack.isEmpty()) return;
        for (int i : resizingArrayStack) {
            System.out.println(i);
        }

        LinkedStack<Integer> linkedStack = new LinkedStack<>();
        linkedStack.push(25);
        linkedStack.push(50);
        linkedStack.push(75);
        linkedStack.push(100);
        linkedStack.push(125);

        System.out.println("peeking the element on top of the linkedStack = " + linkedStack.peek());
        System.out.println("popping out the element on top of the linkedStack = " + linkedStack.pop());
        System.out.println("size of linkedStack = " + linkedStack.size());

        if (linkedStack.isEmpty()) return;
        for (int i : linkedStack) {
            System.out.println(i);
        }

        /* *************** ***************  ***************  *************** */
        /*                              Sorting                              */
        /* *************** ***************  ***************  *************** */

        Integer[] a = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
        int key = 17;

        // sort the array
        Arrays.sort(a);

        // perform the linear search
        int linearSearch = Linear.search(a, key);
        if (linearSearch == -1) System.out.println("Couldn't find the key");
        else System.out.println("The key " + key + " is in the array at index: " + linearSearch);

        // perform the binary search
        int binarySearch = Binary.search(a, key);
        if (binarySearch == -1) System.out.println("Couldn't find the key");
        else System.out.println("The key " + key + " is in the array at index: " + binarySearch);

        /* *************** ***************  ***************  *************** */
        /*                            Searching                              */
        /* *************** ***************  ***************  *************** */

        Integer[] b = {2, 23, 12, 17, 11, 9, 77, 45, 62, 22};

        Bubble.sort(b);
        if (Bubble.isSorted(b)) Bubble.show(b);
        else System.out.println("The values are not sorted!");

        Insertion.sort(b);
        if (Insertion.isSorted(b)) Insertion.show(b);
        else System.out.println("The values are not sorted!");

        Merge.sort(b);
        if (Merge.isSorted(b)) Merge.show(b);
        else System.out.println("The values are not sorted!");

        Quick.sort(b);
        if (Quick.isSorted(b)) Quick.show(b);
        else System.out.println("The values are not sorted!");

        Selection.sort(b);
        if (Selection.isSorted(b)) Selection.show(b);
        else System.out.println("The values are not sorted!");

        Shell.sort(b);
        if (Shell.isSorted(b)) Shell.show(b);
        else System.out.println("The values are not sorted!");
    }

}
