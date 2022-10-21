package com.sparta.mi.sorters;


import com.sparta.mi.logging.CustomConfigureLogger;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MergeSorter implements Sortable {
    public static final Logger logger = Logger.getLogger("Mergesort-logger");

    @Override
    public String getSortedArray(int[] array) {
        return Arrays.toString(MergeSorter.mergeSorter(array));
    }

    public static int[] mergeSorter(int[] inputArray) {
        CustomConfigureLogger.configureLogger(logger);
        // If array is less than 2 return input
        int length = inputArray.length;
        if (length < 2) {
            return inputArray;
        }

        //Split input array into 2 arrays
        int middleIndex = length / 2;
        int[] leftSide = new int[middleIndex]; //left half will be larger if input array length is odd
        int[] rightSide = new int[length - middleIndex];


        //Create left array

        System.arraycopy(inputArray, 0, leftSide, 0, middleIndex);

        //Create right array
        System.arraycopy(inputArray, middleIndex, rightSide, 0, rightSide.length);

        logger.log(Level.INFO, "Left side of array is: " + Arrays.toString(leftSide));
        logger.log(Level.INFO, "Right side of array is: " + Arrays.toString(rightSide));

        leftSide = mergeSorter(leftSide);

        rightSide = mergeSorter(rightSide);


       int[] mergeSortedArray = merge(leftSide,rightSide);
        logger.log(Level.INFO, "Joining array" + Arrays.toString(mergeSortedArray));
        return mergeSortedArray;
    }

    private static int[] merge(int[] leftSide, int[] rightSide) {

        int[] result = new int[leftSide.length+rightSide.length];
        int x = 0;
        int y = 0;
        int z = 0;

        while(x < leftSide.length && y < rightSide.length) {
            if(leftSide[x] <= rightSide[y]){
                logger.log(Level.FINE, "The value of " + String.valueOf(leftSide[x]) + " is less than or equal to " + rightSide[y]);
                logger.log(Level.FINE, "Adding " + String.valueOf(leftSide[x]) + " to array");
                result[z] = leftSide[x];
                x++;
            } else {
                logger.log(Level.FINE, "The value of " + String.valueOf(rightSide[y]) + " is less than or equal to " + leftSide[x]);
                logger.log(Level.FINE, "Adding " + String.valueOf(rightSide[y]) + " to array");
                result[z] = rightSide[y];
                y++;
            }
            z++;
        }

        while(x < leftSide.length){
         result[z] = leftSide[x];
         x++;
         z++;
        }

        while(y < rightSide.length){
            result[z] = rightSide[y];
            y++;
            z++;
        }

        return result;
    }
}
