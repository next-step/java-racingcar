package racingcar.util;

import java.util.Random;

public final class RandomUtils {
	public static final int DEFAULT_BOUND = 10;

	private static final Random RANDOM = new Random();

	private RandomUtils() {
	}

	public static int nextInt() {
		return nextInt(DEFAULT_BOUND);
	}

	public static int nextInt(int bound) {
		return RANDOM.nextInt(bound);
	}
}
