package algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import metrics.PerformanceTracker;

public class InsertionSortTest {

    @Test
    public void testEmptyArray() {
        int[] a = {};
        PerformanceTracker t = new PerformanceTracker();
        InsertionSort.sort(a, t);
        assertArrayEquals(new int[]{}, a);
    }

    @Test
    public void testSingleElement() {
        int[] a = {42};
        PerformanceTracker t = new PerformanceTracker();
        InsertionSort.sort(a, t);
        assertArrayEquals(new int[]{42}, a);
    }

    @Test
    public void testAlreadySorted() {
        int[] a = {1, 2, 3, 4, 5};
        PerformanceTracker t = new PerformanceTracker();
        InsertionSort.sort(a, t);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, a);
    }

    @Test
    public void testReverseSorted() {
        int[] a = {5, 4, 3, 2, 1};
        PerformanceTracker t = new PerformanceTracker();
        InsertionSort.sort(a, t);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, a);
    }

    @Test
    public void testRandomArray() {
        int[] a = {3, 1, 4, 1, 5, 9};
        int[] expected = a.clone();
        Arrays.sort(expected);

        PerformanceTracker t = new PerformanceTracker();
        InsertionSort.sort(a, t);

        assertArrayEquals(expected, a);
    }
}
