public class PowerOfTwoCheck 
{
  public static void main(String args[])
  {
    if(args.length == 1)
    {
      int n = Integer.parseInt(args[0]);
      System.out.println("Input n = " + n);
      System.out.format("n = %s, (n-1) = %s\n", Integer.toString(n,2), Integer.toString(n-1,2));
      System.out.println("n & (n-1) == 0? " + ((n & (n-1)) == 0));
    }
  }
}
