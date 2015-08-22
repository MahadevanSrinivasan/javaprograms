import java.util.*;

public class QuickSort 
{
  private int[] input;

  public void sort(int[] a)
  {
    input = a;
    sort(0, a.length-1);
  }
    
  private void sort(int lo, int hi)
  {
    int pivot = lo;
    int i = lo;
    int j = hi;
    while(i <= j)
    {
      while(input[pivot] > input[i])
        i++;
      while(input[pivot] < input[j])
        j--;

      if(i <= j)
      {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
        i++;
        j--;
      }
    }

    if(lo < j)
      sort(lo, j);
    if(i < hi)
      sort(i, hi);
  }
}
