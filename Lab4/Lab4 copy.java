import java.util.*;
import java.io.*;


public class Lab4
{
	public static void main (String[] args) throws Exception
	{
	
	if (args.length < 1)
	{
		System.out.println("Please enter an input file");
		System.exit(0);
	}

	String infileName = args[0];

	BufferedReader infile = new BufferedReader(new FileReader(infileName));
	ArrayList<String> wordList = new ArrayList<String>();

	while(infile.ready())
	{

		wordList.add(infile.readLine());
		Collections.sort(wordList);
	}
	// sort our arraylist
	for (String word: wordList)
	{
		System.out.println(word+" " +canonical(word));
	}
} // end MAIN
	public static String canonical(String word)
	{
		char[] canonicalWord = word.toCharArray();
		Arrays.sort(canonicalWord);
		String cWord = new String(canonicalWord);
		return cWord;
	}


} // end CLASS brace