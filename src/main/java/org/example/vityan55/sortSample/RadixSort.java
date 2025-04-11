package org.example.vityan55.sortSample;

import java.util.Arrays;

public class RadixSort {
    /**
     * Sorting by digit Index
     * (in order not to complicate the implementation, all numbers must be >= 0)
     *
     * @param array     Sortable array
     * @param exp       DigitBase ^ i
     * @param digitBase Digit base of the number system
     */
    private static void countingSort(int[] array, int exp, int digitBase){
        int[] digitArray = new int[digitBase];
        int[] resultArray = new int[array.length];

        // Count occurrences of each digit in the given digit position (defined by exp)
        for (int j : array) {
            int digit = (j / exp) % digitBase;
            digitArray[digit]++;
        }

        // Transform count array to represent positions (prefix sum / cumulative count)
        for (int i = 0; i < digitArray.length - 1; i++) {
            digitArray[i + 1] += digitArray[i];
        }

        // Build the result array using the digit positions (right to left to maintain stability)
        for (int i = resultArray.length - 1; i >= 0; i--) {
            int digit = (array[i] / exp) % digitBase;
            resultArray[--digitArray[digit]] = array[i];
        }

        // Copy the sorted values for current digit back to the original array
        System.arraycopy(resultArray, 0, array, 0, resultArray.length);
    }

    /**
     * Simple realization of Radix Sort for int  that can be represented as integers
     * (in order not to complicate the implementation, all numbers must be >= 0)
     * This sorting is most effective for non-negative int, long, and fixed-length strings.
     *
     * @param array     Sortable array
     * @param digitBase Digit base of the number system
     */
    public static void sort(int[] array, int digitBase){
        if (array.length == 0){
            return;
        }

        // Find the maximum number in the array to determine how many digit places are needed
        int max = Arrays.stream(array)
                .max()
                .orElseThrow();

        // Iterate over each digit position starting from the least significant digit
        for (int exp = 1; max / exp > 0; exp *= digitBase) {
            countingSort(array, exp, digitBase);
        }
    }

    /**
     * Sorts int array of decimal number system
     *
     * @param array Sortable array
     */
    public static void sort(int[] array){
        sort(array, 10);
    }
}
