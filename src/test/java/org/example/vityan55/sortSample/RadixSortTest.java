package org.example.vityan55.sortSample;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class RadixSortTest {
    @Test
    void commonSort(){
        int[] input = {545, 333, 878, 10, 25};
        int[] expected = {10, 25, 333, 545, 878};
        RadixSort.sort(input);

        assertArrayEquals(expected, input);
    }

    @Test
    void emptyTest(){
        int[] input = {};
        int[] expected = {};
        RadixSort.sort(input);

        assertArrayEquals(expected, input);
    }

    @Test
    void oneElementTest(){
        int[] input = {50};
        int[] expected = {50};
        RadixSort.sort(input);

        assertArrayEquals(expected, input);
    }

    @Test
    void sameFirstDigitElementsTest(){
        int[] input = {551, 500, 590, 501, 511};
        int[] expected = {500, 501, 511, 551, 590};
        RadixSort.sort(input);

        assertArrayEquals(expected, input);
    }

    @Test
    void sameSecondDigitElementsTest(){
        int[] input = {651, 550, 555, 65, 15};
        int[] expected = {15, 65, 550, 555, 651};
        RadixSort.sort(input);

        assertArrayEquals(expected, input);
    }

    @Test
    void sameThirdDigitElementsTest(){
        int[] input = {1, 11, 121, 41, 151};
        int[] expected = {1, 11, 41, 121, 151};
        RadixSort.sort(input);

        assertArrayEquals(expected, input);
    }

    @Test
    void sameElementsTest(){
        int[] input = {111, 111, 111, 111, 111};
        int[] expected = {111, 111, 111, 111, 111};
        RadixSort.sort(input);

        assertArrayEquals(expected, input);
    }

    @Test
    void testAlreadySorted() {
        int[] input = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        RadixSort.sort(input);

        assertArrayEquals(expected, input);
    }

    @Test
    void testReverseSorted() {
        int[] input = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};
        RadixSort.sort(input);

        assertArrayEquals(expected, input);
    }

    @Test
    void testWithDuplicates() {
        int[] input = {3, 1, 2, 3, 1};
        int[] expected = {1, 1, 2, 3, 3};
        RadixSort.sort(input);

        assertArrayEquals(expected, input);
    }
}
