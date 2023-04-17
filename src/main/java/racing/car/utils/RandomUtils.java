package racing.car.utils;

import java.util.Random;

public class RandomUtils {

	private static final int MOVE_BOUND_MAXIMUM = 9;
	private static final Random random = new Random();

	private RandomUtils() {
	}

	public static int getRandomValue() {
		return random.nextInt(MOVE_BOUND_MAXIMUM + 1);
	}
}
