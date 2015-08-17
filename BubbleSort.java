import java.util.*;

public class BubbleSort
{
  public static int[] Sort(int[] a)
  {
    int length = a.length;
    int exchanges;
    for(int i = 0; i < length; i++)
    {
      exchanges = 0;
      for(int j = 0; j < length-1-i; j++)
      {
        if(a[j] > a[j+1])
        {
          int temp = a[j];
          a[j] = a[j+1];
          a[j+1] = temp;
          exchanges++;
        }
      }
      System.out.print("Iteration " + (i+1) + ": ");
      System.out.print("Exchanges = " + exchanges + " ");
      printArray(a);
    }
   return a;
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
      Sort(a);
      printArray(a);
    }
  }
}
