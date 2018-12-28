public class MyString
{
	private char[] letters;
	static final int NOT_FOUND = -1;

	public MyString( String other )
	{	
		letters = other.toCharArray();
	}
	public MyString( MyString other )
	{	
		letters = new char[other.length()];
		for (int i=0; i<other.length(); i++)
		{
			letters[i] = other.letters[i];
		}
	}	
	public int length()
	{
		return letters.length;
	}
	public char charAt(int index)
	{
		return letters[index];
	}
	int compareTo(MyString other)
	{
		int x = 0;
		if (this.length()>other.length()) // checking lengths
		{
			x = other.length();
		}
		else if (this.length()<other.length())
		{
			x = this.length();
		}
		//if (this.length() == other.length())


		for(int i=0;i<x;i++)
		{
		if (this.letters[i]>other.letters[i])
		{
			return 1;
		}
		
		else if (this.letters[i]<other.letters[i])
		{
			return -1;
		}	
		} // end for loop
		if(this.length() > other.length())
		{
			return 1;
		}
		else if (this.length() < other.length())
		{
			return -1;
		}
		return 0;
	}	
	public boolean equals(MyString other)
	{
		if (compareTo(other)==0) // calling compareTo to other
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public int indexOf(int startIndex, int ch)	
	{
		for(int i = startIndex; i<letters.length;i++)
		{
			if (ch==letters[i])
			{
				return i;
			}
		}
	return -1;	
	}
	/*public int indexOf(MyString other)
	{	
		int indexofFirst = indexOf(0, other.charAt(0));
		
		if (indexofFirst == NOT_FOUND)
		{
			return NOT_FOUND;
		}
		while(indexofFirst != NOT_FOUND)
		{
			if (look(other, indexofFirst)) // calling look method
			{
				return indexofFirst;
			}

			indexofFirst = indexOf(indexofFirst+1, other.charAt(0)); // if look fails, it increments it by 1 then does it again since in while loop
		}
		return -1; 		
	}*/
	public int indexOf(MyString key)
       {
	int indOf1stKeyLetter = indexOf( 0, key.charAt(0) );
	while (indOf1stKeyLetter != NOT_FOUND)

     {
		 if ( isMatch( indOf1stKeyLetter, key ) ) return indOf1stKeyLetter;
        indOf1stKeyLetter = indexOf( indOf1stKeyLetter+1, key.charAt(0) );
     }
         return NOT_FOUND;
     }
    public boolean isMatch( int startInd, MyString key )
    {
       if ( startInd+key.length() > this.length() ) return false;
       for ( int k = 0 ; k < key.length() ; ++k )
    	if (this.letters[startInd+k] != key.letters[k]) return false;
     return true;
     }
	public String toString()
	{
		String s = new String(letters);
		return s;
	}

	private boolean look(MyString other, int index)  // creating this private method - looks whether the other string has a match
	{
		int otherLength = other.length();
		for (int i=index; i<otherLength && i<this.letters.length; i++)
		{

			if(other.charAt(i)!=letters[i])
			{
				return false;
			}
		}
			if (otherLength > this.letters.length)
			{
				return false;
			}
			if (otherLength < this.letters.length)
			{
				return false;
			}
		return true; 
	}
} // END MYSTRING CLASS
