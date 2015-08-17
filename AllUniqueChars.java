import java.util.*;

public class AllUniqueChars
{
  public static void main(String args[])
  {
    Boolean isUnique = true;
    if(args.length != 0)
    {
      String input = args[0];

      HashMap<Character, Boolean> mapOfChars = new HashMap<Character, Boolean>();
      for(int i = 0; i < input.length(); i++)
      {
        if(mapOfChars.containsKey(input.charAt(i)))
        {
          isUnique = false;
          break;
        }
        else
        {
          mapOfChars.put(input.charAt(i), true);
        }
      }
    }
    if(isUnique)
      System.out.println("Unique");
    else
      System.out.println("Not Unique");
  }
}
