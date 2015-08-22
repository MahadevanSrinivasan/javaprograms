import java.util.*;

public class QuickSelect
{
  public static int select(int[] input, int k)
  {
    return select(input, 0, input.length-1, k);
  }
  public static int select(int[] input, int lo, int hi, int k)
  {
    int pivot = lo;
    int i = lo;
    int j = hi;
    if(i <= j)
    {
    while(i <= j)
    {
      while(input[pivot] > input[i])
        i++;
      while(input[pivot] < input[j])
        j--;

      if(i <= j)
      {
        int temp = input[pivot];
        input[pivot] = input[j];
        input[j] = temp;
        i++;
        j--;
      }
    }

    if(k == j)
      return input[j];
    else if(k < j)
    {
      return select(input, lo, j, k);
    }
    else
    {
     return select(input, i, hi, k);
    }
    }
    
    return -1;
  }

  public static void printArray(int[] a)
  {
    for(int i = 0; i < a.length; i++)
      System.out.print(a[i] + " ");
    System.out.println();
  }

  public static void main(String args[])
  {
    if(args.length == 1)
    {
      int numOfElems = Integer.parseInt(args[0]);
      int[] a = new int[numOfElems];
      Random rand = new Random();
      for(int i = 0; i < numOfElems; i++)
      {
        a[i] = rand.nextInt(100);
      }
      printArray(a);
      
      for(int i = 0; i < numOfElems; i++)
      { 
        System.out.println(i + "th smallest element "  + " in array = " + select(a, i));
      }
    }
  }
}
