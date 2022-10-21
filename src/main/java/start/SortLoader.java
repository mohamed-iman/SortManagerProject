package start;

import com.sparta.mi.display.DisplayManager;
import com.sparta.mi.exceptions.SorterLoaderException;
import com.sparta.mi.sorters.*;

import java.util.*;

public class SortLoader {
    public static void start() {

        System.out.println("Enter the number of the sorter you want to use:");
        System.out.println("1. BinarySorter");
        System.out.println("2. BubbleSorter");
        System.out.println("3. MergeSorter");

        Scanner scanner = new Scanner(System.in);
        int chosenNumber = scanner.nextInt();
        DisplayManager.displayRunner(chosenNumber);

        try {
            System.out.println("Enter size of array you want to generate:");
            Scanner scanner2 = new Scanner(System.in);
            int chosenArraySize = scanner2.nextInt();

            //Generate random Array based on input
            DisplayManager.displayBeforeSorting(chosenArraySize);

            //Return sorted array using chosen method
            DisplayManager.displayAfterSorting(chosenNumber, chosenArraySize);
        } catch (SorterLoaderException e) {
            System.out.println(e.getMessage());
            start(); //Restarts program
        }
    }
}
