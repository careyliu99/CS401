/* Project3.java  InsertInOrder with bSearch optimization to compute insertion index */
// STUDENT STARTER FILE
// YOUR NAME/ID: Carey Liu/4197169


import java.util.*;
import java.io.*;

public class Project3
{
	static final int INITIAL_CAPACITY = 5;

	public static void main( String args[] ) throws Exception
	{
		if (args.length < 1 )
		{
			System.out.println("ERROR: Must enter an int on cmd line (i.e. # of random ints to put in array)\n");
			System.exit(0);
		}

		int numInts2generate = Integer.parseInt( args[0] );

		Random randGen =  new Random( 17 );
		int[] arr = new int[INITIAL_CAPACITY];
		int count= 0;
		for ( int i = 0 ; i<numInts2generate ; ++i)
		{
			if ( count==arr.length ) arr = upSizeArr(arr);
			insertInOrder( arr, count++, 1 + randGen.nextInt(1000) );
		}

		arr=trimArr(arr,count);
		printArray( arr );  

	} 

	static void printArray( int[] arr  )
    {
        for( int i=0 ; i<arr.length ;++i )
            System.out.print(arr[i] + " " );
        System.out.println();
    }

	static int[] upSizeArr( int[] fullArr )
	{
		int[] upSizedArr = new int[ fullArr.length * 2 ];
		for ( int i=0; i<fullArr.length ; ++i )
			upSizedArr[i] = fullArr[i];
		return upSizedArr;
	}

	static int[] trimArr( int[] oldArr, int count )
	{
		int[] trimmedArr = new int[ count ];
		for ( int i=0; i<count ; ++i )
			trimmedArr[i] = oldArr[i];
		return trimmedArr;
	}
	static void insertInOrder( int[] arr, int count, int newVal   )
	{
		int index = bSearch(arr, count, newVal);
		if(index<0)
		{
			index=(index*-1)-1; //fixes out of bounds error
		}
		for (int i=count-1; i>=index;i--)
		{
			arr[i+1] = arr[i];
		}
		arr[index] = newVal;
	}
	static int bSearch(int arr[], int count, int key)
	{
		int lo = 0;
		int hi = count-1;
		while (lo<=hi)
		{
			int mid = (hi+lo)/2; // makes it overflow invulnerable
			if (arr[mid] == key)
			{
				return mid;
			}
			if (arr[mid] < key)
			{
				//hi = mid-1;
				lo = mid +1;
			}
			else
			{
				//lo = mid+1;
				hi = mid-1;
			}
		}

		return (lo+1)*-1;
	}
	
}