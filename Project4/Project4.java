import java.util.*;
import java.io.*;

public class Project4
{
	public static void main (String[] args) throws Exception
	{
		if (args.length < 2)
		{
			System.out.println("Please enter 2 input files on the command line.");
			System.exit(0);
		}
	ArrayList<String> pairs = new ArrayList<String>(); // Step1

	String dictionaryFile = args[0]; 
	String jumbledFile = args[1];
	
	BufferedReader dFile = new BufferedReader(new FileReader(dictionaryFile)); //Step2
	BufferedReader jFile = new BufferedReader(new FileReader(jumbledFile)); 

	while (dFile.ready())
	{ 
		String s = dFile.readLine();
		String newWord = dToCanon(s);
		String pairWord = newWord + " " + s; // canonical word first, then prints out word from dictionary file
		pairs.add(pairWord); // adds to pairs array
	}
	dFile.close();
	Collections.sort(pairs);
	ArrayList<String> dCanons = new ArrayList<String>();
	ArrayList<String> dWords = new ArrayList<String>();

	for (String line: pairs ) //Step4: creates a new String called line for every iteration of the loop and assigns a pairs word to it
	{
		String[] pair = line.split("\\s+");
		dCanons.add(pair[0]);
		dWords.add(pair[1]);
	}

	ArrayList<String> jWords = new ArrayList<String>(); //Step5
	while (jFile.ready())
	{
		String s = jFile.readLine();
		jWords.add(s);
		
	}
	Collections.sort(jWords); // puts into Canonical order
	jFile.close(); // close file 

	// Step6: use an enhanced for loop to assign every word from your jWords list into a var named jWord
	for (String jWord: jWords)
	{
		System.out.print(jWord + " ");
		String jCanon = dToCanon(jWord); // creates a jCanon string which is the canonical form of the jumbled word
		int index = Collections.binarySearch(dCanons, jCanon); // searches dCanons for jCanon & returns the index of where it is (if it's there)
		// if it's not there, it returns a negative index, in which you have to print a newline 
		if (index<0)
		{
			System.out.println(" "); 
		}
		else
		{
			int i=index;
			for(i=index; i>=0; i--) // decrementing "i" to work backwards
			{
				String dictionaryCanonical = dCanons.get(i); 
				//dCanons.get(i) = dic
				if (!dictionaryCanonical.equals(jCanon))
				{
					break;
				}
			}
			i++; 
			

			while(i<dCanons.size() && dCanons.get(i).equals(jCanon))
			{
				System.out.print(dWords.get(i)+ " ");
				i++;
			}

			System.out.println("");

		} // end else
	} // end enhanced for

	} // end MAIN

	static String dToCanon (String s )
	{
		char[] letters = s.toCharArray();
		Arrays.sort(letters);
		return new String(letters);
	}
	
} // end CLASS