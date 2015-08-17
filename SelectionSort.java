import java.util.*;

public class SelectionSort
{
  public static void Sort(int[] a)
  {
    int length = a.length;
    int minLoc;
    for(int i = 0; i < length; i++)
    {
      minLoc = i;
      for(int j = i; j < length; j++)
      {
        if(a[minLoc] > a[j])
        {
          minLoc = j;
        }
      }
      int temp = a[i]; a[i] = a[minLoc]; a[minLoc] = temp;
      System.out.print("Iteration " + (i+1) + ": "); printArray(a);
    }
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
