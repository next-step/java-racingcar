package carRacing;

import java.util.Random;

public class RandomNumMaker {

	private static final int MAXIMUM_BOUND = 10;

	private Random random = new Random();

	public int makeRandomNumber() {
		return random.nextInt(MAXIMUM_BOUND);
	}
}
