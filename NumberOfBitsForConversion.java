public class NumberOfBitsForConversion
{

  public static void main(String args[])
  {
    if(args.length == 2)
    {
      int i = Integer.parseInt(args[0]);
      int j = Integer.parseInt(args[1]);
      int k = (i ^ j);
      System.out.println("i = " + Integer.toString(i, 2) + " j = " + Integer.toString(j, 2) + " i & j = " + Integer.toString(k,2));
      int diff = 0;
      int mask = 1;
      while(k > 0)
      {
        if((k & mask) > 0)
          diff++;
        k = k >> 1;
      }
      System.out.println("Bit difference = " + diff);
    }
    else
    {
      System.out.println("Usage: NumberOfBitsForConversion <number1> <number2>");
    }
  }
}
