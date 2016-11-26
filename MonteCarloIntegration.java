import java.util.Random;

/**
 * The Monte Carlo Integration method is a way 
 * of finding the area of a curve based on how 
 * many points lie in the desired area. In this 
 * example, the area of a circle is found. The 
 * circle is centered at (1,1) with the whole 
 * graph starting at (0,0) and ending at (2,2).
 * 
 * @author Alex Thoennes
 *
 */
public class MonteCarloIntegration 
{
	// number of specified iterations
	private int iterations;

	// area of the curve based on the 
	// points that are in the right space
	double area;
	
	// all darts thrown
	double totalDarts;
	
	// all darts that hit the board
	double dartsHit;
	
	// all darts that missed the board
	double dartsMissed;
	
	/**
	 * Constructor that takes in the number of
	 * iterations to run
	 * 
	 * @param iterations
	 */
	MonteCarloIntegration(int iterations)
	{
		// intialize the variables
		this.iterations = iterations;
		area = 0.0;
		totalDarts = 0;
		dartsHit = 0;
		dartsMissed = 0;
	}
	
	/**
	 * Perform the monte carlo integration function.
	 * The function generates a random point in the
	 * given space (in this case it's a square with
	 * a circle in it) and then checks to see if the 
	 * point generated is in the circle. If it is then
	 * increment dartsHit otherwise increment dartsMissed.
	 * 
	 */
	public void run()
	{
		// counters
		//
		// count the iterations
		int current = 0;
		
		// count every hundredth iteration
		int count = 0;
		
		// run for the specified number of iterations
		while (current < iterations)
		{
			// check if the dart is in the circle
			if (Math.pow((getRandX() - 1), 2.0) + Math.pow((getRandY() - 1), 2.0) < 1)
			{
				// if it is in the circle then it hit the board
				dartsHit ++;
			}
			else
			{
				// otherwise it missed the board
				dartsMissed ++;
			}
			
			if (count == 100)
			{
				// print out number of points in circle
				System.out.println("\nHit: " + dartsHit);
				
				// total number of points overall
				System.out.println("Total: " + totalDarts);
				
				// current area estimate based on current point count
				area = (dartsHit / (dartsMissed + dartsHit)) * 4;
				System.out.println("Area: " + area);
				
				// reset the counter
				count = 0;
			}
			
			// handle the increments
			count ++;
			current ++;
			totalDarts ++;
		}
	}
	
	/**
	 * Generate a random double x and then
	 * multiply it by 2 to get all the values
	 * within the required area
	 * 
	 * @return
	 */
	private double getRandX()
	{
		Random rand = new Random();
		
		return rand.nextDouble() * 2;
	}
	
	/**
	 * Generate a random double y and then
	 * multiply it by 2 to get all the values
	 * within the required area
	 * 
	 * @return
	 */
	private double getRandY()
	{
		Random rand = new Random();
		
		return rand.nextDouble() * 2;
	}
}
