package racingcar;

import java.util.Random;

public class RandomNumberGenerator {
	private static Random random = new Random();
	private static final int RANDOM_NUMBER_LIMIT = 10;

	public static int createRandomNumber() {
		return random.nextInt(RANDOM_NUMBER_LIMIT);
	}
}
