import java.io.*;
import java.util.*; 

public class HoffmanFractionTester
{
	public static void main(String [] args)
	{
		Random r = new Random(17);
		Fraction[] fArr = new Fraction[10]; // creating an array of fractions
		for (int i = 0; i<10; i++)
		{
			fArr[i] = new Fraction (1+r.nextInt(20), 1+r.nextInt(20)); // numerator will be a number between 1-20, denominator will be from 1-20
		}
		for (Fraction f: fArr)
		{
		System.out.println(f);
		}
		//Arrays.sort(fArr);
	}
}