import static org.junit.Assert.assertEquals;

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
   // @Test
    public void testEmpty()
    {
    	int expectedResult = 0;
    	double [] a = {};
    	assertEquals("insertionSort failed with empty array", expectedResult, SortComparison.insertionSort(new double[0]));
    }
    
    @Test
    public void testInsertionSort()
    {
    	double[] expectedResult = {2.0, 5.0, 6.0, 8.0};
    	double[] a = {6.0, 2.0, 8.0, 5.0};
    	assertEquals("insertionSort sorted", expectedResult, SortComparison.insertionSort(a));
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
