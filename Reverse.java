public class Reverse
{
  public static String reverse(String s)
  {
    if(s.length() <= 0)
      return s;
    else
      return reverse(s.substring(1)) + s.charAt(0);
  }

  public static void main(String args[])
  {
    if(args.length == 0)
    {
      System.out.println("No input");
      System.exit(1);
    }
    String input = args[0];
    System.out.println("Reverse of " + input + " = " + reverse(input));
  }

}
