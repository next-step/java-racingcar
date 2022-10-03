package racing.domain;

import java.util.Random;

public class RandomNumber {
	private final static Random RANDOM = new Random();
	private final static int RANDOM_MAX_BOUND = 10;

	public int getRandomNumber() {
		return RANDOM.nextInt(RANDOM_MAX_BOUND);
	}
}
