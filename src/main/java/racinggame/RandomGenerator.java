package racinggame;

import java.util.Random;

public class RandomGenerator {

	public static final int MAX_MOVE_POSITION = 9;

	private Random random;

	private RandomGenerator() {
		random = new Random();
	}

	private static class Singleton {
		private static final RandomGenerator instance = new RandomGenerator();
	}

	public static RandomGenerator getInstance() {
		return Singleton.instance;
	}

	public int getRandomPosition() {
		return getInstance().random.nextInt(MAX_MOVE_POSITION + 1);
	}
}
