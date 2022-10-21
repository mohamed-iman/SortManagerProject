package start;

import com.sparta.mi.sorters.BinarySorter;
import com.sparta.mi.sorters.BubbleSorter;
import com.sparta.mi.sorters.MergeSorter;
import com.sparta.mi.sorters.Sortable;

public class SortFactory {
    public static Sortable getChosenMethod(int chosenNumber) {

        return switch (chosenNumber) {
            case 1 ->new BinarySorter();
            case 2 -> new BubbleSorter();
            case 3 -> new MergeSorter();
            default -> null;
        };
    }
}
