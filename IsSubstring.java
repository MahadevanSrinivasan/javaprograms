public class IsSubstring
{
  public static boolean IsSubstring(String s1, String subs)
  {
    if(s1.length() < subs.length())
    {
      return false;
    }
    else
    {
      int j = 0;
      for(int i = 0; (i < s1.length()) && (j < subs.length()); i++)
      {
        if(s1.charAt(i) == subs.charAt(j))
        {
          j++;
        }
        else
        {
          j = 0;
        }
      }
      if(j == subs.length())
      {
        return true;
      }
      else
      {
        return false;
      }
    }
  }

  public static void main(String[] args)
  {
    if(args.length == 2)
    {
      String s1 = args[0];
      String s2 = args[1];
      /* Using String datatype's indexOf method */
      // System.out.println("Is " + s2 + " a substring of " + s1 + "? - " + (s1.indexOf(s2) != -1));
      System.out.println("Is " + s2 + " a substring of " + s1 + "? - " + (IsSubstring(s1, s2)));
    }
    else
    {
      System.out.println("Usage: java IsSubstring <MainString> <SubString>");
    }
  }
}
