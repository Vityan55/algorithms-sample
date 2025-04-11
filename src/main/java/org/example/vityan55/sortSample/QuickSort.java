package org.example.vityan55.sortSample;

import java.util.Comparator;

public class QuickSort {
    /**
     * Partitions the array into two parts around a pivot element.
     *
     * @param array Sortable array
     * @param left  Left border of the range
     * @param right Right border of the range (exclusive)
     * @param c     Comparator for comparing objects
     * @return      Index where the partition occurs
     * @param <T>   Any type
     */
    private static <T> int partition(T[] array, int left, int right, Comparator<T> c){
        int l = left;
        int r = right - 1;

        T el = array[(l + r) / 2];

        while (l <= r){
            // Move the left pointer to the right until finding element ≥ pivot
            while (c.compare(array[l], el) < 0){
                l++;
            }

            // Move the right pointer to the left until finding element ≤ pivot
            while (c.compare(array[r], el) > 0){
                r--;
            }

            // Swap elements if out of order and move both pointers inward
            if (l <= r){
                T temp = array[l];
                array[l] = array[r];
                array[r] = temp;

                l++;
                r--;
            }
        }

        // Edge case: if l moved past right bound, adjust
        if (l == right){
            l--;
        }
        return l;
    }

    /**
     * Recursively sorts the array using the QuickSort algorithm.
     *
     * @param array Sortable array
     * @param left  Left border of the range
     * @param right Right border of the range (exclusive)
     * @param c     Comparator for comparing objects
     * @param <T>   Any type
     */
    public static <T> void sort(T[] array, int left, int right, Comparator<T> c){
        if (left < right - 1){
            // Partition the array and get pivot index
            int index = partition(array, left, right, c);

            // Recursively sort the left part
            sort(array, left, index, c);

            // Recursively sort the right part
            sort(array, index, right, c);
        }
    }

    /**
     * Recursively sorts the array using the QuickSort algorithm (Without comparator).
     *
     * @param array Sortable array
     * @param <T>   Comparable type
     */
    public static <T extends Comparable<T>> void sort(T[] array){
        sort(array, 0, array.length, Comparable::compareTo);
    }

    /**
     * Call the generic sort method with comparator
     *
     * @param array Sortable array
     * @param c     Comparator
     */
    public static void sort(String[] array, Comparator<String> c) {
        sort(array, 0, array.length, c);
    }
}
