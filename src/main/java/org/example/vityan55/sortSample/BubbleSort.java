package org.example.vityan55.sortSample;

import java.util.Comparator;

    public class BubbleSort {
        /**
         *
         * @param array Sortable array of type T
         * @param c     Comparator for comparing objects
         * @param <T>   Any type
         */
        public static <T> void sort(T[] array, Comparator<T> c){
            for (int i = 0; i < array.length; i++) {
                for (int j = 1; j < array.length - i; j++) {

                    // If the previous element is greater than the current, swap them
                    if (c.compare(array[j - 1], array[j]) > 0){
                        T temp = array[j - 1];
                        array[j - 1] = array[j];
                        array[j] = temp;
                    }
                }
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
