package org.example;

import org.example.vityan55.sortSample.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] array = {1, 4, 7, 9, 10, 3, 4, 5};
        BubbleSort.sort(array);
        System.out.println(Arrays.toString(array));
        System.out.println("---------------------------------------");

        array = new Integer[]{1, 4, 7, 9, 10, 3, 4, 5};
        InsertionSort.sort(array);
        System.out.println(Arrays.toString(array));
        System.out.println("---------------------------------------");

        array = new Integer[]{1, 4, 7, 9, 10, 3, 4, 5};
        SelectionSort.sort(array);
        System.out.println(Arrays.toString(array));
        System.out.println("---------------------------------------");

        array = new Integer[]{5, 3, 8, 1, 2};;
        QuickSort.sort(array);
        System.out.println(Arrays.toString(array));
        System.out.println("---------------------------------------");

        array = new Integer[]{1, 4, 7, 9, 10, 3, 4, 5};
        HeapSort.sort(array);
        System.out.println(Arrays.toString(array));
        System.out.println("---------------------------------------");

        array = new Integer[]{1, 4, 7, 9, 10, 3, 4, 5};
        MergeSort.sort(array);
        System.out.println(Arrays.toString(array));
        System.out.println("---------------------------------------");

        int[] array2 = new int[]{128, 484, 74, 90, 1, 375, 444, 571};
        RadixSort.sort(array2);
        System.out.println(Arrays.toString(array2));
        System.out.println("---------------------------------------");
    }
}