import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
public class Lab10
{
	public static void main(String args[])
	{
		String file = args[0];
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			HashSet<String> set = new HashSet<>();
			boolean unique = true;
			while ((line = reader.readLine()) != null) 
			{
				boolean added = set.add(line);
			if (!added) 
			{
				unique = false;
				break;
			}
			} // end while
			if (unique) 
			{
				System.out.println("UNIQUE");
			} 
			else 
			{
				System.out.println("NOT UNIQUE");
			}
		} // end try
			catch(IOException ioe) 
			{
				ioe.printStackTrace();
			}
	}
}