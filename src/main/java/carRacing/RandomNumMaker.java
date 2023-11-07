package carRacing;

import java.util.Random;

public class RandomNumMaker {

	private static final int MINIMUM_TO_MOVE = 4;
	private static final int MAXIMUM_BOUND = 10;
	private Random random = new Random();

	public boolean isAboveBoundary() {
		return makeRanNum() >= MINIMUM_TO_MOVE;
	}

	public int makeRanNum() {
		return random.nextInt(MAXIMUM_BOUND);
	}
}
