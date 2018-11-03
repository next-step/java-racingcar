package racinggame;

import java.util.Random;

public class RandomGenerator {

	public static final int MAX_MOVE_POSITION = 9;

	private Random random;

	public RandomGenerator() {
		random = new Random();
	}

	public int getRandomPosition() {
		return random.nextInt(MAX_MOVE_POSITION + 1);
	}
}
