import java.util.Random;

public class SortCompare
{
    public static void main(String[] args)
    {
        int[] test = genArray(10);
        printArray(test);       
    }

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
