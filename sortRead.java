// Isaac Shoma
// Assignment 2

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class sortRead {
    public static void main(String[] args) throws FileNotFoundException {
        int[] array = items();

        // Call and print the quickSort Method
        quickSort(array, 0, array.length - 1);
        printArray(array);
    }

    // Create Items method, initialize integer length and count
    // Scan the file
    // iterate through every integer using scan function
    private static int[] items() throws FileNotFoundException {
        int[] array = new int[10000];
        int numberLength = 10000;
        Scanner scan = new Scanner(new File("item.txt"));

        for (int i = 0; i < numberLength; i++) {
            array[i] = scan.nextInt();
        }
        return array;
    }

    // quickSort method, call the quickSort method from the partition method
    private static void quickSort(int[] array, int lowIndex, int highIndex) {
        if (lowIndex < highIndex) {
            int pivotIndex = partition(array, lowIndex, highIndex);

            quickSort(array, lowIndex, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, highIndex);
        }
    }

    // Declare both pointers, create a loop that will move the left index and right index until they meet
    private static int partition(int[] array, int lowIndex, int highIndex) {
        int pivot = array[highIndex];
        int leftPointer = lowIndex - 1;
        for (int rightPointer = lowIndex; rightPointer < highIndex; rightPointer++) {
            // Once hits pivot, swap
            if (array[rightPointer] <= pivot) {
                leftPointer++;
                swap(array, leftPointer, rightPointer);
            }
        }
        // Call the swap method
        swap(array, leftPointer + 1, highIndex);
        return leftPointer + 1;
    }

    // Create swap method, create variables for the array with elements, and indexes we want to swap
    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    // Print results
    // Iterate through the array in the order of the sort
    private static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

