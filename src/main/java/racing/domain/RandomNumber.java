package racing.domain;

import java.util.Random;

public class RandomNumber {
	private final static Random RANDOM = new Random();
	private final static int RANDOM_MAX_BOUND = 10;
	private int value;

	public int getRandomNumber() {
		value = RANDOM.nextInt(RANDOM_MAX_BOUND);
		return value;
	}

	public int getValue() {
		return value;
	}
}
