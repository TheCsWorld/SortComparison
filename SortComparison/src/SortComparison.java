import static org.junit.Assert.assertTrue;

import java.io.*; 
// -------------------------------------------------------------------------
import java.util.Arrays;

/**
 *  This class contains static methods that implementing sorting of an array of numbers
 *  using different sort algorithms.
 *
 *  @author Chloe Conneely 17323080
 *  @version HT 2019
 */

 class SortComparison {

    /**
     * Sorts an array of doubles using InsertionSort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order.
     *
     */
    static double [] insertionSort (double a[]){
    	int n = a.length; 
    	double temp;
        for (int i=1; i<n; i++) 
        { 
        	for(int j = i ; j > 0 ; j--){
        		if(a[j] < a[j-1]){
        			temp = a[j];
        			a[j] = a[j-1];
        			a[j-1] = temp;
        		}
        	}
        }
		return a; 

        
    }//end insertionsort

    /**
     * Sorts an array of doubles using Quick Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] quickSort (double a[]){
	
		 //todo: implement the sort

    }//end quicksort

    /**
     * Sorts an array of doubles using Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    /**
     * Sorts an array of doubles using iterative implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */

    static double[] mergeSortIterative (double a[]) {

    	
		 //todo: implement the sort
	
    }//end mergesortIterative
    
    
    
    /**
     * Sorts an array of doubles using recursive implementation of Merge Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     *
     * @param a: An unsorted array of doubles.
     * @return after the method returns, the array must be in ascending sorted order.
     */
    static double[] mergeSortRecursive (double a[]) {
    	
    	int n = a.length;
    	int l = 0;
    	int h = n-1;
    	double aux[] = new double[n];
    	mSortRecursive(a, aux, l, h);
    	
    	return a;

    	
	
   }//end mergeSortRecursive

    private static void mSortRecursive(double a[], double aux[], int l, int h) {
    	if(h <= l) return;
    	int mid = l + (h-l)/2;
    	mSortRecursive(a,aux, l, mid);
    	mSortRecursive(a, aux, mid+1, h);
    	mergeArr(a, aux, l, mid, h);
    }
    
    private static void mergeArr(double a[], double aux[], int l, int mid, int h) {
    	for (int i = l; i <= h; i++) {
            aux[i] = a[i];
        }
        int i = l;
        int j = mid + 1;
        int k = l;
        while (i <= mid && j <= h) {
            if (aux[i] <= aux[j]) {
                a[k] = aux[i];
                i++;
            } else {
                a[k] = aux[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            a[k] = aux[i];
            k++;
            i++;
        }
    	
    }
    	
    
    /**
     * Sorts an array of doubles using Selection Sort.
     * This method is static, thus it can be called as SortComparison.sort(a)
     * @param a: An unsorted array of doubles.
     * @return array sorted in ascending order
     *
     */
    static double [] selectionSort (double a[]){

    	int n = a.length;
    	for (int i = 0; i < n-1; i++)
    	{
    		int min_idx = i;
    		for (int j = i+1; j < n; j++) {
    			if (a[j] < a[min_idx]) {
    				min_idx = j;
    				double temp = a[min_idx];
    				a[min_idx] = a[i];
    				a[i] = temp;
    			}
    		}
    	}
		return a;
    }//end selectionsort

   


    public static void main(String[] args) {

        //todo: do experiments as per assignment instructions
    	
    	double[] expectedResult = {1.0, 4.0, 7.0, 9.0};
    	double[] a = {9.0, 4.0, 1.0, 7.0};
    	System.out.println(Arrays.toString(a));
    	System.out.println(Arrays.toString(SortComparison.mergeSortRecursive(a)));
    	System.out.println(Arrays.equals(expectedResult, SortComparison.mergeSortRecursive(a)));
    	
    	
    
    	
//    	File file = new File("SortComparison\\src\\numbers10.txt"); 
//    	  
//    	  BufferedReader br;
//		try {
//			br = new BufferedReader(new FileReader(file));
//			String st;
//			while ((st = br.readLine()) != null) {
//			    System.out.println(st); 
//		}
//		}catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
    	  
    	   
    	  
    }

 }//end class
