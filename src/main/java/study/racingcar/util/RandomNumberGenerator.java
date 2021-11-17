package study.racingcar.util;

import java.util.Random;

public class RandomNumberGenerator {

	public static final int RANDOM_MAX_VALUE = 10;

	public RandomNumberGenerator() {
		throw new AssertionError();
	}

	public static int generate() {
		Random random = new Random();
		return random.nextInt(RANDOM_MAX_VALUE);
	}
}
