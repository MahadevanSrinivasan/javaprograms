import java.util.*;

public class BinarySearch
{
  public static int BinarySearch(int[] elements, int searchElem)
  {
    int hi = elements.length;
    int lo = 0;
    int count = 0;
    while (lo <= hi)
    {
      int mid = lo + ((hi - lo) / 2);
      if(searchElem < elements[mid])
        hi = mid - 1;
      else if(searchElem > elements[mid])
        lo = mid + 1;
      else
      {
        System.out.println("Number of searches = " + count);
        return mid;
      }
      count = count + 1;
    }
    System.out.println("Number of searches = " + count);
    return -1;
  }

  public static void main(String args[])
  {
    int[] inputArr = {17, 20, 26, 31, 44, 54, 55, 65, 77, 93};
    for(int i = 0; i < inputArr.length; i++)
    {
      System.out.println("Location of " + inputArr[i] + " = " + BinarySearch(inputArr, inputArr[i]));
    }
    System.out.println("Location of 34 " + " = " + BinarySearch(inputArr, 34));
  }

}
