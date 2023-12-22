package sort;

import java.util.Random;
import java.util.Scanner;


public class SortsDriver {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter sort ([i]nsertion, [q]uick, [m]erge, [r]adix, [a]ll: ");
        String userInput = scanner.nextLine();

        System.out.print("Enter n (size of array to sort): ");
        // gets input from user
        int sizeArr = scanner.nextInt();
        int[] newArr = createRandArr(sizeArr);

        switch(userInput) {
            case "i":
                // sorts Arr and prints if newArr.length <=  20,
                // else just display comparisons
                sortArrAndPrint(newArr, userInput);
                break;

            case "q":
                // sorts Arr and prints if newArr.length <=  20,
                // else just display comparisons
                sortArrAndPrint(newArr, userInput);
                break;

            case "m":
                // sorts Arr and prints if newArr.length <=  20,
                // else just display comparisons
                sortArrAndPrint(newArr, userInput);
                break;
            case "r":
                // sorts Arr and prints if newArr.length <=  20,
                // else just display comparisons
                sortArrAndPrint(newArr, userInput);
                break;

            case "a":
                // sorts Arr using ALL of the above sorting algorithms
                // and prints if newArr.length <=  20,
                // else just display comparisons
                sortArrAndPrint(newArr, userInput);
                break;
        }
    }

    // private helper methods:


    // specification: sorts arr using string s as argument for a specific sorting algorithm.
    private static int[] sortArrAndPrint(int[] arr, String s) {
        Sorts sortAlgorithms = new Sorts();
        int[] dupe_1 = arr.clone();
        int[] dupe_2 = arr.clone();
        int[] dupe_3 = arr.clone();

        if(arr.length <= 20) {
            // prints out random array
            printArrUnsorted(arr);

            // insertion sort
            if(s.equals("i")) {
                sortAlgorithms.insertionSort(arr, 0, arr.length);
                printArrSORTED(arr);
                System.out.println("Comparisons: " + sortAlgorithms.getComparisonCount());
            }
            //merge sort
            if(s.equals("m")) {
                sortAlgorithms.mergeSort(arr, 0, arr.length);
                printArrSORTED(arr);
                System.out.println("Comparisons: " + sortAlgorithms.getComparisonCount());
            }
            // quick sort
            if(s.equals("q")) {
                sortAlgorithms.quickSort(arr, 0, arr.length);
                printArrSORTED(arr);
                System.out.println("Comparisons: " + sortAlgorithms.getComparisonCount());
            }
            // radix sort
            if(s.equals("r")) {
                sortAlgorithms.radixSort(arr);
                printArrSORTED(arr);
                System.out.println("Comparisons: " + sortAlgorithms.getComparisonCount());
            }
            // all
            if(s.equals("a")) {

                // call all of the sorting algorithms, print counter, and sorted array and reset comparison counter:
                // insertion sort
                sortAlgorithms.insertionSort(arr, 0, arr.length);
                System.out.println("insertion: " + sortAlgorithms.getComparisonCount());
                sortAlgorithms.resetComparisonCount();
                printArrSORTED(arr);
                System.out.println(" ");

                // merge sort
                sortAlgorithms.mergeSort(dupe_1, 0, dupe_1.length);
                System.out.println("merge: " + sortAlgorithms.getComparisonCount());
                sortAlgorithms.resetComparisonCount();
                printArrSORTED(dupe_1);
                System.out.println(" ");

                // quick sort
                sortAlgorithms.quickSort(dupe_2, 0, dupe_2.length);
                System.out.println("quick: " + sortAlgorithms.getComparisonCount() + "");
                sortAlgorithms.resetComparisonCount();
                printArrSORTED(dupe_2);
                System.out.println(" ");

                // radix sort
                sortAlgorithms.radixSort(dupe_3);
                System.out.println("radix: " + sortAlgorithms.getComparisonCount());
                sortAlgorithms.resetComparisonCount();
                printArrSORTED(dupe_3);
                System.out.println(" ");
            }
            return arr;
        }
        else {
            // insertion sort
            if(s.equals("i")) {
                sortAlgorithms.insertionSort(arr, 0, arr.length);
                System.out.println("Comparisons: " + sortAlgorithms.getComparisonCount());
            }
            // merge sort
            if(s.equals("m")) {
                sortAlgorithms.mergeSort(arr, 0, arr.length);
                System.out.println("Comparisons: " + sortAlgorithms.getComparisonCount());
            }
            // quick sort
            if(s.equals("q")) {
                sortAlgorithms.quickSort(arr, 0, arr.length);
                System.out.println("Comparisons: " + sortAlgorithms.getComparisonCount());
            }
            // radix sort
            if(s.equals("r")) {
                sortAlgorithms.radixSort(arr);
                System.out.println("Comparisons: " + sortAlgorithms.getComparisonCount());
            }
            if(s.equals("a")) {
                // insertion sort
                sortAlgorithms.insertionSort(arr, 0, arr.length);
                System.out.println("insertion: " + sortAlgorithms.getComparisonCount());
                sortAlgorithms.resetComparisonCount();

                sortAlgorithms.mergeSort(dupe_1, 0, dupe_1.length);
                System.out.println("merge: " + sortAlgorithms.getComparisonCount());
                sortAlgorithms.resetComparisonCount();

                sortAlgorithms.quickSort(dupe_2, 0, dupe_2.length);
                System.out.println("quick: " + sortAlgorithms.getComparisonCount());
                sortAlgorithms.resetComparisonCount();

                sortAlgorithms.radixSort(dupe_3);
                System.out.println("radix: " + sortAlgorithms.getComparisonCount());
                sortAlgorithms.resetComparisonCount();
            }
            return arr;
        }
    }

    // specification: creates a random array of length size and uses -size and +size to determine min/max values
     private static int[] createRandArr(int size) {
        int min = -size;
        int max = size;
        int[] arr = new int[size];
        Random rand = new Random();

        // generates array
        for(int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(max - min + 1) + min;
        }
        return arr;
    }

    // specification: prints the unsorted array
     private static void printArrUnsorted(int[] arr) {
             System.out.print("Unsorted: [");
             for(int i = 0; i < arr.length; i++) {
                 System.out.print(" " + arr[i] + " ");
             }
             System.out.println("]");
     }

    // specification: prints the sorted array
     private static void printArrSORTED(int[] arr) {
         System.out.print("Sorted: [");
         for(int i = 0; i < arr.length; i++) {
             System.out.print(" " + arr[i] + " ");
         }
         System.out.println("]");
     }

}