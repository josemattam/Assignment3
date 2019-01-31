package assign03;

import java.util.Random;

/**
 * Timer for Simple Priority Queue
 * 
 * @author Mikey Jeanson and Jose Mattam, Erin Parker
 *
 */
public class PriorityQueueTimer {

	public static void main(String[] args) {
		// Do 100000 inserts or findMins
		int timesToLoop = 10000;

		// For each problem size n . . .
		for (int n = 10000; n <= 2000000; n += 100000) {

			SimplePriorityQueue<Integer> testQ = generateQueue(n);

			long startTime, midpointTime, stopTime;

			// First, spin computing stuff until one second has gone by.
			// This allows this thread to stabilize.
			startTime = System.nanoTime();
			while (System.nanoTime() - startTime < 1000000000) { // empty block
			}
			// Now, run the test.
			startTime = System.nanoTime();

			for (int i = 0; i < timesToLoop; i++) {
				testQ.findMin();
			}

			midpointTime = System.nanoTime();
			
			// Run an empty loop to capture the cost of running the loop.

			for(long i = 0; i < timesToLoop; i++) { // empty block
			}

			stopTime = System.nanoTime();

			// Compute the time, subtract the cost of running the loop
			// from the cost of running the loop and doing the lookups.
			// Average it over the number of runs.
			double averageTime = ((midpointTime - startTime) - (stopTime - midpointTime)) / (double) timesToLoop;

			System.out.println("findMIN\t" + n + "\t" + averageTime);
		}
	}

	private static SimplePriorityQueue<Integer> generateQueue(int size) {
		SimplePriorityQueue<Integer> testQ = new SimplePriorityQueue<Integer>();
		Random rng = new Random();

		int timesToLoop = 10000;
		
		for (int i = 0; i <= size - 1; i++) {

			testQ.insert(rng.nextInt());
		}

		long startTime, midpointTime, stopTime;

		startTime = System.nanoTime();
		while (System.nanoTime() - startTime < 1000000000) { // empty block
		}
		startTime = System.nanoTime();
		
		//timing this operation
		// Run an empty loop to capture the cost of running the loop.

		for(long i = 0; i < timesToLoop; i++) { // empty block
			testQ.insert(rng.nextInt());
		}

		midpointTime = System.nanoTime();
		
		for(long i = 0; i < timesToLoop; i++) { // empty block
		}

		stopTime = System.nanoTime();
		
		double averageTime = ((midpointTime - startTime) - (stopTime - midpointTime)) / (double) timesToLoop;

		System.out.println("INSERT\t" + size + "\t" + averageTime);
		
		return testQ;
	}
}
