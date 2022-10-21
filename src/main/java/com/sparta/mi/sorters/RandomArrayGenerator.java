package com.sparta.mi.sorters;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

//Produces random array using scanner for array size
public class RandomArrayGenerator {

    public static int[] generateArray(int chosenArraySize) {
        int[] randomArray = new int[chosenArraySize];
        Random random = new Random();

        for (int i = 0; i < chosenArraySize; i++) {
            randomArray[i] = random.nextInt(1000);
        }

        return randomArray;
    }

}