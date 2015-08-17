import java.util.*;

public class BubbleSort
{
  public static int[] Sort(int[] a)
  {
    int length = a.length;
    for(int i = 0; i < length; i++)
    {
      for(int j = 0; j < length-1-i; j++)
      {
        if(a[j] > a[j+1])
        {
          int temp = a[j];
          a[j] = a[j+1];
          a[j+1] = temp;
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

