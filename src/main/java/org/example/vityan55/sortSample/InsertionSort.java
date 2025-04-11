package org.example.vityan55.sortSample;

import java.util.Comparator;

public class InsertionSort {
    /**
     * Sorts the given array using the Insertion Sort algorithm.
     *
     * @param array Sortable array of type T
     * @param c     Comparator for comparing objects
     * @param <T>   Any type
     */
    public static <T> void sort(T[] array, Comparator<T> c){
        for (int i = 0; i < array.length; i++) {
            T temp = array[i];

            int j;
            // Move elements of the sorted part of the array (from index 0 to i-1)
            // that are greater than 'temp' one position ahead to make space
            for (j = i - 1; j >= 0 && c.compare(array[j], temp) > 0; j--) {
                array[j + 1] = array[j];
            }

            // Insert the current element into its correct position
            array[j + 1] = temp;
        }
    }


    /**
     * Sorts the given array using the Insertion Sort algorithm (Without comparator).
     *
     * @param array Sortable array of type T
     * @param <T>   Comparable type
     */
    public static <T extends Comparable<T>> void sort(T[] array){
        sort(array, Comparable::compareTo);
    }
}
