import java.util.*;

public class MergeSort 
{
  private int[] a;
  private int[] b;

  public void sort(int[] input)
  {
    a = input;
    b = new int[input.length];
    sort(0, input.length-1);
  }

  private void merge(int left, int right, int rightEnd)
  {
    int k = left;
    int leftEnd = right - 1;
    int num = rightEnd - left + 1;
    while(left <= leftEnd && right <= rightEnd)
    {
      if(a[left] < a[right])
      {
        b[k++] = a[left++];
      }
      else
      {
        b[k++] = a[right++];
      }
    }

    while(left <= leftEnd)
      b[k++] = a[left++];
    
    while(right <= rightEnd)
      b[k++] = a[right++];

    for(int i = 0; i < num; i++)
    {
      a[rightEnd] = b[rightEnd];
      rightEnd--;
    }
  }

  private void sort(int lo, int hi)
  {
    if(lo < hi)
    {
      int mid = (lo + hi) / 2;
      sort(lo, mid);
      sort(mid+1, hi);
      merge(lo, mid+1, hi);
    }
  }
}
