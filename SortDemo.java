import java.util.*;

public class SortDemo
{
  public static void restore(int[] a, int [] b)
  {
    for(int i = 0; i < a.length; i++)
      a[i] = b[i];
  }

  public static void printArray(int[] a)
  {
    if(a.length > 50)
      return;
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
      int[] b = new int[numOfElems];
      
      Random rand = new Random();
      for(int i = 0; i < numOfElems; i++)
      {
        a[i] = rand.nextInt(100);
        b[i] = a[i];
      }
      System.out.println("Input Array");
      printArray(a);
      System.out.println("Merge Sorting...");
      long startTime = System.nanoTime();
      MergeSort m = new MergeSort();
      m.sort(a);
      long endTime = System.nanoTime();
      printArray(a);
      double duration = (endTime - startTime) / 1000000.0;
      System.out.format("Time taken = %f ms\n", duration);

      restore(a, b);
      System.out.println("Input Array");
      printArray(a);
      System.out.println("Quick Sorting...");
      startTime = System.nanoTime();
      QuickSort q = new QuickSort();
      q.sort(a);
      endTime = System.nanoTime();
      printArray(a);
      duration = (endTime - startTime) / 1000000.0;
      System.out.format("Time taken = %f ms\n", duration);


      restore(a, b);
      System.out.println("Input Array");
      printArray(a);
      System.out.println("Selection Sorting...");
      startTime = System.nanoTime();
      SelectionSort s = new SelectionSort();
      s.sort(a);
      endTime = System.nanoTime();
      printArray(a);
      duration = (endTime - startTime) / 1000000.0;
      System.out.format("Time taken = %f ms\n", duration);

    }
    else
    {
      System.out.println("Usage: java SortDemo <numberOfElements>");
      System.out.print("Given the number of elements (N), this program");
      System.out.println(" generates N random numbers and sorts them using different sorting techniques");
    }
  }
}
