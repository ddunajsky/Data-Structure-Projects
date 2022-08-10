import java.util.Random;

public class SortCompare
{
    public static void main(String[] args)
    {
        int[] test = genArray(10);
        printArray(test);
        insertionSort(test);
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
