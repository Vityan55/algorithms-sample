package org.example.vityan55.sortSample;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SelectionSortTest {
    @Test
    void commonSort(){
        Integer[] input = {5, 3, 8, 1, 2};
        Integer[] expected = {1, 2, 3, 5, 8};
        SelectionSort.sort(input);

        assertArrayEquals(expected, input);
    }

    @Test
    void emptyTest(){
        Integer[] input = {};
        Integer[] expected = {};
        SelectionSort.sort(input);

        assertArrayEquals(expected, input);
    }

    @Test
    void oneElementTest(){
        Integer[] input = {5};
        Integer[] expected = {5};
        SelectionSort.sort(input);

        assertArrayEquals(expected, input);
    }

    @Test
    void sameElementsTest(){
        Integer[] input = {5, 5, 5, 5, 5};
        Integer[] expected = {5, 5, 5, 5, 5};
        SelectionSort.sort(input);

        assertArrayEquals(expected, input);
    }

    @Test
    void negativeElementsTest(){
        Integer[] input = {-5, -3, -8, -1, -2};
        Integer[] expected = {-8, -5, -3, -2, -1};
        SelectionSort.sort(input);

        assertArrayEquals(expected, input);
    }

    @Test
    void testAlreadySorted() {
        Integer[] input = {1, 2, 3, 4, 5};
        Integer[] expected = {1, 2, 3, 4, 5};
        SelectionSort.sort(input);

        assertArrayEquals(expected, input);
    }

    @Test
    void testReverseSorted() {
        Integer[] input = {5, 4, 3, 2, 1};
        Integer[] expected = {1, 2, 3, 4, 5};
        SelectionSort.sort(input);

        assertArrayEquals(expected, input);
    }

    @Test
    void testWithDuplicates() {
        Integer[] input = {3, 1, 2, 3, 1};
        Integer[] expected = {1, 1, 2, 3, 3};
        SelectionSort.sort(input);

        assertArrayEquals(expected, input);
    }

    @Test
    void testStringsIgnoreCase() {
        String[] input = {"Pear", "apple", "Orange"};
        String[] expected = {"apple", "Orange", "Pear"};
        SelectionSort.sort(input, String.CASE_INSENSITIVE_ORDER);

        assertArrayEquals(expected, input);
    }

    @Test
    void testStringsWithoutIgnoreCase() {
        String[] input = {"Pear", "apple", "Orange"};
        String[] expected = {"Orange", "Pear", "apple"};
        SelectionSort.sort(input);

        assertArrayEquals(expected, input);
    }

    @Test
    void doubleTest(){
        Double[] input = {5.9, 3.3, 8.4, 1.24, 2.32, 1.55};
        Double[] expected = {1.24, 1.55, 2.32, 3.3, 5.9, 8.4};
        SelectionSort.sort(input);

        assertArrayEquals(expected, input);
    }
}
