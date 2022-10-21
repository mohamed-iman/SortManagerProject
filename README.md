# SortManagerProject

## How to use my sort manager:

Firstly, go to the App class in the com.sparta.mi.start folder and run the program.

The program will print a selection of 3 sorting methods and you must enter which method you would like to choose.
```java
Enter the number of the sorter you want to use:
1. BinarySorter
2. BubbleSorter
3. MergeSorter
```

Press enter after your selection.
The program will then ask you to enter the size of the array you wish to enter and you must choose a number between 1 & 1000.
```java
Enter size of array you want to generate:
```

Press enter after your selection and the program will print two arrays:
1. The first array will be the unsorted array, generated randomly using your chosen array size
2. The second array is the sorted array after implementing your chosen sorting method.

The sorted array will also include the time taken to run the program in nanoseconds.
The output will look like this:
```java
Here is the unsorted array generated:
[353, 150, 158, 370, 516]
Here is the sorted array:
[251, 615, 772, 840, 920]
Time taken = 17743100ns
```

## To add your own sort method:
1. Create a class containing your sort method within the sorters package in the com.sparta.mi file
2. Implement the Sortable interface
3. Ensure, your method implements the getSortedArray method from the interface.
4. Add your sorting method to the SortFactory, DisplayManager and SortLoader classes.
