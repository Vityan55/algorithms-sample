package org.example.vityan55.sortSample;

import java.util.Comparator;

public class SelectionSort {
    /**
     *
     * @param array Sortable array of type T
     * @param c     Comparator for comparing objects
     * @param <T>   Any type
     */
    public static <T> void sort(T[] array, Comparator<T> c){
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;

            // Inner loop - find the minimum element in the unsorted part of the array
            for (int j = i + 1; j < array.length; j++) {
                if (c.compare(array[minIndex], array[j]) > 0){
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first element of the unsorted part
            T temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    /**
     *
     * @param array Sortable array of type T
     * @param <T>   Comparable type
     */
    public static <T extends Comparable<T>> void sort(T[] array){
        sort(array, Comparable::compareTo);
    }
}
