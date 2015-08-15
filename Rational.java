import java.util.*;
public class Rational
{
	private static final int MAX_TRIES = 10000;
	public static void main(String args[])
	{
		int num, den;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Numerator:");
		num = s.nextInt();
		System.out.println("Enter Denominator:");
		den = s.nextInt();
		double actualRatio = (double) num / den;
		int integerPart = (int) actualRatio;
		double decimalPart = actualRatio - integerPart;
		double runningValue = decimalPart;
		int i = 0;
		while(i < MAX_TRIES)
		{
			runningValue = runningValue * 10;
			double checkValue = Math.abs(runningValue - decimalPart - (int)runningValue);
			if(checkValue < 0.001)
			{
				System.out.println("Done in " + i + " iterations");
				System.out.println("DecimalPart = " + ((int) runningValue) / Math.pow(10, i+1));
				break;
			}
			i++;
		}
		if(i == MAX_TRIES)
		{
			System.out.println("Taking too long bailing out!");
		}
	}
}
