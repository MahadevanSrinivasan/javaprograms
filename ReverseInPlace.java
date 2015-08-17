public class ReverseInPlace
{
  public static char[] reverse(char[] s)
  {
    int length = s.length;
    for(int i = 0; i < length/2; i++)
    {
      char temp = s[i];
      s[i] = s[length-i-1];
      s[length-i-1] = temp;
    }
    return s;   
  }


  public static void main(String args[])
  {
    if(args.length == 0)
    {
      System.out.println("No input");
      System.exit(1);
    }
    String input = args[0];
    System.out.println("Reverse of " + input + " = " + new String(reverse(input.toCharArray())));
  }

}
