package org.example.vityan55.sortSample;

import java.util.Arrays;
import java.util.Comparator;

public class MergeSort {
    /**
     * Merge two parts of the array and sorted it
     *
     * @param array Sortable array
     * @param left  Left border of the range
     * @param mid   Middle of the range
     * @param right Right border of the range
     * @param c     Comparator
     * @param <T>   Any type
     */
    private static <T> void merge(T[] array, int left, int mid, int right, Comparator<T> c) {
        T[] leftArr = Arrays.copyOfRange(array, left, mid);
        T[] rightArr = Arrays.copyOfRange(array, mid, right);

        int l = 0;
        int r = 0;
        int i = left;

        // Merge elements from leftArr and rightArr into original array
        while (l < leftArr.length && r < rightArr.length) {
            if (c.compare(leftArr[l], rightArr[r]) < 0) {
                array[i++] = leftArr[l++];
            } else {
                array[i++] = rightArr[r++];
            }
        }

        // Copy any remaining elements from leftArr
        while (l < leftArr.length) {
            array[i++] = leftArr[l++];
        }

        // Copy any remaining elements from rightArr
        while (r < rightArr.length) {
            array[i++] = rightArr[r++];
        }
    }

    /**
     * Recursively splits the array into smaller parts, sorts and merges them.
     *
     * @param array Sortable array
     * @param left  Left border of the range
     * @param right Right border of the range
     * @param c     Comparator
     * @param <T>   Any type
     */
    public static <T> void sort(T[] array, int left, int right, Comparator<T> c) {
        if (left < right - 1) {
            int middle = (left + right) / 2;

            // Sort the left half
            sort(array, left, middle, c);

            // Sort the right half
            sort(array, middle, right, c);

            // Merge the two halves
            merge(array, left, middle, right, c);
        }
    }

    /**
     * Sorts an array of Comparable elements using their natural order.
     *
     * @param array Sortable array
     * @param <T>   Comparable type
     */
    public static <T extends Comparable<T>> void sort(T[] array) {
        sort(array, 0, array.length, Comparable::compareTo);
    }

    /**
     * Overload for sorting String arrays using a custom Comparator.
     *
     * @param array Sortable array
     * @param c     Comparator
     */
    public static void sort(String[] array, Comparator<String> c) {
        sort(array, 0, array.length, c);
    }
}
