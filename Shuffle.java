import java.util.*;

public class Shuffle
{
  public static int[] shuffle(int[] inputArr)
  {
    Random newRandNumGen = new Random();
    int length = inputArr.length;
    for(int i = 0; i < length; i++)
    {
      /* Create a random number between i & length */
      int swapIndex = newRandNumGen.nextInt(length - i) + i;
      int temp = inputArr[swapIndex];
      inputArr[swapIndex] = inputArr[i];
      inputArr[i] = temp;
    }
    return inputArr;
  }
      
  public static void main(String args[])
  {
    int[] inputArr = new int[10];
    /* Create an integer array as an input */
    for(int i = 0; i < 10; i++)
      inputArr[i] = i;
    /* Shuffle it */
    inputArr = shuffle(inputArr);
    for(int i = 0; i < 10; i++)
      System.out.print(inputArr[i] + " ");
    System.out.println();
  }
}
