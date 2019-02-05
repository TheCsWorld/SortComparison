import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author
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
    	//assertTrue(Arrays.equals(expectedResult, SortComparison.insertionSort(a)));
    	assertTrue(Arrays.equals(expectedResult, SortComparison.mergeSortIterative(a)));
    }
    
    @Test
    public void testInsertionSort()
    {
    	double[] expectedResult = {2.0, 5.0, 6.0, 8.0};
    	double[] a = {6.0, 2.0, 8.0, 5.0};
    	//System.out.println(Arrays.toString(a));
    	assertTrue(Arrays.equals(expectedResult, SortComparison.insertionSort(a)));
    }
    
    @Test
    public void testSelectionSort()
    {
    	double[] expectedResult = {1.0, 4.0, 7.0, 9.0};
    	double[] a = {9.0, 4.0, 1.0, 7.0};
    	System.out.println(Arrays.toString(a));
    	System.out.println(Arrays.toString(SortComparison.selectionSort(a)));
    	assertTrue(Arrays.equals(expectedResult, SortComparison.selectionSort(a)));
    }
    
    @Test
    public void testMergeSortRecursive()
    {
    	double[] expectedResult = {1.0, 4.0, 7.0, 9.0, 12.0, 15.0};
    	double[] a = {9.0, 4.0, 15.0, 1.0, 7.0, 12.0};
    	System.out.println(Arrays.toString(a));
    	System.out.println(Arrays.toString(SortComparison.mergeSortRecursive(a)));
    	assertTrue(Arrays.equals(expectedResult, SortComparison.mergeSortRecursive(a)));
    }
    
    @Test
    public void testMergeSortIterative()
    {
    	double[] expectedResult = {1.0, 4.0, 7.0, 9.0, 12.0, 15.0};
    	double[] a = {9.0, 4.0, 15.0, 1.0, 7.0, 12.0};
    	System.out.println(Arrays.toString(a));
    	System.out.println(Arrays.toString(SortComparison.mergeSortIterative(a)));
    	assertTrue(Arrays.equals(expectedResult, SortComparison.mergeSortIterative(a)));
    }
    
    
    @Test
    public void testQuickSort()
    {
    	double[] expectedResult = {1.0, 4.0, 7.0, 9.0, 12.0, 15.0};
    	double[] a = {9.0, 4.0, 15.0, 1.0, 7.0, 12.0};
    	System.out.println(Arrays.toString(a));
    	System.out.println(Arrays.toString(SortComparison.quickSort(a)));
    	assertTrue(Arrays.equals(expectedResult, SortComparison.quickSort(a)));
    }


    // TODO: add more tests here. Each line of code and ech decision in Collinear.java should
    // be executed at least once from at least one test.

    // ----------------------------------------------------------
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     *
     */
    public static void main(String[] args)
    {
        //TODO: implement this method
    }

}
