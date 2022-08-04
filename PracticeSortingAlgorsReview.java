/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicesortingalgorsreview;

/**
 *
 * @author Jesse
 */
public class PracticeSortingAlgorsReview {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       int[] array = {1,4,6,2,5,6,10};
       printArray(array);
       mergeSort(array,0,array.length-1); 
       System.out.printf("\nIndex: %d",binarySearch(array,2)); 
       
//quickSort(array,0,array.length-1);
       
       //insertSort(array); 
       //bubbleSort(array);
       printArray(array);

       
    }
    
    public static int binarySearch(int[] arr, int target)
    {
        int min = 0; 
        int max = arr.length; // max
        int mid = 0; 
        
        // Search until max is less than min
        while( min <= max)
        {
            mid = (min + max)/ 2; 
            
            // case one we found the element
            if(target == arr[mid])
            {
                return mid;  
            } // case 2 element is less than mid
            else if(target < arr[mid])
            {
                max = mid; 
            } //case 3 element is greater than mid
            else
            {
                min = mid+1; 
            }
        }
            return -1; 
        
    }
    
    
    public static boolean linearSearch(int[] arr, int target)
    {
        for(int i =0; i < arr.length; ++i)
        {
            if(target == arr[i]){return true;}
        }
        // not found 
        return false;
    }
    
    
    public static void mergeSort(int[] arr, int min, int max)
    {
        if(min < max) // length must be greater than or backtrack
        {
            int mid = ((max + min) / 2);
            mergeSort(arr,min,mid); // partition leftside
            mergeSort(arr, (mid+1), max); // partition rightside
            merge(arr,min,mid,max);// merge method sorts our subsets when returnng
        }
    }
    
    private static void merge(int[] arr, int min, int mid, int max)
    {
        int Lstart = min; // start 
        int Lend = mid; 
        int Rstart = (mid+1); 
        int Rend = max; 
        
        // temp array to fill in our elements 
        int[] temp = new int[arr.length]; 
        int tempStart = Lstart; 
        // copy data to array unitl on subsets is finished 
        while(Lstart <= Lend && Rstart <= Rend)
        {
            // if Left element smaller put in temp inc k and L
            if(arr[Lstart] <= arr[Rstart])
            {
                temp[tempStart++] = arr[Lstart++]; 
            }
            else // Right elem smaller put in temp 
            {
                temp[tempStart++] = arr[Rstart++]; 
            }
        }
        // One of lists still have elements to copy 
        while(Lstart <= Lend)
        {
            temp[tempStart++] = arr[Lstart++]; 
        }
        
        // Copy right to temp
        while(Rstart <= Rend)
        {
            temp[tempStart++] = arr[Rstart++]; 
        }
        
        for(int i = min; i <= max;++i)
        {
            arr[i] = temp[i]; 
        }
    }
    
    /*Recursive method, bases cases when arr is 1 or less terminate
        other wise use helper method partion to reduce list into sublists \
            quickSort recursive calls its self twice */ 
    public static void quickSort(int[] arr, int min,int max)
    {
        // do recusion if min is less than max
            if(min < max)
            {
                int pivot = partion(arr,min,max);  // get partation first
                quickSort(arr,min, pivot-1); // sort left side 
                quickSort(arr,pivot+1,max); //sort right side
            }
        
    }
    
    // Method returns partion index to recursive method quicksort
    private static int partion(int[] arr, int min, int max)
    {
        // pick min as pivot
        int pivot = arr[min]; 
        int left = min; 
        int right = max; 
        // swap left and right side array depending on the privot values \
        while(left < right)
        {
           // Trav left array until elem bigger than pivot is found
            while(arr[left] <= pivot && left < right)
            {
                ++left; 
            }
            
            //Traverse right array until element less than pivot is found  
            while(arr[right]  > pivot)
            {
                --right; 
            }
            // We found indexes to swap
            
            // Swap the elements 
            if(left < right)
            {
            int temp = arr[left]; 
            arr[left] = arr[right]; 
            arr[right] = temp;
            }
        } 
        // swap pivot to original its positon
            int temp = arr[right]; 
            arr[right] = arr[min]; 
            arr[min] = temp; 
        return right; 
    }
    
    
    // Insert sort algo
    public static void insertSort(int[] arr)
    {   
        // Outter loop holds poistion of element to insert 
        for(int i =1; i < arr.length; ++i)
        {
            int data = arr[i]; 
            int position = i;
            // Now check each (i-1) position iterate 
            // Through sorted part of the array compare 
            // And then sort the (i) element to  until 0 is reached 
            // or smaller element is reached
            while(position > 0 && arr[position-1] > data)
            {
                // if pior data is bigger swap 
                arr[position] = arr[--position]; 
                arr[position] = data; 
            }
        }
    }
    
    
    // Prints elements of the array
    public static void printArray(int[] arr)
    {
        System.out.println(); 
        for(int i = 0; i < arr.length; ++i)
        {
            System.out.print(arr[i] + " "); 
        }
    }
    
    public static void bubbleSort(int[] arr)
    {
           // outter loop controls poisiton 
        // of element that will move
        for(int i =arr.length-1; i >= 0; --i)
        {
            // Inner loop moves our element by i index 
            for(int j = 0; j < i; ++j )
            {
                if(arr[j] > arr[ (j + 1)]  )
                {
                   int temp = arr[j];
                   arr[j] = arr[(j+1)];
                   arr[(j+1)] = temp;
                }
            }
        }
    }
   
    /*Method uses selection sort to sort our array*/ 
    public static void selectionSort(int[] arr)
    {
            // 1. scan entire list find smallest value
            // 2. Exchange value with the value in first position
            // 3. Scan res of list call but first position
            // 4. Repeat step 1; 
        
          
        // Out loop holds position to data to be ovewritten 
        for(int i = 0; i < arr.length; ++i)
        {
            
            // Inner loop iterate starting from i to end 
            for(int j = i; j < arr.length; ++j)
            {
               // find min value
                if(arr[i] > arr[j])
                {
                    // now swap 
                    int temp = arr[i]; 
                    arr[i] = arr[j]; 
                   arr[j] = temp;
                }
            }
           
        }
        
    }
    
    
}
