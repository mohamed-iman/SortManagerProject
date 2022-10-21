package com.sparta.mi.display;

import com.sparta.mi.exceptions.SorterLoaderException;
import com.sparta.mi.sorters.RandomArrayGenerator;
import com.sparta.mi.sorters.Sortable;
import org.junit.jupiter.api.Test;
import start.SortFactory;

import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DisplayManager {
//To implement MVC - move print statements from sortLoader to this class
//Add timers here
    public static void displayRunner (int chosenNumber) {

        switch (chosenNumber) {
            case 1 -> {
                System.out.println("You have chosen the BinarySort method");
                ;
            }
            case 2 -> {
                System.out.println("You have chosen the BubbleSort method");
                ;
            }
            case 3 -> {
                System.out.println("You have chosen the MergeSort method");
            }
            default -> throw new SorterLoaderException();
        }
    }

    public static void displayBeforeSorting(int chosenArraySize){
        System.out.println("Here is the unsorted array generated:");
        System.out.println(Arrays.toString(RandomArrayGenerator.generateArray(chosenArraySize)));
    }

    public static void displayAfterSorting(int chosenNumber, int chosenArraySize){
        System.out.println("Here is the sorted array:");
        long startTime = System.nanoTime();
        Sortable sortArray = SortFactory.getChosenMethod(chosenNumber);
        long endTime = System.nanoTime();
        System.out.println(sortArray.getSortedArray(RandomArrayGenerator.generateArray(chosenArraySize)));
        System.out.println("Time taken = " + (endTime-startTime) + "ns");
    }
}

