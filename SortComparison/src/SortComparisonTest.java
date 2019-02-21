import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/*
 *   * 			    | Insert  |	 Quick 	|Merge Recursive |	Merge Iterative  |	Selection
10 random		    |0.010944 |	0.02086	|	0.016415	 |		0.016415	 |	 0.00684
100 random		    |0.453115 | 0.270501|	0.10396	 	 |		0.16996		 | 	 0.302305
1000 random		 	|17.842799|	8.031927|	1.850759	 |		1.800147	 |   8.748702
1000 few unique		|9.556443 |	4.057513|	1.484848	 |		1.68114		 |	 10.078637
1000 nearly ordered	|9.179589 |	7.944724|	1.746458	 |	    1.779287	 |   8.567457
1000 reverse order	|12.416366|	7.65986 |	1.55974		 |		7.65986		 |	 9.916542
1000 sorted			|7.160921 |	7.590097|	1.365157	 |		3.892682	 |   9.401872
 * 
 * a. Which of the sorting algorithms does the order of input have an impact on? Why?
 * Insertion sort, quicksort and mergesort iterative.
 * Insertion sort starts at the first element and compares it with each element in the array
 * until it finds one smaller and then puts the smaller one at the start and repeats the process
 * along with moving through the array until it's sorted. This is a slow process for an array with
 * many numbers.
 * Quicksort picks a pivot value and uses it to split the array into two parts, anything larger
 * than the pivot goes on the right side, anything less than pivot goes on the left. This can 
 * sort an array quickly if it is nearly sorted as there is not much work to be done.
 * Mergesort iterative iterates through an array by merging subarrays of size 2^n, n>=1 this 
 * takes  a lot of time in the case of an array in reverse order as every merging of subarrays 
 * requires them to be resorted afterwards.
 * 
 * b. Which algorithm has the biggest difference between the best and worst performance, based
 * on the type of input, for the input of size 1000? Why?
 * Insertion sort. Insertion sort starts at the first element and compares it with each element 
 * in the array until it finds one smaller and then puts the smaller one at the start and repeats
 * the process along with moving through the array until it's sorted.
 * 
 * c. Which algorithm has the best/worst scalability, i.e., the difference in performance time
 * based on the input size? Please consider only input files with random order for this answer.
 * Best: Recursive mergesort splits the array into two and is called recursively until it's sorted. 
 * Worst:Insertion sort starts at the first element and compares it with each element in the
 * array until it finds one smaller and then puts the smaller one at the start and repeats the
 * process along with moving through the array until it's sorted.
 * 
 * d. Did you observe any difference between iterative and recursive implementations of merge
 * sort? Recursive mergesort is marginally faster than iterative mergesort except in 1000 random
 * where mergesort iterative is 0.050612 milliseconds faster and in 1000 reverse order and 1000
 * sorted where recursive mergesort is  significantly faster by 6.10012 milliseonds and 
 * 2.527525 milliseconds respectively.
 * 
 * e. Which algorithm is the fastest for each of the 7 input files? 
 * Recursive mergesort. Recursive mergesort splits the array into two and is called recursively until 
 * it's sorted.
 * 
*/

//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author Chloe Conneely 17323080
 *  @version HT 2019
 */
@RunWith(JUnit4.class)
public class SortComparisonTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
        new SortComparison();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check that the methods work for empty arrays
     */
    @Test
    public void testEmpty()
    {
    	double[] expectedResult = {};
    	double [] a = {};
    	assertTrue(Arrays.equals(expectedResult, SortComparison.insertionSort(a)));
    	assertTrue(Arrays.equals(expectedResult, SortComparison.mergeSortIterative(a)));
    	assertTrue(Arrays.equals(expectedResult, SortComparison.quickSort(a)));
    	assertTrue(Arrays.equals(expectedResult, SortComparison.selectionSort(a)));
    	assertTrue(Arrays.equals(expectedResult, SortComparison.mergeSortRecursive(a)));
    }
    
    @Test
    public void testInsertionSort()
    {
    	double[] expectedResult = {2.0, 5.0, 6.0, 8.0};
    	double[] a = {6.0, 2.0, 8.0, 5.0};
    	assertTrue(Arrays.equals(expectedResult, SortComparison.insertionSort(a)));
    	
    	double[] sortedResult = {1.0, 3.0, 5.0};
    	double[] sorted = {1.0, 3.0, 5.0};
    	assertTrue(Arrays.equals(sortedResult, SortComparison.insertionSort(sorted)));
    }
    
    @Test
    public void testSelectionSort()
    {
    	double[] expectedResult = {1.0, 4.0, 7.0, 9.0};
    	double[] a = {9.0, 4.0, 1.0, 7.0};
    	System.out.println(Arrays.toString(a));
    	System.out.println(Arrays.toString(SortComparison.selectionSort(a)));
    	assertTrue(Arrays.equals(expectedResult, SortComparison.selectionSort(a)));
    	
    	double[] sortedResult = {1.0, 3.0, 5.0};
    	double[] sorted = {1.0, 3.0, 5.0};
    	assertTrue(Arrays.equals(sortedResult, SortComparison.selectionSort(sorted)));
    }
    
    @Test
    public void testMergeSortRecursive()
    {
    	double[] expectedResult = {1.0, 4.0, 7.0, 9.0, 12.0, 15.0};
    	double[] a = {9.0, 4.0, 15.0, 1.0, 7.0, 12.0};
    	System.out.println(Arrays.toString(a));
    	System.out.println(Arrays.toString(SortComparison.mergeSortRecursive(a)));
    	assertTrue(Arrays.equals(expectedResult, SortComparison.mergeSortRecursive(a)));
    	
    	double[] sortedResult = {1.0, 3.0, 5.0};
    	double[] sorted = {1.0, 3.0, 5.0};
    	assertTrue(Arrays.equals(sortedResult, SortComparison.mergeSortRecursive(sorted)));
    }
    
    @Test
    public void testMergeSortIterative()
    {
    	double[] expectedResult = {1.0, 4.0, 7.0, 9.0, 12.0, 15.0};
    	double[] a = {9.0, 4.0, 15.0, 1.0, 7.0, 12.0};
    	System.out.println(Arrays.toString(a));
    	System.out.println(Arrays.toString(SortComparison.mergeSortIterative(a)));
    	assertTrue(Arrays.equals(expectedResult, SortComparison.mergeSortIterative(a)));
    	
    	double[] sortedResult = {1.0, 3.0, 5.0};
    	double[] sorted = {1.0, 3.0, 5.0};
    	assertTrue(Arrays.equals(sortedResult, SortComparison.mergeSortIterative(sorted)));
    }
    
    
    @Test
    public void testQuickSort()
    {
    	double[] expectedResult = {1.0, 4.0, 7.0, 9.0, 12.0, 15.0};
    	double[] a = {9.0, 4.0, 15.0, 1.0, 7.0, 12.0};
    	System.out.println(Arrays.toString(a));
    	System.out.println(Arrays.toString(SortComparison.quickSort(a)));
    	assertTrue(Arrays.equals(expectedResult, SortComparison.quickSort(a)));
    	
    	double[] sortedResult = {1.0, 3.0, 5.0};
    	double[] sorted = {1.0, 3.0, 5.0};
    	assertTrue(Arrays.equals(sortedResult, SortComparison.quickSort(sorted)));
    }
    // ----------------------------------------------------------
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     *
     */
//    public static void main(String[] args)
//    {
//        //TODO: implement this method
//    }

}
