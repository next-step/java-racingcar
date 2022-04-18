package util;

import java.util.Random;

public class RandomUtil {
	private static final Random RANDOM = new Random();
	public static int createRandomNumber(int min, int max) {
		return RANDOM.nextInt(min + max) + min;
	}
}
