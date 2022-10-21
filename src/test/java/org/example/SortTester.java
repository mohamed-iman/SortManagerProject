package org.example;

import com.sparta.mi.sorters.BubbleSorter;
import com.sparta.mi.sorters.MergeSorter;
import com.sparta.mi.sorters.RandomArrayGenerator;
import com.sparta.mi.sorters.Sortable;
import com.sparta.mi.sorters.binaryTree.BinarySorter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import start.SortFactory;

import java.util.*;

public class SortTester {

    private final int[] randomArray = RandomArrayGenerator.generateArray(100);

    public static boolean isSorted(int[] arrayToCheck) {

        for(int i = 0; i < arrayToCheck.length - 1; i++) {
            if(arrayToCheck[i] > arrayToCheck[i+1]) {
                return false;
            }
        }
        return true;
    }


    @Test
    void checkBubbleSort() {
        BubbleSorter bubbleSort = new BubbleSorter();
        int[] testArray = new int[100];
        String bubbleSortArray = BubbleSorter.bubbleSorter(randomArray);

        for (int i=0; i<100; i++){
            testArray[i] = Integer.parseInt(bubbleSortArray);
        }
        boolean isBubbleSorterWorking = SortTester.isSorted(testArray);
        Assertions.assertTrue(isBubbleSorterWorking);
    }

}