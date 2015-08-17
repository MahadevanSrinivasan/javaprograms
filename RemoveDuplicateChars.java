import java.util.*;

public class RemoveDuplicateChars
{
  public static void RemoveDups(char[] str)
  {
    System.out.println(str);
    int inputLength = str.length;
    for(int i = 0; i < inputLength; i++)
    {
      for(int j = 0; j < i; j++)
      {
        if(str[i] == str[j] && (i+1) < inputLength)
        {
          str[i] = str[i+1];
          continue;
        }
      }
    }
    System.out.println(str);
  }
  public static void main(String args[])
  {
    if(args.length > 0)
    {
      char[] inputArray = new char[args[0].length()];
      args[0].getChars(0, args[0].length(), inputArray, 0);
      //inputArray[inputArray.length - 1] = '\0';
      RemoveDups(inputArray);
    }
  }
}
