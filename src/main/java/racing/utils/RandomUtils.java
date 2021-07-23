package racing.utils;

import java.util.Random;

public class RandomUtils {

	private RandomUtils() {

	}

	public static int getRandomValue() {
		Random random = new Random();

		return random.nextInt(10);
	}
}
