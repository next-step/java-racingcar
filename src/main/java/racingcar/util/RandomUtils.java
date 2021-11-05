package racingcar.util;

import java.util.Random;

import racingcar.exception.UtilCreationException;

public final class RandomUtils {
	public static final int DEFAULT_BOUND = 10;

	private static final Random RANDOM = new Random();

	private RandomUtils() {
		throw new UtilCreationException();
	}

	public static int nextInt() {
		return nextInt(DEFAULT_BOUND);
	}

	public static int nextInt(int bound) {
		return RANDOM.nextInt(bound);
	}
}
