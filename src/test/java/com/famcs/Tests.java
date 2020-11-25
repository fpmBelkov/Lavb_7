package com.famcs;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertArrayEquals;

public class Tests {

    @Test
    void testAscendingSort() throws InterruptedException {
        List<Integer> array = Arrays.asList(11, 1, 2, 4, 210, 13, 3, 7, 79, 33, 0);
        Sort sortThread = new Sort(array, (x, y)-> x - y);
        Thread newThread = new Thread(sortThread);
        newThread.start();
        newThread.join();
        assertArrayEquals(Arrays.asList(0,1,2,3,4,7,11,13,33,79,210).toArray(), sortThread.getArr().toArray());
    }

    @Test
    void testDescendingSort() throws InterruptedException {
        List<Integer> array = Arrays.asList(11, 1, 2, 4, 210, 13, 3, 7, 79, 33, 0);
        Sort sortThread = new Sort(array, (x, y)-> y - x);
        Thread newThread = new Thread(sortThread);
        newThread.start();
        newThread.join();
        assertArrayEquals(Arrays.asList(210,79,33,13,11,7,4,3,2,1,0).toArray(), sortThread.getArr().toArray());
    }

    @Test
    void testAscendingSortOfDigits() throws InterruptedException {
        List<Integer> array = Arrays.asList(11, 1, 1111, 20000);
        Sort sThread = new Sort(array,(x, y)-> Main.numberOfDigits(x) - Main.numberOfDigits(y));
        Thread newThread = new Thread(sThread);
        newThread.start();
        newThread.join();
        assertArrayEquals(Arrays.asList(1, 11, 1111, 20000).toArray(), sThread.getArr().toArray());
    }

    @Test
    void testDescendingSortOfDigits() throws InterruptedException {
        List<Integer> array = Arrays.asList(11, 1, 1111, 20000);
        Sort sThread = new Sort(array, (x, y)-> Main.numberOfDigits(y) - Main.numberOfDigits(x));
        Thread newThread = new Thread(sThread);
        newThread.start();
        newThread.join();
        assertArrayEquals(Arrays.asList(20000,1111,11,1).toArray(), sThread.getArr().toArray());
    }

}
