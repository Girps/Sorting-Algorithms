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
       quickSort(array,0,array.length-1);
       //insertSort(array); 
       //bubbleSort(array);
       printArray(array);

       
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
