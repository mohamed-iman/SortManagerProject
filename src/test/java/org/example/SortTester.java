package org.example;

import com.sparta.mi.sorters.Sortable;
import org.junit.jupiter.api.BeforeAll;
import start.SortFactory;

public class SortTester {

    private static Sortable sortable;

    //Before all - executed before all tests
    @BeforeAll
    public static void chooseSorter(){
        sortable = SortFactory.getChosenMethod(3);
    }
}