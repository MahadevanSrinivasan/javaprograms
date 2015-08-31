// An Easy Problem
// http://community.topcoder.com/stat?c=problem_statement&pm=13527
public class AnEasyProblem
{
  public long solve(long sum)
  {
    long h, r, min = -1, hfactor, rfactor, starth, endh, endr, startr, temp;
    starth = (long) Math.sqrt(sum);
    endh = (long) Math.floor(((Math.sqrt(8*sum+1)+1)/2));
    for(h = starth; h <= endh; h++)
    {
      hfactor = h * h;
      temp = (long) Math.floor(Math.sqrt(8*hfactor-8*sum+1));
      startr = ((long)(temp - 1)/ 2);
      endr = ((long)(temp + 1)/ 2);

      for(r = startr; r <= endr; r++)
      {
        rfactor = r*(r-1)/2;
        if((hfactor - rfactor) == sum)
        {
          if(min == -1 || min > (2*h - r))
            min = 2*h -r;
        }
      }
    }
    return min;
  }

  public static void main(String[] args)
  {
    if(args.length == 1)
    {
      AnEasyProblem a = new AnEasyProblem();
      long sum = Long.parseLong(args[0]);
      System.out.println(a.solve(sum));
    }
    else
    {
      System.out.println("Usage: java AnEasyProblem <inputNum>");
    }
  }
}
