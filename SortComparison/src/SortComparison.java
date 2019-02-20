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
	
    	QSort(a, 0, a.length-1);
    	return a;

    }//end quicksort
    
    private static int partition(double a[], int l, int h) {
    	int i = l;
    	int j = h+1;
    	double pivot = a[l];
    	while(true) {
    	while(a[++i]< pivot) {
    	if(i == h) break;
    	}
    	while(pivot < a[--j]) {
    	if(j == l) break;
    	}
    	if(i >= j) break;
    	double temp = a[i];
    	a[i] = a[j];
    	a[j] = temp;
    	}
    	a[l] = a[j];
    	a[j] = pivot;
    	return j;
    	}
    
    private static void QSort(double a[], int l, int h) {
    	if(h <= l) {
    	return;
    	}
    	int pivot = partition(a, l, h);
    	QSort(a, l, pivot-1);
    	QSort(a, pivot+1, h);
    	}

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
    	
//    	 if(a == null) 
//         { 
//             return a; 
//         }
    	 
   
         if(a.length > 1) 
         { 
             int mid = a.length / 2; 
   
             // Split left part 
             double[] left = new double[mid]; 
             for(int i = 0; i < mid; i++) 
             { 
                 left[i] = a[i]; 
             } 
               
             // Split right part 
             double[] right = new double[a.length - mid]; 
             for(int i = mid; i < a.length; i++) 
             { 
                 right[i - mid] = a[i]; 
             } 
             mergeSortIterative(left); 
             mergeSortIterative(right); 
   
             int i = 0; 
             int j = 0; 
             int k = 0; 
   
             // Merge left and right arrays 
             while(i < left.length && j < right.length) 
             { 
                 if(left[i] < right[j]) 
                 { 
                     a[k] = left[i]; 
                     i++; 
                 } 
                 else
                 { 
                     a[k] = right[j]; 
                     j++; 
                 } 
                 k++; 
             } 
             // Collect remaining elements 
             while(i < left.length) 
             { 
                 a[k] = left[i]; 
                 i++; 
                 k++; 
             } 
             while(j < right.length) 
             { 
                 a[k] = right[j]; 
                 j++; 
                 k++; 
             } 
         } 

    	return a;
		 
	
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

   
    public static double[] readFile(FileReader fr) throws IOException {
    	double[] arr;
    	
    	int i;
		String st = "";
		try {
		while ((i=fr.read()) != -1) {
		    st = st + (char)i;
		}
	    //System.out.println(st); 
	    String[] splitStr = st.split("\n");
	    //System.out.println(Arrays.toString(splitStr));
	    double[] list = new double[splitStr.length];
	    for(int count=0; count< list.length; count++) {
	    	try {
	    	list[count] = Double.parseDouble(splitStr[count]);	//not working
	    	}
	    	catch (NumberFormatException e){
	    		System.out.println("NumberFormatException");
	    	}
	    	catch(ArrayIndexOutOfBoundsException e){
	    		System.out.println("ArrayIndexOutOfBoundsException");
	    		
	    	}
	    	//System.out.println("num: " + Arrays.toString(list));
	    }
	    //System.out.println("num: " + Arrays.toString(list));
	    
	    return list;

	}catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
    	
    	return null;
    }
    
    private static double getTime(double[] arr, String type)
    {
    	double time = 0.0;
    	double startTime =0.0;
    	double endTime = 0.0;

    		switch(type) {
    		case "insertion": 
    					startTime = System.nanoTime();	
    					insertionSort(arr);
    					endTime = System.nanoTime();
    					time = endTime - startTime;
    		
    					return time/1000000;
    		case "quick":
    					startTime = System.nanoTime();
    					quickSort(arr);
    					endTime = System.nanoTime();
				  		time = endTime - startTime;

				  		return time/1000000;
    		case "mergeIt":
    				startTime = System.nanoTime();
    				mergeSortIterative(arr);
    				endTime = System.nanoTime();
    				time = endTime - startTime;

    				return time/1000000;
    				
    		case "mergeRec" :
    			startTime = System.nanoTime();
				mergeSortRecursive(arr);
				endTime = System.nanoTime();
				time = endTime - startTime;
				
				return time/1000000;
				
    		case "selection" : 
    			startTime = System.nanoTime();
				selectionSort(arr);
				endTime = System.nanoTime();
				time = endTime - startTime;
				
				return time/1000000;
    		}

    	
    	return 0.0;
    }
    
    

    @SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {

    	double time =0;
        //todo: do experiments as per assignment instructions
 
    		//read in numbers10.txt		
			FileReader fr = new FileReader("C:\\Users\\chloe\\Documents\\numbers10.txt");
			double[] arr10 = readFile(fr);
			String type ;
			
//			//insertion
//			type = "insertion";		
//			time = getTime(arr10, type);
//			System.out.println("numbers10 insertion Time:" + time);
//			
//			//quick
//			type = "quick";
//			time = getTime(arr10, type);			
//			System.out.println("numbers10 quick Time:" + time);
//			
//			//mergeIterate
//			type = "mergeIt";
//			time = getTime(arr10, type);			
//			System.out.println("numbers10 mergeIt Time:" + time);
//			
//			//mergeRecursive
//			type = "mergeRec";
//			time = getTime(arr10, type);			
//			System.out.println("numbers10 mergeRec Time:" + time);
//			
//			//selection
//			type = "selection";
//			time = getTime(arr10, type);			
//			System.out.println("numbers10 selection Time:" + time);
			
			
			//read in numbers100.txt
			fr = new FileReader("C:\\Users\\chloe\\Documents\\numbers100.txt");
			double[] arr100 = readFile(fr);
			
//			//insertion
//			type = "insertion";		
//			time = getTime(arr100, type);
//			System.out.println("numbers100 insertion Time:" + time);
//			
//			//quick
//			type = "quick";
//			time = getTime(arr100, type);			
//			System.out.println("numbers100 quick Time:" + time);
//			
//			//mergeIterate
//			type = "mergeIt";
//			time = getTime(arr100, type);			
//			System.out.println("numbers100 mergeIt Time:" + time);
//			
//			//mergeRecursive
//			type = "mergeRec";
//			time = getTime(arr100, type);			
//			System.out.println("numbers100 mergeRec Time:" + time);
//			
//			//selection
//			type = "selection";
//			time = getTime(arr100, type);			
//			System.out.println("numbers100 selection Time:" + time);
			
			
			
			//read in numbers1000.txt
			fr = new FileReader("C:\\Users\\chloe\\Documents\\numbers1000.txt");
			double[] arr1000 = readFile(fr);
			
//			//insertion
//			type = "insertion";		
//			time = getTime(arr1000, type);
//			System.out.println("numbers1000 insertion Time:" + time);
//			
//			//quick
//			type = "quick";
//			time = getTime(arr1000, type);			
//			System.out.println("numbers1000 quick Time:" + time);
//			
//			//mergeIterate
//			type = "mergeIt";
//			time = getTime(arr1000, type);			
//			System.out.println("numbers1000 mergeIt Time:" + time);
//			
//			//mergeRecursive
//			type = "mergeRec";
//			time = getTime(arr1000, type);			
//			System.out.println("numbers1000 mergeRec Time:" + time);
//			
//			//selection
//			type = "selection";
//			time = getTime(arr1000, type);			
//			System.out.println("numbers1000 selection Time:" + time);
			
			//read in numbers1000Duplicates.txt
			fr = new FileReader("C:\\Users\\chloe\\Documents\\numbers1000Duplicates.txt");
			double[] arr1000d = readFile(fr);
			type = "insertion";
			
//			//insertion
//			type = "insertion";		
//			time = getTime(arr1000d, type);
//			System.out.println("numbers1000Duplicates insertion Time:" + time);
//			
//			//quick
//			type = "quick";
//			time = getTime(arr1000d, type);			
//			System.out.println("numbers1000Duplicates quick Time:" + time);
//			
//			//mergeIterate
//			type = "mergeIt";
//			time = getTime(arr1000d, type);			
//			System.out.println("numbers1000Duplicates mergeIt Time:" + time);
//			
//			//mergeRecursive
//			type = "mergeRec";
//			time = getTime(arr1000d, type);			
//			System.out.println("numbers1000Duplicates mergeRec Time:" + time);
//			
//			//selection
//			type = "selection";
//			time = getTime(arr1000d, type);			
//			System.out.println("numbers1000Duplicates selection Time:" + time);
			
			//read in numbersNearlyOrdered1000.txt
			fr = new FileReader("C:\\Users\\chloe\\Documents\\numbersNearlyOrdered1000.txt");
			double[] arr1000n = readFile(fr);
			
//			//insertion
//			type = "insertion";		
//			time = getTime(arr1000n, type);
//			System.out.println("numbersNearlyOrdered1000 insertion Time:" + time);
//			
//			//quick
//			type = "quick";
//			time = getTime(arr1000n, type);			
//			System.out.println("numbersNearlyOrdered1000 quick Time:" + time);
//			
//			//mergeIterate
//			type = "mergeIt";
//			time = getTime(arr1000n, type);			
//			System.out.println("numbersNearlyOrdered1000 mergeIt Time:" + time);
//			
//			//mergeRecursive
//			type = "mergeRec";
//			time = getTime(arr1000n, type);			
//			System.out.println("numbersNearlyOrdered1000 mergeRec Time:" + time);
//			
//			//selection
//			type = "selection";
//			time = getTime(arr1000n, type);			
//			System.out.println("numbersNearlyOrdered1000 selection Time:" + time);
			
			
			//read in numbersReverse1000.txt
			fr = new FileReader("C:\\Users\\chloe\\Documents\\numbersReverse1000.txt");
			double[] arr1000r = readFile(fr);

//			//insertion
//			type = "insertion";		
//			time = getTime(arr1000r, type);
//			System.out.println("numbersReverse1000 insertion Time:" + time);
//			
//			//quick
//			type = "quick";
//			time = getTime(arr1000r, type);			
//			System.out.println("numbersReverse1000 quick Time:" + time);
//			
//			//mergeIterate
//			type = "mergeIt";
//			time = getTime(arr1000r, type);			
//			System.out.println("numbersReverse1000 mergeIt Time:" + time);
//			
//			//mergeRecursive
//			type = "mergeRec";
//			time = getTime(arr1000r, type);			
//			System.out.println("numbersReverse1000 mergeRec Time:" + time);
//			
//			//selection
//			type = "selection";
//			time = getTime(arr1000r, type);			
//			System.out.println("numbersReverse1000 selection Time:" + time);
			
			//read in numbersSorted1000
			fr = new FileReader("C:\\Users\\chloe\\Documents\\numbersSorted1000.txt");
			double[] arr1000s = readFile(fr);

//			//insertion
//			type = "insertion";		
//			time = getTime(arr1000s, type);
//			System.out.println("numbersSorted1000 insertion Time:" + time);
//			
//			//quick
//			type = "quick";
//			time = getTime(arr1000s, type);			
//			System.out.println("numbersSorted1000 quick Time:" + time);
//			
//			//mergeIterate
//			type = "mergeIt";
//			time = getTime(arr1000s, type);			
//			System.out.println("numbersSorted1000 mergeIt Time:" + time);
//			
//			//mergeRecursive
//			type = "mergeRec";
//			time = getTime(arr1000s, type);			
//			System.out.println("numbersSorted1000 mergeRec Time:" + time);
//			
			//selection
			type = "selection";
			time = getTime(arr1000s, type);			
			System.out.println("numbersSorted1000 selection Time:" + time);
			
			
    	  
    	   
    	  
    }
    
    


 }//end class
