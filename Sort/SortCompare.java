import java.util.Random;

public class SortCompare
{
    public static void main(String[] args)
    {
        //int[] test = genArray(10);
        int[] test = {-7,-6,6,2,6,3,0,0,-5,6,100000};
        printArray(test);
        int max = findMaxDigits(test);
        System.out.print(max);       
    }

    public static void selectionSort(int[] arr)
    {
        int len = arr.length;
        for(int i = 0; i < len-1; i++)
        {
            int largestNumIndex = 0;
            // length of unsorted part of array is (len - i) 
            for(int j = 1; j < (len - i); j++)
            {
                if(arr[j] > arr[largestNumIndex] )
                {
                    largestNumIndex = j;
                }
            }
            int placeForLargestNum = (len-i)-1;
            if(largestNumIndex != placeForLargestNum)
            {
                swap(arr, largestNumIndex, placeForLargestNum);
            }
        }
    }

    public static void insertionSort(int[] arr)
    {
        int len = arr.length;
        for(int i = 1; i < len; i++)
        {
            int index = i;
            while(index > 0 && arr[index] < arr[index-1])
            {
                swap(arr, index, index-1);
                index--;
            }
        }
    }

    public static void mergeSort(int[] arr)
    {

    }

    public static void merge(int[] a, int[] b)
    {
        int length = a.length + b.length;
        int[] arr = new arr[length];

        int indexA = 0;
        int indexB = 0;

        for(int i = 0; i < length; i++)
        {
            if(a[indexA] < a[indexB])
            {
                arr[i] = a[indexA];
                indexA++;
            }
            // equal case will fall here
            else
            {
                arr[i] = b[indexB];
                indexB++;
            }
        }
    }

    public static void radixSort(int[] arr)
    {
        // find max number of digits in numbers stored in arr
        int maxDigits = 2;
        int modValue = 10;
        boolean done = false;
        while()
        {

        }
        

        
    }

    // assist method for radix sort 
    public static int findMaxDigits(int[] arr)
    {
        int maxDigit = 1;
        int modValue = 10;
        boolean done = false;
        
        while(!done)
        {
            for(int i = 0; i < arr.length; i++)
            {
                // if no remainder the number is greater than the modValue -> multuply modValue by 10 -> check all numbers against new mod value 
                if(arr[i] % modValue == 0 && arr[i] != 0)
                {
                    maxDigit++;
                    modValue *= 10;
                    break;
                }
                // if it made it trough the array without breaking, all of the numbers are less than the modValue
                if(i == arr.length - 1)
                {
                    done = true;
                }
            }
        }
        return maxDigit;
    }

    // swaps values stored at the specified positions of an array 
    public static void swap(int[] arr, int p1, int p2)
    {
        int temp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = temp;
    }

    // creates array filled with random values between [-n,n]
    public static int[] genArray(int len)
    {
        int[] randArray = new int[len];
        Random rng = new Random();
        for(int i = 0; i < len; i++)
        {
            int randNum = ((rng.nextInt(2*len) + 1) - len);
            randArray[i] = randNum;
        }
        return randArray;
    }

    public static void printArray(int[] arr)
    {
        int len = arr.length;
        for(int i = 0; i < len; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
