# Sorting-algorithms
First assignment from csci241: data structures &amp; algorithms

This repository contains the entire first assignment's code & logic. 

The assignment's first objective is to implement the methods for insertion, merge, quick, and radix sorts in Sorts.java. This includes implementing the merge and partition helper methods for merge sort and quick sort, respectively.

The assignment's second objective is to implement the user-facing behavior described below in SortsDriver, using the
sorting methods from Sorts.java to perform the sorting. See below for details

1. Prompt the user to specify which sort to use (merge sort, quick sort, insertion sort, radix sort, or all). The user should
   be asked to enter a single letter: [m]erge, [q]uick, [i]nsertion, [r]adix, or [a]ll.
2. Prompt the user for the size of the array, n, and create an array of that size made up of integer values chosen randomly
   from [−n..n + 1].
3. If all (a) sorts is specified, the input to each sort must be identical
4. If n ≤ 20, the pre-sorted and sorted array’s contents are printed for each sort invoked
5. If n > 20, the pre-sorted and sorted array’s contents are not printed for each sort invoked
6. The count of comparisons performed is printed
