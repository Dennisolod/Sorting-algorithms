package sort;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Queue;

public class Sorts {

   // maintains a count of comparisons performed by this Sorts object
  private int comparisonCount;

  public int getComparisonCount() {
    return comparisonCount;
  }

  public void resetComparisonCount() {
    comparisonCount = 0;
  }

  /** Sorts A[start..end] in place using insertion sort
    * Precondition: 0 <= start <= end <= A.length
    * Postcondition: array A is sorted */

  // Invariant: subarray A[0 .. i-1] is always sorted
  public void insertionSort(int[] A, int start, int end) {
    for(int i = start + 1; i < end; i++) {
      int j = i;
      int tmp = A[j];
      while(j > 0 && A[j] < A[j-1]) {
        comparisonCount = comparisonCount + 1;
        A[j] = A[j-1];
        A[j-1] = tmp;
        j--;
      }
      comparisonCount = comparisonCount + 1;
    }
  }

  /** Partitions A[start..end] around the pivot A[pivIndex]; returns the
   *  pivot's new index.
   *  Precondition: start <= pivIndex < end
   *  Postcondition: If partition returns i, then
   *  A[start..i] <= A[i] <= A[i+1..end] 
   **/

  // Invariant: pivot is always in correct position, everything left of the pivot is less than the pivot, everything
  // right of the pivot is greater than the pivot.
  public int partition(int[] A, int start, int end, int pivIndex) {
    // value for the partition tracker
    int p = start;
    //swaps the pivIndex value with the last index value for ease of sorting
    swap(A, pivIndex, end-1);
    for(int i=start; i < end-1; i++) {
      if(A[i] < A[end-1]) {
        swap(A, i, p);
        p++;
      }
      comparisonCount++;
    }
    pivIndex = p;
    swap(A, p, end-1);
    return pivIndex;
  }

  /** use quicksort to sort the subarray A[start..end] */

  // Invariant: everything to the left of the partition index is always sorted
  public void quickSort(int[] A, int start, int end) {
    if((end-start) < 2) {
      return;
    }
    int pi = start;
    int p = partition(A, start, end, pi);
    quickSort(A, start, p);
    quickSort(A, p+1, end);
  }

  /** merge the sorted subarrays A[start..mid] and A[mid..end] into
   *  a single sorted array in A. */

  // invariant: elements in subarrays [start...mid] & [mid+1...end] are collectively sorted
  public void merge(int[] A, int start, int mid, int end) {
    // int lengths
    int llen = mid - start;
    int rlen = end - mid;

    // create left & right arrays
    int[] leftArr = new int[llen];
    int[] rightArr = new int[rlen];

    // populate left array
    for(int i = 0; i < llen; i++) {
      leftArr[i] = A[start + i];
    }
    // populate right array
    for(int i = 0; i < rlen; i++) {
      rightArr[i] = A[mid + i];
    }

    int lcounter = 0;
    int rcounter = 0;

    // compares and sorts
    while(lcounter < llen && rcounter < rlen) {
      if(leftArr[lcounter] < rightArr[rcounter]) {
        A[start++] = leftArr[lcounter++];
        comparisonCount++;
      }
      else {
        A[start++] = rightArr[rcounter++];
        comparisonCount++;
      }
    }
    while(lcounter < llen) {
      A[start++] = leftArr[lcounter++];
      comparisonCount++;
    }
    while(rcounter < rlen) {
      A[start++] = rightArr[rcounter++];
      comparisonCount++;
    }
  }

  /** use mergesort to sort the subarray A[start..end] */
  public void mergeSort(int[] A, int start, int end) {
    if(end - start <= 1) {
      return;
    }

    if(start < end) {
      int half = start + (end-start)/2;

      mergeSort(A, start, half);
      mergeSort(A, half, end);
      merge(A, start, half, end);
    }
  }

  /** Sort A using LSD radix sort. */
  public void radixSort(int[] A) {
    // TODO
    // creates the 10 arrays
    ArrayList<LinkedList<Integer>> buckets = new ArrayList<LinkedList<Integer>>(10);
    for(int i = 0; i < 10; i++) {
      buckets.add(new LinkedList<Integer>());
    }
    // adds all numbers by the smallest value to make them all positive
    for(int i = 0; i < A.length; i++) {
      A[i] = A[i] + A.length;
    }
    // what digit is being looked at
    for(int d = 0; d < 10; d++) {
      for(int i = 0; i < A.length; i++) {
        int n = getDigit(A[i], d);
        buckets.get(n).add(A[i]);
      }
      // keeps trask of the index of the original array when sorting it back into it
      int index = 0;
      for(int i = 0; i < 10; i++) {
        if(!buckets.get(i).isEmpty()) {
          A[index] = buckets.get(i).getFirst();
          buckets.get(i).removeFirst();
          index++;
          i--;
        }
      }
    }
    // subtracts the same value that was added before from all numbers to turn back to original
    for(int i = 0; i < A.length; i++) {
      A[i] = A[i] - A.length;
    }
  }

  /* return the 10^d's place digit of n */
  private int getDigit(int n, int d) {
    return (n / ((int)Math.pow(10, d))) % 10;
  }

  /** swap a[i] and a[j]
   *  pre: 0 <= i, j < a.size
   *  post: values in a[i] and a[j] are swapped */
  public void swap(int[] a, int i, int j) {
    int tmp = a[i];
    a[i] = a[j];
    a[j] = tmp;
  }
}
