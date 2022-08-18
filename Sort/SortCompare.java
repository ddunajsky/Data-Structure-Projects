import java.util.Random;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

public class SortCompare
{
    public static void main(String[] args)
    {
        int[] test = genArray(20);
        printArray(test);
        radixSort(test);
        printArray(test);      
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
 
    public static int[] radixSort(int[] arr)
    {
        int maxDigits = findMaxDigits(arr);
        // create buckets
        Queue<Integer>[] buckets = new Queue[10];
        for(int i = 0; i < 10; i++)
        {
            buckets[i] = new LinkedList<Integer>();
        }

        int length = arr.length;
        // repeat for each digit
        for(int j = 0; j < maxDigits; j++)
        {
            for(int k = 0; k < length; k++)
            {
                // get the 'j' digit
                int divisor = (int) Math.pow(10, j);
                int whichBucket = Math.abs(((arr[k] / divisor)%10));
                // add to correct list
                buckets[whichBucket].add(arr[k]);
            }
            // pop values back into arr
            int index = 0;
            for(int z = 0; z <= 9; z++)
            {
                while(!buckets[z].isEmpty())
                {
                    arr[index] = buckets[z].remove();
                    index++;
                }
            }
            
        }
        dealWithNegatives(arr);
        return arr;      
    }

    // fixes negative numbers in Radix Sort
    public static void dealWithNegatives(int[] arr)
    {
        int length = arr.length;
        Stack<Integer> negNums = new Stack<Integer>();
        Queue<Integer> posNums = new LinkedList<Integer>();
        
        for(int i = 0; i < length; i++)
        {
            if(arr[i] < 0)
            {
                negNums.push(arr[i]);
            }
            else
            {
                posNums.add(arr[i]);
            }
        }

        int index = 0;
        while(!negNums.empty())
        {
            arr[index] = negNums.pop();
            index++;
        }
        while(!posNums.isEmpty())
        {
            arr[index] = posNums.remove();
            index++;
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
