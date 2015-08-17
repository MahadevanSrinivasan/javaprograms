import java.util.*;

public class IsRotation
{
  public static Boolean isSubstring(String s1, String s2)
  {
    return (s1.indexOf(s2) != -1);
  }
  public static Boolean isRotation(String s1, String s2)
  {
    String newString = s2 + s2;
    return isSubstring(newString, s1);
  }
  public static void main(String args[])
  {
    if(args.length == 2)
      System.out.println("Is " + args[0] + " a rotation of " + args[1] + "? - " + isRotation(args[0], args[1]));
  }
}
