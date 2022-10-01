package racing.model;

import java.util.Random;

public class RandomNumber {

	private static final int RANGE_OF_RANDOM_NUMBER = 10;
	private static final Random random = new Random();

	public int getRandomNumber() {
		return random.nextInt(RANGE_OF_RANDOM_NUMBER);
	}
}
