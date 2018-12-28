/* Fraction.java  A class (data type) definition file
   This file just defines what a Fraction is
   This file is NOT a program
   ** data members are PRIVATE
   ** method members are PUBLIC
*/
public class Fraction
{
	// DO NOT MODIFY THE CODE BELOW - USE AS GIVEN

	private int numer;
	private int denom;

	// ACCESSORS
	public int getNumer()
	{
		return numer;
	}
	public int getDenom()
	{
		return denom;
	}
	public String toString()
	{
		return numer + "/" + denom;
	}

	// MUTATORS
	public void setNumer( int n )
	{
		numer = n;
	}
	public void setDenom( int d )
	{
		if (d!=0)
			denom=d;
		else
		{
			// error msg OR exception OR exit etc.
		}
	}

	// DEFAULT CONSTRUCTOR - no args passed in
	public Fraction(  )
	{
		this( 0, 1 ); // "this" means call a fellow constructor
	}

	// 1 arg CONSTRUCTOR - 1 arg passed in
	// assume user wants whole number
	public Fraction( int n )
	{
		this( n, 1 ); // "this" means call a fellow constructor
	}

	// FULL CONSTRUCTOR - an arg for each class data member
	public Fraction( int n, int d )
	{
		int gcd = gcd(n,d); 
		setNumer(n/gcd); 		
		setDenom(d/gcd);
	}

	// COPY CONSTRUCTOR - takes ref to some already initialized Fraction object
	public Fraction( Fraction other )
	{
		this( other.numer, other.denom ); // call my full C'Tor with other Fraction's data
	}

	public Fraction add( Fraction other) //returns a Fraction that is the sum of the two Fractions.
	{	
		return new Fraction((this.numer*other.denom)+(other.numer*this.denom),(this.denom*other.denom));
	}
	public Fraction subtract( Fraction other) //returns a Fraction that is the difference between this Fraction minus the other Fraction.
	{
		return new Fraction((this.numer*other.denom)-(other.numer*this.denom),(this.denom*other.denom));
	}
	public Fraction multiply( Fraction other) //returns a Fraction that is the product of the two Fractions.
	{
		return new Fraction(this.numer*other.numer, other.denom*this.denom);
	}
	public Fraction divide( Fraction other) //returns a Fraction that is the quotient of the two Fractions.
	{
		return new Fraction((this.numer*other.denom),(this.denom*other.numer));
	}
	public Fraction reciprocal() //returns a Fraction that is the reciprocal of this Fractions.
	{
		return new Fraction(denom, numer);
	}

	private int gcd( int n, int d)
	{
		int gcd =n<d ? n : d; // same as:: if (n<d) gcd=n; else gcd=cd;
		while (gcd>0)
			if (n%gcd==0 && d%gcd==0) return gcd; else --gcd;
		return 1; // replace this line with your code
	}
}// EOF
