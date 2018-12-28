/*
	Coin.java THIS IS THE ONLY FILE YOU HAND IN
	THERE IS NO MAIN METHOD IN THIS CLASS!
*/
import java.util.Random;
public class Coin
{
	private Random rand = null;
	private int heads = 0;
	private int tails = 0;

	public Coin()
	{
		rand = new Random();
	}

	public Coin(int seed)
	{
		rand = new Random(seed);
	}
	public char flip() // flip needs to return something
	{
		int coinFlip = rand.nextInt(2);
		if (coinFlip==0)
		{
			tails++;
			return 'T';
		}

		else
		{
			heads++;
			return 'H';
		}
	}
	public int getNumHeads()
	{
		return heads;
	}

	public int getNumTails()
	{
		return tails;
	}

	public void reset()
	{
		heads = 0;
		tails = 0;
	}
} // END COIN CLASS