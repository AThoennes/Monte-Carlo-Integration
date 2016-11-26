/**
 * The Monte Carlo Integration Method finds 
 * the area of a curve based on random points 
 * that are drawn. In this example, it is the
 * area of a circle that I find. It is easy to 
 * visualize this as a dart board and you throw
 * 10,000 darts at the board. You then use all the 
 * darts you threw to help calculate the area of the 
 * board.
 * 
 * @author Alex Thoennes
 *
 */
public class MonteCarloMain 
{
	public static void main(String [] args)
	{
		// monte carlo object with the number of iterations to perform
		MonteCarloIntegration mci = new MonteCarloIntegration(10000);
		
		// find the area of the curve
		mci.run();
	}
}
