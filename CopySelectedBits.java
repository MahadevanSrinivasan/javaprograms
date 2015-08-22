import java.util.*;

public class CopySelectedBits
{

  public static void main(String args[])
  {
    Scanner in = new Scanner(System.in);
    System.out.println("Enter the first number");
    int M = in.nextInt();
    System.out.println("Enter the second number");
    int N = in.nextInt();
    System.out.println("Enter the left digit");
    int i = in.nextInt();
    System.out.println("Enter the right digit");
    int j = in.nextInt();
    
    System.out.format("M = %s, N = %s, i = %d, j = %d\n", Integer.toString(M,2), Integer.toString(N,2), i, j);

    /* Zeroing out bits i to j in N */
    int mask = 0;
    for(int k = i; k <= j; k++)
      mask = mask | (1 << k);
    N = N & ~mask;
    
    N = (M << i) | N;

    System.out.format("N = %s\n", Integer.toString(N, 2));
  }
}
