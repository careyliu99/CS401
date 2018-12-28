public class IndexOfTester
{
	public static void main( String[] args )
	{
		MyString line,key; 

//	.......................................................................
		line = new MyString( "dog followed by anything" );
		key =  new MyString( "dog" );	
		System.out.println( "      012345678901234567890123"); 
		System.out.println( "LINE: dog followed by anything" );
		System.out.println( "KEY:  dog" );
		System.out.println( "CORRECT ANSWER IS: 0" );
		System.out.print(   "YOUR ANSWER I S:   "  );
		System.out.println( line.indexOf(key));

//	.......................................................................
		line = new MyString( "dowg dawwg days gdodg days" );
		key =  new MyString( "dog" );	
		System.out.println("\n");
		System.out.println( "      01234567890123456789012345"); 
		System.out.println( "LINE: dowg dawwg days gdodg days" );
		System.out.println( "KEY:  dog" );

		System.out.println( "CORRECT ANSWER IS: -1" );
		System.out.print(   "YOUR ANSWER IS:    "  );
		System.out.println( line.indexOf(key) );		
		
//	.......................................................................
		line = new MyString( "dem dang doggone dayz" );
		key =  new MyString( "dog" );	
		System.out.println("\n");
		System.out.println( "      012345678901234567890"); 
		System.out.println( "LINE: dem dang doggone dayz" );
		System.out.println( "KEY:  dog" );

		System.out.println( "CORRECT ANSWER IS: 9" );
		System.out.print(   "YOUR ANSWER IS:    "  );
		System.out.println( line.indexOf(key) );
		
//	.......................................................................
		line = new MyString( "dem dang doggone dayz" );
		key =  new MyString( "ding dang dong a dag a diz daz dingle a dangle diggity dawgg!" );	
		System.out.println("\n");
		System.out.println( "      012345678901234567890"); 
		System.out.println( "LINE: dem dang doggone dayz" );
		System.out.println( "KEY:  ding dang dong a dag a diz daz dingle a dangle diggity dawgg!" );

		System.out.println( "CORRECT ANSWER IS: -1" );
		System.out.print(   "YOUR ANSWER IS:    ");
		System.out.println( line.indexOf(key) );
		
//	.......................................................................
		line = new MyString( "dog" );
		key =  new MyString( "dogg" );	
		System.out.println("\n");
		System.out.println( "      012"); 
		System.out.println( "LINE: dog" );
		System.out.println( "KEY:  dogg" );

		System.out.println( "CORRECT ANSWER IS: -1" );
		System.out.print(   "YOUR ANSWER IS:    ");
		System.out.println( line.indexOf(key) );		
		
	} // END MAIN

}