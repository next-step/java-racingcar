package study.racingcar.util;

import java.util.Random;

public class RandomNumberGenerator {

	public RandomNumberGenerator() {
		throw new AssertionError();
	}

	public static int RandomNumber() {
		Random random = new Random();
		return random.nextInt(10);
	}
}
