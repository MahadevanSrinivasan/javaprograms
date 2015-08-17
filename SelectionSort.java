import java.util.*;

public class SelectionSort
{
  public static int[] Sort(int[] a)
  {
    int length = a.length;
    for(int i = 0; i < length; i++)
    {
      for(int j = i; j < length; j++)
      {
        if(a[i] > a[j])
        {
          int temp = a[j];
          a[j] = a[i];
          a[i] = temp;
        }
      }
    }
   return a;
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
        System.out.print(a[i] + " ");
      }
      System.out.println();
      Sort(a);
      for(int i = 0; i < numOfElems; i++) 
        System.out.print(a[i] + " ");
      System.out.println();
    }
  }
}

