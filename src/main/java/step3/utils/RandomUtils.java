package step3.utils;

import java.util.Random;

public class RandomUtils {
	private static final int RANDOM_BOUND = 10;

	public static int randomNumber() {
		return new Random().nextInt(RANDOM_BOUND);
	}
}
