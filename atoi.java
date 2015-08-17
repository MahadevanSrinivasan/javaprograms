import java.util.*;

public class atoi
{
  public static int atoi(String inputNum)
  {
    int outputNum = 0;
    int sign = 1;
    /* Handle sign */
    for(int i = 0; i < inputNum.length(); i++)
    {
      char currentChar = inputNum.charAt(i);
      if(i == 0 && currentChar == '-')
        sign = -1;
      else
      {
        if(currentChar >= 48 && currentChar <= 57)
          outputNum = outputNum * 10 + ((int) currentChar - 48);
        else
        {
          throw new IllegalArgumentException(); 
        }
      }
    }
    return sign * outputNum;
  }

  public static void main(String args[])
  {
    if(args.length == 1)
      System.out.println(atoi(args[0]));
  }
}
