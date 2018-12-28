import java.io.*;
import java.util.*;


class NumberOutOfRangeException extends Exception
{
	public NumberOutOfRangeException(String input)
		{
			System.out.println(input);
		}
} // end extends class
public class Project11
{
	public static void main(String[] args)
	{
		Scanner kbd = new Scanner(System.in);
		int number = 0;
		do
		{
			System.out.print("Enter int in range 1..100 inclusive: ");
		try
		{
		number=kbd.nextInt();
		if(number<1 || number>100)
		{
			throw new NumberOutOfRangeException("Number out of range. Must be in 1..100");
		}
		break;
		} // end try 
		
		catch(InputMismatchException e) // jumps in here if you enter "tim" (not a number)
		{
			System.out.println("Input was not an integer");
			kbd.nextLine(); // must do for this case
		}
		
		catch(NumberOutOfRangeException e) // will go here if NumberOutOfRangeException thrown
		{
			
		}
		catch(Exception e) // catches other
		{
			System.out.println(e);
			System.exit(0);
		}
		
		} while(number <1 || number >100);
		
		//kbd.nextLine();
		System.out.format("\nThank you. You entered %d\n", number);
	} // end main
} // end CLASS
