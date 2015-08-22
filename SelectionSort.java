public class SelectionSort
{
  public void sort(int[] a)
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
    }
  }
}
