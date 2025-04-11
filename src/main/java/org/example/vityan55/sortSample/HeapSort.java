package org.example.vityan55.sortSample;

import java.util.Comparator;

public class HeapSort {
    /**
     * Sift down the array
     *
     * @param array Sortable array
     * @param size  Size of a heap
     * @param index Level of the heap node
     * @param c     Comparator for the comparing objects
     * @param <T>   Any type
     */
    private static <T> void heapify(T[] array, int size, int index, Comparator<T> c) {
        int l = 2 * index + 1;
        int r = 2 * index + 2;

        int larger = index;

        // Comparing left node with parent
        if (l < size && c.compare(array[l], array[larger]) > 0)
            larger = l;

        // Comparing right node with larger of lef node and parent node
        if (r < size && c.compare(array[r], array[larger]) > 0)
            larger = r;

        // Set parent node = larger node and left/right node = parent node
        if (larger != index) {
            T temp = array[index];
            array[index] = array[larger];
            array[larger] = temp;

            // Continue sift down with parent node that was moved on lower level
            heapify(array, size, larger, c);
        }
    }

    /**
     * Sorts the array using the HeapSort algorithm
     *
     * @param array Sortable array
     * @param c     Comparator for the comparing objects
     * @param <T>   Any type
     */
    public static <T> void sort(T[] array, Comparator<T> c) {
        // First sift down
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            heapify(array, array.length, i, c);
        }

        // After sift down we have highest number at 0 position, highest of the left nodes at 1 position
        // and highest of the right nodes at 2 position
        for (int i = array.length - 1; i > 0; i--) {
            T temp = array[i];
            array[i] = array[0];
            array[0] = temp;

            // Sift down the new root to restore the heap property.
            // This operation is O(log N) because we need to go from the root
            // to the bottom of the heap (which is a binary tree with a height of log N)
            // performing comparisons and exchanges in constant time at each level
            heapify(array, i, 0, c);
        }

    }

    /**
     * Sorts the array using HeapSort algorithm (Without comparator)
     *
     * @param array Sortable array
     * @param <T>   Comparable type
     */
    public static <T extends Comparable<T>> void sort(T[] array) {
        sort(array, Comparable::compareTo);
    }
}
